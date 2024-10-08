package com.example.User.UserService;

import com.example.User.CustomException.UserAlreadyExistsException;
import com.example.User.CustomException.UserNotFoundException;
import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;
import com.example.User.Mapper.UserMapper;
import com.example.User.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDTO getUser(String userId) {
       Optional<User>user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("The UserId : "+userId+" : is not available");
        }
        return UserMapper.toUserDTO(user.get());
    }

    @Override
    public UserDTO saveUser(User user) {
        if(userRepository.existsById(user.getUserId())){
            throw new UserAlreadyExistsException("User with : "+user.getUserId()+" already exists");
        }
        if(userRepository.existsByEmailId(user.getEmailId())||userRepository.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException("User with this email or username already exists");
        }
        User saved = userRepository.save(user);
        return UserMapper.toUserDTO(saved);
    }

    @Override
    public List<UserDTO>getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> DTOlist = new ArrayList<>();
        for( User user:users){
             DTOlist.add(UserMapper.toUserDTO(user));
        }
        return DTOlist;
    }

   public UserDTO updateUser(String userId,User updateUser){
       User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
       if(updateUser.getName()!=null){
                existingUser.setName(updateUser.getName());
       }
       if(updateUser.getUsername()!=null){
                existingUser.setUsername(updateUser.getUsername());
       }
       if(updateUser.getPassword()!=null){
           existingUser.setPassword(updateUser.getPassword());
       }
       if(updateUser.getEmailId()!=null){
           existingUser.setEmailId(updateUser.getEmailId());
       }
       if(updateUser.getAddress()!=null){
           existingUser.setAddress(updateUser.getAddress());
       }
       if(updateUser.getPhoneNo()!=null){
           existingUser.setPhoneNo(updateUser.getPhoneNo());
       }
       User updat = userRepository.save(existingUser);
       return UserMapper.toUserDTO(updat);
   }

}
