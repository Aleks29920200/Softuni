package com.example.dealership1.web;


import com.example.dealership1.services.UserServiceImpl;
import com.example.dealership1.util.LoggedUser;
import org.modelmapper.ModelMapper;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController{
    private UserServiceImpl userService;

    private ModelMapper mapper;

private LoggedUser loggedUser;
    public HomeController(UserServiceImpl userService, ModelMapper mapper, LoggedUser loggedUser) {
        this.userService = userService;
        this.mapper = mapper;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
   // @PreAuthorize(value = "isAnonymous()")
    public String index() {
        if(loggedUser.getId()==null){
            return "/index";
        }
        return "index";
    }
    @GetMapping("/home")
   @PreAuthorize(value = "isAuthenticated()")
    public String home(){
        return "home";
    }

}
