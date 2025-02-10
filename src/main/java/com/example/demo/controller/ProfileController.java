package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequestMapping("/api/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    // Get user data by username
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserData(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Update username
    @PutMapping("/update-username")
    public ResponseEntity<?> updateUsername(@RequestBody Map<String, String> request) {
        try {
            String oldUsername = request.get("oldUsername");
            String newUsername = request.get("newUsername");
            User updatedUser = userService.updateUsername(oldUsername, newUsername);
            return ResponseEntity.ok(Map.of("message", "Username updated successfully", "user", updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    
 // Update email
    @PutMapping("/update-email")
    public ResponseEntity<?> updateEmail(@RequestBody Map<String, String> request) {
        try {
            String oldEmail = request.get("oldEmail");
            String newEmail = request.get("newEmail");
            String username = request.get("username"); // Assuming you still want to verify the username
            User updatedUser  = userService.updateEmail(username, newEmail);
            return ResponseEntity.ok(Map.of("message", "Email updated successfully", "user", updatedUser ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    
    
    
    
  

    // Forgot password - Send OTP to email
    @PutMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            // Implement OTP generation and email sending logic here
            // For now, just return a success message
            return ResponseEntity.ok(Map.of("message", "OTP sent to your email"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Reset password with OTP
    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            String otp = request.get("otp");
            String newPassword = request.get("newPassword");
            // Implement OTP verification and password reset logic here
            // For now, just return a success message
            return ResponseEntity.ok(Map.of("message", "Password reset successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}