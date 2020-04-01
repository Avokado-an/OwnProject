package com.example.OwnProject.controller;

import com.example.OwnProject.domain.User;
import com.example.OwnProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {
    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String showUsers(
            Map<String, Object> model
    ) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "user";
    }
}
