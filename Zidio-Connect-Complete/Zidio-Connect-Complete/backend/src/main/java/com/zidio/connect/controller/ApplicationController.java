package com.zidio.connect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.connect.repo.ApplicationRepository;
import com.zidio.connect.model.Application;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin
public class ApplicationController {
    private final ApplicationRepository apps;
    public ApplicationController(ApplicationRepository apps){ this.apps = apps; }

    @PostMapping("/apply")
    public Application apply(@RequestBody Application a) {
        if (a.getStatus()==null) a.setStatus("APPLIED");
        return apps.save(a);
    }
    @GetMapping("/user/{userId}")
    public List<Application> byUser(@PathVariable Long userId) {
        return apps.findByUserId(userId);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String,String> body) {
        return apps.findById(id).map(a -> {
            a.setStatus(body.getOrDefault("status","APPLIED"));
            apps.save(a);
            return ResponseEntity.ok(Map.of("message","updated"));
        }).orElse(ResponseEntity.notFound().build());
    }
}
