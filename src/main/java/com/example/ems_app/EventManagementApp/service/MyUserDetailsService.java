package com.example.ems_app.EventManagementApp.service;

import com.example.ems_app.EventManagementApp.model.MyUserDetails;
import com.example.ems_app.EventManagementApp.model.Users;
import com.example.ems_app.EventManagementApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(username);

        Users user = userRepository.findByEmail(username);

        if(user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new MyUserDetails(user);
    }
}
