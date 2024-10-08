package com.example.User.Mapper;

import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user){
        return new UserDTO(
              user.getUserId(),
              user.getName(),
              user.getAddress(),
              user.getEmailId(),
              user.getPhoneNo(),
              user.getUsername()
        );
}
    public static User toUserEntity(UserDTO userDTO){
              User user=new User();
              user.setUserId(userDTO.getUserId());
              user.setName(userDTO.getName());
              user.setAddress(userDTO.getAddress());
              user.setEmailId(userDTO.getEmailId());
              user.setPhoneNo(userDTO.getPhoneNo());
              user.setUsername(userDTO.getUsername());
        return user ;
                      }
}
