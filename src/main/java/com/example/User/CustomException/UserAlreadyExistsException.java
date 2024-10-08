package com.example.User.CustomException;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
