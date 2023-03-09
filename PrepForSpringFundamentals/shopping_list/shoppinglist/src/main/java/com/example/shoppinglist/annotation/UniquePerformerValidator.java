package com.example.shoppinglist.annotation;


import com.example.shoppinglist.service.ProductServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniquePerformerValidator implements ConstraintValidator<UniqueName, String> {

    private final ProductServiceImpl productService;

    public UniquePerformerValidator(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productService.findProductByName(value) == null;
    }
}
