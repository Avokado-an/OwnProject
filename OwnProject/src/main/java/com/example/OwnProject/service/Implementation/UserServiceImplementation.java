package com.example.OwnProject.service.Implementation;

import com.example.OwnProject.domain.User;
import com.example.OwnProject.repos.UserRepo;
import com.example.OwnProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepo userRepo;

    @Autowired
    public void setRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public User findByUsername(String receiver) throws UsernameNotFoundException{
        return userRepo.findByUsername(receiver);
    }
}
