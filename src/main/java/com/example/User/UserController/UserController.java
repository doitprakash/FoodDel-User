package com.example.User.UserController;

import com.example.User.Entity.User;
import com.example.User.UserService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        User userPost = userServiceImpl.saveUser(user);
        return "User Created Successfully";
    }

    @GetMapping("/user/{userId}")
    public User getByUserId(@PathVariable String userId) {
        User user = userServiceImpl.getUser(userId);
        return user;
    }
    @GetMapping("/user")
    public List<User>getAllUser(){
        List<User> users = userServiceImpl.getAllUser();
        return users;
    }
}
