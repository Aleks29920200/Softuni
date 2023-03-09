package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.dto.RegisterUser;
import com.example.shoppinglist.domain.entity.User;
import org.springframework.stereotype.Service;

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

