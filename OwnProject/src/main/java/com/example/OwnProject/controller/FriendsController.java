package com.example.OwnProject.controller;

import com.example.OwnProject.Entites.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friends")
public class FriendsController {
    @GetMapping
    public String showContacts(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        //Set<User> friends = user.getContacts();
        //model.addAttribute("friends", friends);
        return "friends";
    }
}
