package com.tibi.twitter.controller;

import com.tibi.twitter.controller.model.Tweet;
import com.tibi.twitter.controller.model.TwitterUser;
import com.tibi.twitter.service.UserService;
import com.tibi.twitter.service.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TwitterUserController {

    private final UserService userService;

    @Autowired
    public TwitterUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("twitter/users")
    @ResponseStatus(HttpStatus.CREATED)
    public TwitterUser registerUser(@RequestBody TwitterUser user) {
        User newUser = userService.createUser(user.getName());
        return TwitterUser.from(newUser);
    }

    @GetMapping("twitter/users")
    public List<TwitterUser> allUsers() {
        return userService.getUsers()
                .stream()
                .map(TwitterUser::from)
                .collect(Collectors.toList());
    }

    @PostMapping("twitter/users/{user}/messages")
    @ResponseBody
    public ResponseEntity<TwitterUser> tweet(@PathVariable String user, @RequestBody Tweet tweet) {
        Optional<TwitterUser> updatedUser = userService.addMessage(user, tweet.getText())
                .map(TwitterUser::from);
        return ResponseEntity.of(updatedUser);
    }

}
