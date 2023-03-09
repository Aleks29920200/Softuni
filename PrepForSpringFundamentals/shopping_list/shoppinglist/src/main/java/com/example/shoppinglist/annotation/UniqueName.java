package com.example.shoppinglist.annotation;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePerformerValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {
    String message() default "ProductName already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
