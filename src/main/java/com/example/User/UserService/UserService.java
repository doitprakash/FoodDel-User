package com.example.User.UserService;

import com.example.User.Entity.User;

import java.util.List;

public interface UserService {
    User getUser(String userId);
    User saveUser(User user);
    List<User> getAllUser();
    boolean isUserExist(User user);
}
