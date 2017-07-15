package com.example.bills.angel_hack;

import java.util.LinkedList;

/**
 * Created by bills on 15/07/2017.
 */

public class MessageController {

    private String username;
    private LinkedList<Message> messages;

    public MessageController(String username) {
        this.username = username;
        messages = new LinkedList<>();
    }

    public void makeMessage(String username, String subject, String body) {
        Message message = new Message(username, subject, body);
        messages.push(message);
    }

    public void deleteMessage(Message message) {
        messages.remove(message);
    }

    public void solveMessage(Message message) {
        message.solve();
        deleteMessage(message);
    }

    public void displayMessages() {
        for(Message m : messages) {
            //Display messages
        }
    }

    public void modifyMessage(Message message, String newBody) {
        message.changeMessage(newBody);
    }

    public void modifySubject(Message message, String newSubject) {
        message.changeSubject(newSubject);
    }
}
