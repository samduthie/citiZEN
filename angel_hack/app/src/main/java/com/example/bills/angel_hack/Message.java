package com.example.bills.angel_hack;

import java.util.Date;

/**
 * Created by bills on 15/07/2017.
 */

public class Message {

    private String username;
    private int duration;
    private String message;
    private String subject;
    private Date date;
    private boolean solved;
    private int rating;
    private String id;

    public Message(String username, String subject, String message) {
        this.username = username;
        this.subject = username;
        this.message = message;
        date = new Date();
        solved = false;
        rating = 0;
        id = date.toString() + username;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void solve() {
        solved = true;
    }

    public boolean getSolved() {
        return solved;
    }

    public void changeSubject(String newSubject) {
        subject = newSubject;
        Date date = new Date();
        updateDate(date);
    }

    public void changeMessage(String newMessage) {
        message = newMessage;
        Date date = new Date();
        updateDate(date);
    }

    private void updateDate(Date newDate) {
        date = newDate;
    }

    public int getRating() {
        return rating;
    }

    public void addRate() {
        rating += 1;
    }

    public void minusRate() {
        if(rating > 0) {
            rating -= 1;
        }
    }
}

