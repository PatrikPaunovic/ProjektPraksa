package com.example.demo.manager;

import com.example.demo.model.User;

public interface UserManager {
    String registerUser(User userEntity);

    String loginUser(String username, String password);
}
