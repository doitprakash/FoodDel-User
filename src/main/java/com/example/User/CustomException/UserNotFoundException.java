package com.example.User.CustomException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg){
         super(msg);
    }
}
