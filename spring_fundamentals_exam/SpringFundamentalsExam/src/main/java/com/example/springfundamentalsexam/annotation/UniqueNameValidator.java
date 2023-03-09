package com.example.springfundamentalsexam.annotation;



import com.example.springfundamentalsexam.domain.enums.ConditionName;
import com.example.springfundamentalsexam.service.ConditionServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private final ConditionServiceImpl conditionService;


    public UniqueNameValidator(ConditionServiceImpl conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.conditionService.findByConditionName(ConditionName.valueOf(value)) == null;
    }
}
