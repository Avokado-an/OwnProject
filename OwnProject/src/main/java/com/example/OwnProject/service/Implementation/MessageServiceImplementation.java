package com.example.OwnProject.service.Implementation;

import com.example.OwnProject.domain.Message;
import com.example.OwnProject.domain.User;
import com.example.OwnProject.repos.MessageRepo;
import com.example.OwnProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImplementation implements MessageService {

    private MessageRepo repo;

    @Autowired
    public void setRepo(MessageRepo repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Message> getMessageById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);
    }

    @Override
    public void updateMessage(Long id, String message) {
    }

    @Override
    public void deleteMessage(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Message> findByAuthorOrderById(User author) {
        return repo.findByAuthorOrderByDate(author);
    }

    @Override
    public List<Message> findByReceiverOrderById(User receiver) { return repo.findByAuthorOrderByDate(receiver);}

    @Override
    public List<Message> findAll() {
        return (List<Message>) repo.findAll();
    }
}
