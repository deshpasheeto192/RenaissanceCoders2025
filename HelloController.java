package com.codegames.renaissancecoders.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Home Page!";
    }
    // A simple health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is up and running!");
    }

    // An optional "status" endpoint to check service activity or state
    @GetMapping("/status")
    public ResponseEntity<String> serviceStatus() {
        // You can include logic to check if all systems are working, for example:
        String status = "Webhook Processor: Active\n" +
                "Tempo API Integration: Connected\n" +
                "Last Processed: " + LocalDateTime.now();
        return ResponseEntity.ok(status);
    }
}