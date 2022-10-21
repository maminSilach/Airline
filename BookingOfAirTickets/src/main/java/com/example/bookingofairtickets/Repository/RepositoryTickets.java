package com.example.bookingofairtickets.Repository;

import com.example.bookingofairtickets.Models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RepositoryTickets extends JpaRepository<Tickets,Integer> {
     List<Tickets> findAll();
     void deleteByEmail(String email);

}
