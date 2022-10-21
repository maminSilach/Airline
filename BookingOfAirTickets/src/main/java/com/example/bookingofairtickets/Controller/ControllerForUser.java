package com.example.bookingofairtickets.Controller;



import com.example.bookingofairtickets.Models.Flights;
import com.example.bookingofairtickets.Models.Tickets;
import com.example.bookingofairtickets.Models.User;
import com.example.bookingofairtickets.Repository.RepositoryFlights;
import com.example.bookingofairtickets.Repository.RepositoryTickets;
import com.example.bookingofairtickets.Repository.RepositoryUser;
import com.example.bookingofairtickets.Service.ServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;



@Controller
@RequestMapping("/airline")
public class ControllerForUser {

    ServiceImpl service;
    RepositoryUser repositoryUser;
    RepositoryFlights repositoryFlights;
    RepositoryTickets repositoryTickets;

    public ControllerForUser(ServiceImpl service,
                             RepositoryUser repositoryUser,
                             RepositoryFlights repositoryFlights,
                             RepositoryTickets repositoryTickets) {
        this.service = service;
        this.repositoryUser = repositoryUser;
        this.repositoryFlights = repositoryFlights;
        this.repositoryTickets = repositoryTickets;
    }

    @GetMapping("/")
    String mainPage(HttpSession session){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("login",login);
    return "mainPageForUser";

    }
    @GetMapping("/registration")
    String registration(User user){
        return "registration";
    }
    @PostMapping("/registration")
    String createUser(@Valid @ModelAttribute() User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        service.saveUser(user); // обработать ошибку, ошибка дает false емли такой email уже зареган
        return "redirect:/airline/";
    }

    @GetMapping("/flights")
    String fightsForUser(Model model){
       model.addAttribute("allTickets",repositoryTickets.findAll());
        return "flightsForUser";
    }
    @GetMapping("/reserveFlight")
    String bookFlight(Model model){
        List<Flights> flights = repositoryFlights.findAll().stream().filter((a) -> a.getUser()==null).toList();
        if(flights.isEmpty()){
            model.addAttribute("errorMessage",
                    "На данный момент нет доступных рейсов для брони, зайдите позже");
        }
        model.addAttribute("allFlights",flights);
        return "reserveFlight";
    }

    @GetMapping("/login")
    String login(){
        return "login";
    }
    @GetMapping("/logout")
    String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/airline/";
    }

    @RequestMapping("/reserve{id}")
    String reserve(@PathVariable("id") Integer id,
                   HttpSession session, Model model){
        Flights flights = repositoryFlights.getFlightsById(id);
        User user = repositoryUser.findByEmail(session.getAttribute("login").toString());
        if(user.getFlights() != null){
            model.addAttribute("errorMessage","На вашем аккаунте уже имеется забронированный рейс");
            return "errorPage";
        }
        Tickets tickets = new Tickets(user.getName(),user.getEmail(),flights.getTime(),
                flights.getType(),flights.getFromCity(),flights.getToCity(),
                flights.getFromCountry(),flights.getToCountry(),flights.getPrice());
        session.setAttribute("ticket",tickets);
        flights.setUser(user);
        repositoryFlights.save(flights);
        repositoryTickets.save(tickets);
        return "redirect:/airline/";
    }

    @GetMapping("/infoAboutReserve")
    String infoAboutReserve(@SessionAttribute("login")String login,
                            Model model)  {
        User user = repositoryUser.findByEmail(login);
        if(user.getFlights() == null){
            model.addAttribute("errorMessage","У вас нет забронированных рейсов");
            return "errorPage";
        }
        model.addAttribute("reserveFlights",user.getFlights());
        return "infoAboutReserve";
    }

    @GetMapping("/cancel{id}")
    String cancelReserve(@PathVariable("id") Integer id){
        service.deleteByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Flights flights = repositoryFlights.getFlightsById(id);
        flights.setUser(null);
        repositoryFlights.save(flights);
        return "redirect:/airline/";
    }
}
