package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
	public User getUser;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public User registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user
        return userRepository.save(user);
    }
    
    public User getUserByUsername(String username) {
        System.out.println("Looking for user with username: " + username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username '" + username + "' not found"));
    }

    
    
    
    
    
    public User updateEmail(String username, String newEmail) {
        User user = getUserByUsername(username);
        
        // Ensure newEmail is not null or blank
        if (newEmail == null || newEmail.isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty");
        }
        
        // Check if the new email already exists
        if (userRepository.findByEmail(newEmail).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }
        
        // Update the email
        user.setEmail(newEmail);
        
        // Save the user with the updated email
        return userRepository.save(user);
    }

    

    public void updatePassword1(String username, String newPassword, String username2) {
        User user = getUserByUsername(username);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    
    
    
    
   
    
    public User updateUsername(String currentUsername, String newUsername) {
        // Ensure the user exists
        User user = getUserByUsername(currentUsername);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Ensure the new username is not null or empty
        if (newUsername == null || newUsername.isEmpty()) {
            throw new RuntimeException("Username cannot be null or empty");
        }

        // Check if the new username is already taken
        if (userRepository.findByUsername(newUsername).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Update the username
        user.setUsername(newUsername);
        return userRepository.save(user);
    }

    
    
    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = getUserByUsername(username);
        
        // Check if the old password is correct
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("Old password is incorrect");
        }
        
        // Update the password and save
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    
    
    
}