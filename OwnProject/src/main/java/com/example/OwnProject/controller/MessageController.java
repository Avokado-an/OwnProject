package com.example.OwnProject.controller;

import com.example.OwnProject.domain.Message;
import com.example.OwnProject.domain.User;
import com.example.OwnProject.service.MessageService;
import com.example.OwnProject.service.Implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public void setProductRepository(MessageService messageService) {
        this.messageService = messageService;
    }


    private UserServiceImplementation userServiceImplementation;

    @Autowired
    public void setUserServiceImplementation(UserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }

    @GetMapping
    public String showMessages(
            @AuthenticationPrincipal User user,
            Map<String, Object> model
    ) {
        Set<Message> messages = user.getMessages();//service.findByAuthor(user);
        messages.addAll(user.getReceivedMessages());
        model.put("messages", messages);

        return "messages";
    }

    @PostMapping
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String receiverName,
            Map<String, Object> model
    ) {
        User receiver = userServiceImplementation.loadUserByUsername(receiverName);
        if(receiver == null){
            Set<Message> messages = user.getMessages();
            messages.addAll(user.getReceivedMessages());
            //model.put("is", false);
            model.put("messages", messages);

            return "messages";
        }

        Message message = new Message(text, receiver);

        message.setAuthor(user);

        user.addMessage(message);
        receiver.addReceivedMessage(message);

        messageService.saveMessage(message);

        Set<Message> messages = user.getMessages();
        messages.addAll(user.getReceivedMessages());

        //model.put("is", true);
        model.put("messages", messages);

        return "messages";
    }
}
