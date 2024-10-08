package com.example.User.UserController;

import com.example.User.CustomException.UserNotFoundException;
import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;
import com.example.User.Response.UserResponse;
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
        UserDTO userPost = userServiceImpl.saveUser(user);
        URI location = URI.create("/user/" + userPost.getUserId());
          HttpHeaders headers = new HttpHeaders();
          headers.setLocation(location);
        UserResponse userResponse = new UserResponse("User Created Successfully",userPost);
        return new ResponseEntity<>(userResponse, headers, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId) {
        UserDTO user = userServiceImpl.getUser(userId);
        UserResponse userResponse = new UserResponse("Details for " + userId + " are : ", user);
        return  new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getAllUser(){
        List<UserDTO> users = userServiceImpl.getAllUser();
        UserResponse userResponse = new UserResponse("List of all Users",users);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    @PatchMapping("user/{userId}")
    public ResponseEntity<?>updateUser(@PathVariable String userId,@RequestBody User updatedUser){
      try{
          UserDTO userDTO = userServiceImpl.updateUser(userId, updatedUser);
          UserResponse userResponse = new UserResponse("User Update Successfully",userDTO);
          return new ResponseEntity<>(userResponse, HttpStatus.OK);
      }catch(UserNotFoundException ex){
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
      }catch(Exception ex){
          return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Updating User");
      }
    }
}
