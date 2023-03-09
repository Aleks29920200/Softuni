package com.example.coffee_shop.service;

import com.example.coffee_shop.entity.Category;
import com.example.coffee_shop.entity.CategoryName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryService {
    void seedAll();
    Optional<Category> findByName(CategoryName name);

}
