package com.example.bookingofairtickets.Repository;

import com.example.bookingofairtickets.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryUser extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
