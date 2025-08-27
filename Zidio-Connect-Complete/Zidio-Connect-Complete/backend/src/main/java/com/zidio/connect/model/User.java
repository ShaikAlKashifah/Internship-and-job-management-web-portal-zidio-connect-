package com.zidio.connect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;
    private String fullName;

    public User() {}
    public User(String email, String password, Role role, String fullName) {
        this.email = email; this.password = password; this.role = role; this.fullName = fullName;
    }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
