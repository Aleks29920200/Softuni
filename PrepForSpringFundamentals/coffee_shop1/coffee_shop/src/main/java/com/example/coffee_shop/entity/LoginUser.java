package com.example.coffee_shop.entity;


import jakarta.validation.constraints.Size;

public class LoginUser {

    private String username;
    private String password;

    public LoginUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
