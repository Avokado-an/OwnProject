package com.example.OwnProject.controller;

import com.example.OwnProject.Entites.Contact;
import com.example.OwnProject.Entites.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.TreeSet;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    @GetMapping
    public String showContacts(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        TreeSet<Contact> contacts = new TreeSet<>(user.getReceivedContacts());
        for(Contact contact: user.getOwnedContacts()) {
            if(!(user.getReceivedContacts().contains(contact) || user.getOwnedContacts().contains(contact)))
                contacts.add(contact);
        }
        model.addAttribute("currentUser", user);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}
