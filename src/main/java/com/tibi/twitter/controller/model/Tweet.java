package com.tibi.twitter.controller.model;

import com.tibi.twitter.service.user.Message;

public class Tweet {
    private String text;

    public static Tweet from(Message message) {
        return new Tweet(message.getContent());
    }

    public Tweet() {
    }

    public Tweet(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
