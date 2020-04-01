package com.example.OwnProject.controller;

import com.example.OwnProject.Entites.Contact;
import com.example.OwnProject.Entites.Message;
import com.example.OwnProject.Entites.User;
import com.example.OwnProject.service.ContactsService;
import com.example.OwnProject.service.Implementation.ContactsServiceImplementation;
import com.example.OwnProject.service.MessageService;
import com.example.OwnProject.service.Implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private ContactsService contactsService;

    @Autowired
    public void setContactsService(ContactsServiceImplementation contactsService) {
        this.contactsService = contactsService;
    }

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private UserServiceImplementation userServiceImplementation;

    @Autowired
    public void setUserServiceImplementation(UserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }

    @GetMapping
    public String showMessages(@AuthenticationPrincipal User user, Model model) {
        showMessage(model, user);
        return "messages";
    }

    @PostMapping
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String receiverName,
            Model model
    ) {
        User receiver = userServiceImplementation.loadUserByUsername(receiverName);
        if (receiver != null) {
            createMessage(text, user, receiver);
            addContacts(user, receiver, text);
        }

        showMessage(model, user);
        return "messages";
    }

    private void createMessage(String text, User user, User receiver) {
        Message message = new Message(text, receiver);
        message.setAuthor(user);
        user.addMessage(message);
        receiver.addReceivedMessage(message);
        messageService.saveMessage(message);
    }

    private void addContacts(User user, User receiver, String msg) {
        Contact contact = new Contact(receiver, new Date(), user, msg);

        if (user.getReceivedContacts().contains(contact) || user.getOwnedContacts().contains(contact)) {
            updateContact(user, contact);
        } else {
            user.addOwnedContact(contact);
            receiver.addReceivedContact(contact);
            contactsService.saveContact(contact);
        }
    }

    private void updateContact(User user, Contact contact) {
        Set<Contact> contacts = new HashSet<>(user.getReceivedContacts());
        contacts.addAll(user.getOwnedContacts());
        for (Iterator<Contact> it = contacts.iterator(); it.hasNext(); ) {
            Contact f = it.next();
            if (f.equals(contact)) {
                f.setLastMessage(contact.getLastMessage());
                f.setTime(new Date());
            }
        }
    }

    private void showMessage(Model model, User user) {
        TreeSet<Message> messages = new TreeSet<>(user.getMessages());
        messages.addAll(user.getReceivedMessages());
        model.addAttribute("messages", messages);
        model.addAttribute("currentUser", user);
        model.addAttribute("noUser", true);
    }
}