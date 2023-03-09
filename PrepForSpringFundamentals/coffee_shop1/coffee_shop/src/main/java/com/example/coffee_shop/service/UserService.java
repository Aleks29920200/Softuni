package com.example.coffee_shop.service;

import com.example.coffee_shop.entity.RegisterUser;
import com.example.coffee_shop.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void register(RegisterUser registerUser);
    Optional<User> findUserByUsername(String username);

    void login(String username);

    boolean credentials(String username);

    void logout();

    User findUserByEmail(String email);



}

