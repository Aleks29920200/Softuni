package com.example.dealership1.services;


import com.example.dealership1.domain.binding.RegisterDto;
import com.example.dealership1.domain.entity.Role;
import com.example.dealership1.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void logout();

    User findUserByEmail(String email);

    User findUserByUsername(String email);

    void registerUser(RegisterDto userDto);

    Role findRoleByName(String name);

    List<User> allUsers();


}
