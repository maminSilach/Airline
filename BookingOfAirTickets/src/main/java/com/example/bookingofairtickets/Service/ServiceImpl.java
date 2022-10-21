package com.example.bookingofairtickets.Service;

import com.example.bookingofairtickets.Models.Role;

import com.example.bookingofairtickets.Models.User;
import com.example.bookingofairtickets.Repository.RepositoryTickets;
import com.example.bookingofairtickets.Repository.RepositoryUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

@Transactional
@Service
public class ServiceImpl implements ServiceForTickets, ServiceForUser {
    RepositoryTickets repositoryTickets;
    EntityManager entityManager;
    RepositoryUser repositoryUser;
    PasswordEncoder passwordEncoder;

    public ServiceImpl(RepositoryTickets repositoryTickets,
                       EntityManager entityManager, RepositoryUser repositoryUser, PasswordEncoder passwordEncoder) {
        this.repositoryTickets = repositoryTickets;
        this.entityManager = entityManager;
        this.repositoryUser = repositoryUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean saveUser(User user) {
        String userEmail = user.getEmail();
        if (repositoryUser.findByEmail(userEmail) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repositoryUser.save(user);
        return true;
    }

    @Override
    public void deleteByEmail(String email) {
        repositoryTickets.deleteByEmail(email);
    }
}
