package com.tibi.twitter.service;

import com.tibi.twitter.service.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(String user);

    Optional<User> addMessage(String user, String message);

    List<User> getUsers();

    Optional<User> findUser(String user);
}
