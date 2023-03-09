package com.example.coffee_shop.annotation;

import com.example.coffee_shop.service.UserServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserServiceImpl userService;

    public UniqueEmailValidator(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.findUserByEmail(value) == null;
    }
}