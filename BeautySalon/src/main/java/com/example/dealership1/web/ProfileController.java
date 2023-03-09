package com.example.dealership1.web;

import com.example.dealership1.domain.binding.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
   @GetMapping("/profile")
  // @PreAuthorize("isAuthenticated()")
    public String profile(){
        return "/profile";
    }
    @PostMapping("/profile")
  //  @PreAuthorize("isAuthenticated()")
    public String profilePost(@ModelAttribute("login") LoginDTO loginUser){

        return "profile";
    }
}
