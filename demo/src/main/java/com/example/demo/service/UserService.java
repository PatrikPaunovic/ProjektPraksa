package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);



    User createNewUser(User userEntity);
    User getUserByUsername(String username);
    boolean existsByUsername(String username);
}