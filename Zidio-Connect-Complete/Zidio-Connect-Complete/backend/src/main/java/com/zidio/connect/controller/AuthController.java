package com.zidio.connect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.connect.repo.UserRepository;
import com.zidio.connect.model.User;
import com.zidio.connect.model.Role;
import com.zidio.connect.dto.AuthDTOs;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final UserRepository users;
    public AuthController(UserRepository users) { this.users = users; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDTOs.RegisterRequest req) {
        if (users.findByEmail(req.email).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error","Email already exists"));
        }
        Role role = Role.STUDENT;
        try { if (req.role != null) role = Role.valueOf(req.role.toUpperCase()); } catch(Exception ignored){}
        User u = new User(req.email, req.password, role, req.fullName);
        users.save(u);
        return ResponseEntity.ok(Map.of("message","Registered", "userId", u.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTOs.LoginRequest req) {
        return users.findByEmail(req.email)
          .filter(u -> u.getPassword().equals(req.password))
          .<ResponseEntity<?>>map(u -> ResponseEntity.ok(Map.of("message","OK","userId", u.getId(), "role", u.getRole().toString(), "fullName", u.getFullName())))
          .orElse(ResponseEntity.status(401).body(Map.of("error","Invalid credentials")));
    }
}
