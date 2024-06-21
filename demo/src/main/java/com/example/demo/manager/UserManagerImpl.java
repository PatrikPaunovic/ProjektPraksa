package com.example.demo.manager;

import com.nimbusds.jose.JOSEException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    @Autowired
    public UserManagerImpl(UserService userService, BCryptPasswordEncoder passwordEncoder, JWTUtils jwtUtils) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String registerUser(User userEntity) {
        boolean existingUser = userService.existsByUsername(userEntity.getUsername());
        if (existingUser) {
            return "User already exists";
        } else {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userService.createNewUser(userEntity);
            return "User registered successfully";
        }
    }

    @Override
    public String loginUser(String username, String password) {
        User userEntity = userService.getUserByUsername(username);
        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            try {
                return jwtUtils.generateToken(userEntity.getUsername());
            } catch (JOSEException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "Invalid credentials";
        }
    }
}