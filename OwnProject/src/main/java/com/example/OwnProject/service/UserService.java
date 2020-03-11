package com.example.OwnProject.service;

import com.example.OwnProject.domain.User;
import com.example.OwnProject.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User loadUserByUsername(String s);
    public User findByUsername(String receiver);
}
