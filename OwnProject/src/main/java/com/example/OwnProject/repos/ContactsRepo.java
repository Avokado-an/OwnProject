package com.example.OwnProject.repos;

import com.example.OwnProject.Entites.Contact;
import com.example.OwnProject.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactsRepo extends JpaRepository<Contact, Long> {
    Set<Contact> findAllByUser(User user);
}
