package com.example.springfundamentalsexam.service;


import com.example.springfundamentalsexam.domain.dto.RegisterUser;
import com.example.springfundamentalsexam.domain.entity.Offer;
import com.example.springfundamentalsexam.domain.entity.User;
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

    List<User>allUsers();
}

