package com.techy.Esteemed.controller;

import com.techy.Esteemed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService; // Inject the UserService

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String Registration() {
        return "register"; // Return the registration view
    }

    @GetMapping("/")
    public String home(){
        return "home"; // A general home page
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email) {
        userService.registerUser(username, password, email); // Use the UserService to register the user
        return "redirect:/"; // Redirect after registration
    }
}
