package com.example.ems_app.EventManagementApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @GetMapping("/register")
    public ResponseEntity<String> customerRegisterPage() {
        return ResponseEntity.ok("Customer Registration Page");
    }

    @GetMapping("/login")
    public ResponseEntity<String> customerLoginPage() {
        return ResponseEntity.ok("Customer Login Page");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboard() {
        return ResponseEntity.ok("Welcome to the Customer Dashboard!");
    }
}
