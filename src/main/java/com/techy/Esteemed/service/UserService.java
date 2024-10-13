package com.techy.Esteemed.service;

import com.techy.Esteemed.model.Role;
import com.techy.Esteemed.model.User;
import com.techy.Esteemed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(User user){
        return userRepository.save(user);
    }


    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void registerUser(String username, String password, String email) {
        // Create a new user entity
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Hash the password
        user.setEmail(email);
        user.setRole(Role.STUDENT); // Set a default role, adjust as necessary

        userRepository.save(user); // Save the user to the database
    }

    // Additional user-related methods
}
