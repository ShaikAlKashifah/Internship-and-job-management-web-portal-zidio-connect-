package com.zidio.connect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.connect.repo.JobRepository;
import com.zidio.connect.model.Job;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobController {
    private final JobRepository jobs;
    public JobController(JobRepository jobs) { this.jobs = jobs; }

    @GetMapping public List<Job> all() { return jobs.findAll(); }
    @PostMapping public Job create(@RequestBody Job j) { return jobs.save(j); }
    @GetMapping("/{id}") public ResponseEntity<Job> get(@PathVariable Long id) {
        return jobs.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}") public ResponseEntity<Job> update(@PathVariable Long id, @RequestBody Job j) {
        return jobs.findById(id).map(e -> {
            e.setTitle(j.getTitle()); e.setCompany(j.getCompany()); e.setLocation(j.getLocation());
            e.setType(j.getType()); e.setDescription(j.getDescription());
            return ResponseEntity.ok(jobs.save(e));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id) {
        jobs.deleteById(id); return ResponseEntity.noContent().build();
    }
}
