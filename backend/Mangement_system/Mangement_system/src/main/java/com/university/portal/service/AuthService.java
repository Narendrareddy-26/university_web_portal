package com.university.portal.service;

import com.university.portal.config.JwtUtil;
import com.university.portal.model.User;
import com.university.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwt;

    public String login(User u) {

        User db = repo.findByEmail(u.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!db.getPassword().equals(u.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwt.generateToken(db.getEmail());
    }

    public User register(User u) {
        return repo.save(u);
    }
}
