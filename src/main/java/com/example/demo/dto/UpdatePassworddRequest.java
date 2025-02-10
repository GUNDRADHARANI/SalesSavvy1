package com.example.demo.dto;
//DTO for updating password with OTP
class UpdatePasswordRequest {
 private String username;
 private String newPassword;
 private String otp;

 // Getters and Setters
 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public String getNewPassword() {
     return newPassword;
 }

 public void setNewPassword(String newPassword) {
     this.newPassword = newPassword;
 }

 public String getOtp() {
     return otp;
 }

 public void setOtp(String otp) {
     this.otp = otp;
 }
}
