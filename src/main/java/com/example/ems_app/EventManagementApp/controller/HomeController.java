package com.example.ems_app.EventManagementApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping("/homepage")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to the Event Management System!");
    }

    @GetMapping("/session")
    public String greet(HttpServletRequest request){
        return "Welcome to Spring Security with session Id: " + request.getSession().getId();
    }

    @GetMapping("/about")
    public ResponseEntity<String> aboutPage() {
        return ResponseEntity.ok("About Us: This is an event management platform.");
    }

    @GetMapping("/contact")
    public ResponseEntity<String> contactPage() {
        return ResponseEntity.ok("Contact Us: support@eventapp.com");
    }
}