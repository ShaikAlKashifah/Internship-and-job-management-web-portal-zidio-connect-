package com.zidio.connect.model;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    private String type;
    @Column(length=2000)
    private String description;
    public Job() {}
    public Job(String title, String company, String location, String type, String description) {
        this.title = title; this.company = company; this.location = location; this.type = type; this.description = description;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
