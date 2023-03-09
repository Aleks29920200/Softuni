package com.example.coffee_shop.util;


import org.springframework.stereotype.Component;


@Component
public class LoggedUser {
    private String username;
    private String password;

    public LoggedUser() {
    }

    public void clearFields(){
        setUsername(null);
        setPassword(null);
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
