package com.example.ems_app.EventManagementApp.repository;

import com.example.ems_app.EventManagementApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

//    Users findByUsername(String username);
        Users findByEmail(String email);
}
