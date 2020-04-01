package com.example.OwnProject.repos;

import com.example.OwnProject.Entites.Message;
import com.example.OwnProject.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    //List<Message> findByTag(String Tag);
    List<Message> findByAuthorOrderById(User author);
    List<Message> findByReceiverOrderById(User author);
}