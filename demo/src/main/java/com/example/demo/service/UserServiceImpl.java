package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(User userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findById(username).orElseThrow(() -> new IllegalArgumentException("User with username: " + username + " not found"));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsById(username);
    }
}
