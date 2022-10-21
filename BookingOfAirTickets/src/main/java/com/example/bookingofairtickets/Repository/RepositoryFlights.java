package com.example.bookingofairtickets.Repository;

import com.example.bookingofairtickets.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RepositoryFlights extends JpaRepository<Flights,Integer> {

    void deleteById(Integer id);
    Flights getFlightsById(Integer id);
    List<Flights> findAll();
}