package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {
    private final Map<String, String> otpStore = new HashMap<>(); // Store OTPs temporarily

    public void sendOtp(String email) {
        String otp = generateOtp();
        otpStore.put(email, otp);
        // Logic to send OTP to the user's email
        System.out.println("Sending OTP: " + otp + " to email: " + email);
    }

    public boolean validateOtp(String email, String otp) {
        return otp.equals(otpStore.get(email));
    }

    private String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // Generate a 6-digit OTP
    }

	public int generateOTP(String username) {
		// TODO Auto-generated method stub
		return 0;
	}
}