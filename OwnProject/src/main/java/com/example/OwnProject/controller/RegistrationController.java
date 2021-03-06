package com.example.OwnProject.controller;

import com.example.OwnProject.Entites.Role;
import com.example.OwnProject.Entites.User;
import com.example.OwnProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@RequestMapping("/registration")
@Controller
public class RegistrationController {
    private UserRepo userRepo;

    @Autowired
    public void setRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        if(user.getUsername().equals("")) {
            model.addAttribute("message", "Input your username");
            return "registration";
        }
        if(user.getPassword().equals("")) {
            model.addAttribute("message", "Input your password");
            return "registration";
        }

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
