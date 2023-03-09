package com.example.springfundamentalsexam.controller;


import com.example.springfundamentalsexam.domain.dto.LoginUser;
import com.example.springfundamentalsexam.domain.dto.RegisterUser;
import com.example.springfundamentalsexam.service.UserServiceImpl;
import com.example.springfundamentalsexam.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthControllerImpl implements AuthController{
    private UserServiceImpl service;
    private LoggedUser loggedUser;
    public AuthControllerImpl(UserServiceImpl service, LoggedUser loggedUser) {
        this.service = service;
        this.loggedUser = loggedUser;
    }

    @Override
    public String register(){
        return "register";
    }


    @Override
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
    @Override
    public String login(){
        return "login";
    }
   @Override
    public String loginPost(@ModelAttribute LoginUser loginDto, BindingResult result, RedirectAttributes attr){
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
    @Override
    public String logout(){
        if(loggedUser.getUsername()==null||loggedUser.getPassword()==null) {
            return "redirect:/";
        }
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
