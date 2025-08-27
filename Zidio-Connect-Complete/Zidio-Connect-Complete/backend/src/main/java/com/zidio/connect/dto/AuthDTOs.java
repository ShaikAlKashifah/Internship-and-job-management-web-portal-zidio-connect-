package com.zidio.connect.dto;
public class AuthDTOs {
    public static class RegisterRequest {
        public String email; public String password; public String fullName; public String role;
    }
    public static class LoginRequest {
        public String email; public String password;
    }
}