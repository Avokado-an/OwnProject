package com.example.OwnProject.controller;

import com.example.OwnProject.Entites.User;
import com.example.OwnProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/userCatalog")
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
        return "userCatalog";
    }

    @PostMapping
    public String findUser(
            Model model,
            @RequestParam(name = "searchedUser", required = false, defaultValue = "") String username
    ) {
        ArrayList<User> searchedUser = new ArrayList<>();
        if(username == null || username.isEmpty())
            searchedUser.addAll(userRepo.findAll());
        else
            searchedUser.add(userRepo.findByUsername(username));
        model.addAttribute("users", searchedUser);
        return "userCatalog";
    }
}
