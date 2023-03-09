package com.example.shoppinglist.repository;

import com.example.shoppinglist.domain.entity.Category;
import com.example.shoppinglist.domain.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryName name);
}
