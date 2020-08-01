package com.tibi.twitter.service.user;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class User {

    private final List<Message> messages = new LinkedList<>();
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public void addMessage(String message) {
        messages.add(new Message(message));
    }
}
