package com.example.ems_app.EventManagementApp.service;

import com.example.ems_app.EventManagementApp.model.Users;
import com.example.ems_app.EventManagementApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

//    public String verify(Users user) {
//        Authentication authentication =
//                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//        if(authentication.isAuthenticated())
//            return "Token Generated Successfully After successful Login: " + jwtService.generateToken(user.getUsername());
//
//        return "Authentication failed";
//    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(authentication.isAuthenticated())
            return "Token Generated Successfully After successful Login: " + jwtService.generateToken(user.getEmail());

        return "Authentication failed";
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}
