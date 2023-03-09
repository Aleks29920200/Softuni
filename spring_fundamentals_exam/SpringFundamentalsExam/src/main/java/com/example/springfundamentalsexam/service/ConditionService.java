package com.example.springfundamentalsexam.service;

import com.example.springfundamentalsexam.domain.entity.Condition;
import com.example.springfundamentalsexam.domain.enums.ConditionName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ConditionService {
    void seedAll();
    //Optional<Category> findByName(CategoryName name);
    Condition findByConditionName(ConditionName conditionName);
}
