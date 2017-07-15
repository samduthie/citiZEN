package com.example.bills.angel_hack;

import java.util.LinkedList;

/**
 * Created by bills on 15/07/2017.
 */

public class AppController {

    private MessageController messageController;
    private String username;

    public AppController(String username) {
        this.username = username;
        messageController = new MessageController(username);
    }

}
