package com.example.User.UserRepository;

import com.example.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);
    boolean existsByEmailId(String emailId);
    Optional<User>findById(String userId);
}
