package com.example.OwnProject.Entites;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Contact implements Comparable<Contact> {
    @Id
    @GeneratedValue
    private int id;

    private Date time;

    @ManyToOne
    @JoinColumn(name="another_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String lastMessage;

    public Contact(User user, Date time, User owner) {
        this.user = user;
        this.time = time;
        this.owner = owner;
    }

    public Contact(User user, Date time, User owner, String lastMessage) {
        this.user = user;
        this.time = time;
        this.owner = owner;
        this.lastMessage = lastMessage;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return (getUser().equals(contact.getUser()) &&
                getOwner().equals(contact.getOwner())) || (getUser().equals(contact.getOwner()) &&
                getOwner().equals(contact.getUser()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getOwner());
    }

    @Override
    public int compareTo(Contact o) {
        return this.time.compareTo(o.time);
    }
}
