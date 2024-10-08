package com.example.User.UserController;

import com.example.User.Entity.User;
import com.example.User.UserService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
      try {
          if (userServiceImpl.isUserExist(user)) {
              return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this emailId already exists");
          }
          User userPost = userServiceImpl.saveUser(user);
          URI location = URI.create("/user/" + userPost.getUserId());
          HttpHeaders headers = new HttpHeaders();
          headers.setLocation(location);
          return new ResponseEntity<>(userPost, headers, HttpStatus.CREATED);
      }catch(IllegalArgumentException e){
          return  ResponseEntity.badRequest().body("Invalid Input : "+e.getMessage());
      }catch(Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating User");
      }
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
