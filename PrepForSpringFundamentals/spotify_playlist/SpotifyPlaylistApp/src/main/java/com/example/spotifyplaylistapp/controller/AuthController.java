package com.example.spotifyplaylistapp.controller;



import com.example.spotifyplaylistapp.model.entity.LoginUser;
import com.example.spotifyplaylistapp.model.entity.RegisterUser;
import com.example.spotifyplaylistapp.service.UserServiceImpl;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private UserServiceImpl service;
    private LoggedUser loggedUser;
    public AuthController(UserServiceImpl service, LoggedUser loggedUser) {
        this.service = service;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute RegisterUser registerUser, BindingResult result, RedirectAttributes attr){
        if (!registerUser.getPassword().equals(registerUser.getConfirmPassword())) {
            result.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same."));
        }
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("registerUser", registerUser)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerUser", result);

            return "redirect:/register";
        }
        this.service.register(registerUser);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String registerPost(@ModelAttribute LoginUser loginDto, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("loginDto", loginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDto", result);

            return "redirect:/login";
        }
        boolean validCredentials = this.service.credentials(loginDto.getUsername());

        if (!validCredentials) {
            attr
                    .addFlashAttribute("loginDto", loginDto)
                    .addFlashAttribute("validCredentials", false);
            return "redirect:/login";
        }
        this.service.login(loginDto.getUsername());
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(){
        this.service.logout();
        return "redirect:/";
    }
    @ModelAttribute
    public RegisterUser registration(){
       return new RegisterUser();
    }
    @ModelAttribute
    public LoginUser loginIn(){
        return new LoginUser();
    }
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }
}
