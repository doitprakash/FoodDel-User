package com.example.User.UserService;

import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;

import java.util.List;

public interface UserService {
    UserDTO getUser(String userId);
    UserDTO saveUser(User user);
    List<UserDTO> getAllUser();
    List<UserDTO>saveAll(List<User>users);
//    boolean isUserExist(User user);
}
