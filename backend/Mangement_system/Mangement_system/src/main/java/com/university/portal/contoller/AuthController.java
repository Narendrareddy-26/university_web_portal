package com.university.portal.contoller;

import com.university.portal.model.User;
import com.university.portal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return service.register(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        return service.login(u);
    }
}
