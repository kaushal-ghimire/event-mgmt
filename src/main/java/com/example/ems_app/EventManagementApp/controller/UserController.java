package com.example.ems_app.EventManagementApp.controller;

import com.example.ems_app.EventManagementApp.model.Users;
import com.example.ems_app.EventManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

    @GetMapping("/user")
    public List<Users> getAllUsers() {
        return userService.getUsers();
    }
}
