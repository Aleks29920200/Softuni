package com.example.coffee_shop.entity;





import com.example.coffee_shop.annotation.UniqueEmail;
import com.example.coffee_shop.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class RegisterUser {
    @Size(min=5,max=20,message = "Username must be between 5 and 20 characters")
    @NotBlank(message = "Invalid username")
    @UniqueUsername
    private String username;
    private String firstName;
    @Size(min=5,max=20,message = "Last name must be between 5 and 20 characters")
    @NotBlank(message = "Last name cannot be null")
    private String lastName;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be empty")
    @UniqueEmail
    private String email;
    @Size(min=3,message = "Password must be between 3 and 20 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Size(min=3,message = "Password must be between 3 and 20 characters")
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }



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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
