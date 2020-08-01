package com.tibi.twitter.service.user;

import com.tibi.twitter.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultUserService implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(String user) {
        User newUser = new User(user);
        users.add(newUser);
        return newUser;
    }

    @Override
    public Optional<User> addMessage(String user, String message) {
        return findUser(user)
                .map(foundUser -> {
                    foundUser.addMessage(message);
                    return foundUser;
                });
    }

    @Override
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public Optional<User> findUser(String userName) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst();
    }
}
