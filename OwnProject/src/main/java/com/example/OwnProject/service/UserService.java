package com.example.OwnProject.service;

import com.example.OwnProject.Entites.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User loadUserByUsername(String s);
    public User findByUsername(String receiver);
    //public Set<User> findByCurrent(User user);
}
