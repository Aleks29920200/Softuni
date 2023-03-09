package com.example.shoppinglist.domain.dto;





import com.example.shoppinglist.annotation.UniqueEmail;
import com.example.shoppinglist.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class RegisterUser {
    @Size(min=3,max=20,message = "Username must be between 3 and 20 characters")
    @NotBlank(message = "Invalid username")
    @UniqueUsername
    private String username;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be empty")
    @UniqueEmail
    private String email;
    @Size(min=3,max=20,message = "Password must be between 3 and 20 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
