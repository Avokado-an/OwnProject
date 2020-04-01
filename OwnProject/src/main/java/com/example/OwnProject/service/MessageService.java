package com.example.OwnProject.service;

import com.example.OwnProject.domain.Message;
import com.example.OwnProject.domain.User;

import java.util.List;
import java.util.Optional;

public interface MessageService{
    Optional<Message> getMessageById(Long id);
    void saveMessage(Message message);
    void updateMessage(Long id, String message);
    void deleteMessage(Long id);
    List<Message> findByAuthorOrderById(User author);
    List<Message> findAll();
    List<Message> findByReceiverOrderById(User receiver);
}


