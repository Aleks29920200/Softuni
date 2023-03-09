package com.example.coffee_shop.repository;

import com.example.coffee_shop.entity.Category;
import com.example.coffee_shop.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryName name);
}
