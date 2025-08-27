package com.zidio.connect.model;

import jakarta.persistence.*;

@Entity
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long jobId;
    private String status;

    public Application() {}
    public Application(Long userId, Long jobId, String status) {
        this.userId = userId; this.jobId = jobId; this.status = status;
    }
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
