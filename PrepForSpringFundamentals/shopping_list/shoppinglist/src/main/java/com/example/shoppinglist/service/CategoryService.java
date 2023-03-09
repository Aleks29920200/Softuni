package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Category;
import com.example.shoppinglist.domain.enums.CategoryName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryService {
    void seedAll();
    Optional<Category> findByName(CategoryName name);

}
