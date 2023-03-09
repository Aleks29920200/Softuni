package com.example.springfundamentalsexam.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {
    String message() default "ConditionName already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
