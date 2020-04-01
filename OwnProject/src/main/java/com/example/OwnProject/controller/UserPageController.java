package com.example.OwnProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userPage")
public class UserPageController {
    @GetMapping
    public String getUserPage() {
        return "userPage";
    }
}
