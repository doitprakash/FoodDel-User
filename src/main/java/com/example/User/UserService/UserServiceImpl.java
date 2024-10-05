package com.example.User.UserService;

import com.example.User.Entity.User;
import com.example.User.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUser(String userId) {
        Optional<User>user = userRepository.findById(userId);
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User>getAllUser() {
        return userRepository.findAll();
    }

}
