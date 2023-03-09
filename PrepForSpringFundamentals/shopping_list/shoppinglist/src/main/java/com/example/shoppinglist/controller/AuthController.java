package com.example.shoppinglist.controller;

import com.example.shoppinglist.domain.dto.LoginUser;
import com.example.shoppinglist.domain.dto.RegisterUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public interface AuthController {
    @GetMapping("/register")
    public String register();

    @PostMapping("/register")
    String registerPost(@Valid @ModelAttribute RegisterUser registerUser, BindingResult result, RedirectAttributes attr);

    @GetMapping("/login")
    public String login();
    @PostMapping("/login")
    String loginPost(@ModelAttribute LoginUser loginDto, BindingResult result, RedirectAttributes attr);

    @GetMapping("/logout")
    public String logout();

}
