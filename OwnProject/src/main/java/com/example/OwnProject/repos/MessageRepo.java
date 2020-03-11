package com.example.OwnProject.repos;

import com.example.OwnProject.domain.Message;
import com.example.OwnProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    //List<Message> findByTag(String Tag);
    List<Message> findByAuthorOrderByDate(User author);
    List<Message> findByReceiverOrderByDate(User author);
}
