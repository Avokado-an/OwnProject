package com.example.OwnProject.Entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message implements Comparable<Message>{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="receiver")//, insertable=false, updatable=false)
    private User receiver;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    public Message() {
    }

    public Message(String text, User receiver) {
        this.text = text;
        this.date= new Date();
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //public String getReceiver() {
    //return receiver;
    //}

    //public void setReceiver(String receiver) {
    //this.receiver = receiver;
    //}

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int compareTo(Message o) {
        return getDate().compareTo(o.getDate());
    }


//public Long getReceiverId() {
    //return receiverId;
    //}

    //public void setReceiverId(Long receiverId) {
    //this.receiverId = receiverId;
    //}
}