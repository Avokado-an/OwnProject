package com.example.OwnProject.service;

import com.example.OwnProject.Entites.Contact;
import com.example.OwnProject.Entites.User;

import java.util.Set;

public interface ContactsService {
    void saveContact(Contact contact);
    Set<Contact> findByUser(User user);
}
