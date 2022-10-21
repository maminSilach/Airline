package com.example.bookingofairtickets.Controller;

import com.example.bookingofairtickets.Models.Flights;
import com.example.bookingofairtickets.Repository.RepositoryFlights;
import com.example.bookingofairtickets.Repository.RepositoryTickets;
import com.example.bookingofairtickets.Service.ServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/airline/admin")
public class ControllerForAdmin {
    ServiceImpl service;
    RepositoryTickets repositoryTickets;
    RepositoryFlights repositoryFlights;
    public ControllerForAdmin(ServiceImpl service,RepositoryTickets repositoryTickets,RepositoryFlights repositoryFlights) {
        this.service = service;
        this.repositoryTickets = repositoryTickets;
        this.repositoryFlights = repositoryFlights;
    }

    @GetMapping("/")
    String mainPage(HttpSession session){
        session.setAttribute("loginAdmin", SecurityContextHolder.getContext().getAuthentication().getName());
        return "mainPageForAdmin";
    }

    @GetMapping("/flights")
    String flightsForAdmin(Model model){
        List<Flights> flights = repositoryFlights.findAll().stream().filter((a) -> a.getUser()==null).toList();
        model.addAttribute("allFlights",flights);
        return "flightsForAdmin";
    }
    @GetMapping("/tickets")
    String ticketsForAdmin(Model model){
        model.addAttribute("allTickets",repositoryTickets.findAll());
        return "ticketsForAdmin";
    }
    @GetMapping(value = "/deleteFlight")
    String delete(@RequestParam("Id") Integer id){
        repositoryFlights.deleteById(id);
        return "redirect:/airline/admin/flights";
    }

    @GetMapping("/addFlight")
    String addTicket(@RequestParam(value = "Id",required = false) Integer id, Model model,Flights flights){
        if(id!=null){
            flights.setId(id);
            model.addAttribute("flights",flights);
            return "addFlightForm";
        }
        model.addAttribute("flights",flights);
        return "addFlightForm";
    }
    @PostMapping("/saveFlight")
    String saveFlight(@Valid @ModelAttribute() Flights flight,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addFlightForm";
        }
      repositoryFlights.save(flight);
        return "redirect:/airline/admin/flights";
    }

}
