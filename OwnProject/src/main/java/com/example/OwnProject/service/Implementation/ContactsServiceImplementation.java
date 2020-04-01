package com.example.OwnProject.service.Implementation;

import com.example.OwnProject.Entites.Contact;
import com.example.OwnProject.Entites.User;
import com.example.OwnProject.repos.ContactsRepo;
import com.example.OwnProject.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactsServiceImplementation implements ContactsService {
    private ContactsRepo repo;

    @Autowired
    public void setContactsRepo(ContactsRepo repo){
        this.repo = repo;
    }

    @Override
    public void saveContact(Contact contact) {
        repo.save(contact);
    }

    @Override
    public Set<Contact> findByUser(User user) {
        return repo.findAllByUser(user);
    }
}
