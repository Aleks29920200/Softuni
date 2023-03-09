package com.example.coffee_shop.service;


import com.example.coffee_shop.entity.RegisterUser;
import com.example.coffee_shop.entity.User;
import com.example.coffee_shop.repository.UserRepo;
import com.example.coffee_shop.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo repo;
    private LoggedUser loggedUser;


    public UserServiceImpl(UserRepo repo, LoggedUser loggedUser) {
        this.repo = repo;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(RegisterUser registerUser) {
        User user=new User();
        user.setUsername(registerUser.getUsername());
        user.setEmail(registerUser.getEmail());
        user.setPassword(registerUser.getPassword());
        user.setLastName(registerUser.getLastName());
        if(registerUser.getFirstName()!=null){
            user.setFirstName(registerUser.getLastName());
        }
        this.repo.saveAndFlush(user);
    }
    @Override
    public Optional<User> findUserByUsername(String username) {
        return this.repo.findUserByUsername(username);
    }

    @Override
    public void login(String username) {
        User userByUsername = this.findUserByUsername(username).get();
        loggedUser.setUsername(userByUsername.getUsername());
        loggedUser.setPassword(userByUsername.getPassword());
    }

    @Override
    public boolean credentials(String username) {
        User userByUsername = this.findUserByUsername(username).orElse(null);
        if(userByUsername==null){
            return false;
        }
        return true;
    }

    @Override
    public void logout() {
        if(loggedUser.getUsername()!=null&&loggedUser.getPassword()!=null){
            this.loggedUser.clearFields();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return this.repo.findUserByEmail(email);
    }

   


}
