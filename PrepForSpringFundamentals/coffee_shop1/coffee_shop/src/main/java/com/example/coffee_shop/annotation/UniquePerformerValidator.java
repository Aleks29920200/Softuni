package com.example.coffee_shop.annotation;


import com.example.coffee_shop.service.OrderServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniquePerformerValidator implements ConstraintValidator<UniqueName, String> {

    private final OrderServiceImpl productService;

    public UniquePerformerValidator(OrderServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productService.findOrderByName(value) == null;
    }
}
