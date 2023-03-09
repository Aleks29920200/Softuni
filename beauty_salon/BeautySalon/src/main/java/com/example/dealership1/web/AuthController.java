package com.example.dealership1.web;

import com.example.dealership1.domain.binding.LoginDTO;
import com.example.dealership1.domain.binding.RegisterDto;
import com.example.dealership1.services.RoleService;
import com.example.dealership1.services.UserServiceImpl;
import com.example.dealership1.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private UserServiceImpl userService;
    private RoleService roleService;

    public AuthController(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String registration(@Valid @ModelAttribute RegisterDto registerDto,
                               BindingResult result,
                               RedirectAttributes attr){
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same."));
        }

        if (result.hasErrors()) {
            attr
                    .addFlashAttribute("registerDto", registerDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerDto", result);

            return "redirect:/register";
        }
        this.userService.registerUser(registerDto);
        return "redirect:/login";
    }
    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login(){
        return "login";
    }
    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public String getLogout(){
        this.userService.logout();
        return "redirect:/";
    }
    @ModelAttribute
    public RegisterDto registerDto() {
        return new RegisterDto();
    }
    @ModelAttribute
    public LoginDTO loginForm() {
        return new LoginDTO();
    }
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }
}
