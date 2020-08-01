package com.tibi.twitter.controller.model;

import com.tibi.twitter.service.user.User;

import java.util.List;
import java.util.stream.Collectors;

public final class TwitterUser {

    private String name;
    private List<Tweet> tweets;

    public static TwitterUser from(User user) {
        List<Tweet> tweets = user.getMessages().stream()
                .map(Tweet::from)
                .collect(Collectors.toList());

        return new TwitterUser(user.getName(), tweets);
    }

    public TwitterUser() {
    }

    public TwitterUser(String name) {
        this.name = name;
    }

    public TwitterUser(String name, List<Tweet> tweets) {
        this.name = name;
        this.tweets = tweets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}
