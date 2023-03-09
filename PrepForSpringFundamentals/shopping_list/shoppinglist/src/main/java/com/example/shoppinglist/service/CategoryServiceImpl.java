package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.entity.Category;
import com.example.shoppinglist.domain.enums.CategoryName;
import com.example.shoppinglist.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    @Override
    public void seedAll() {
        if(this.categoryRepo.count()==0) {
            Category food = new Category();
            food.setName(CategoryName.valueOf("Food"));
            this.categoryRepo.save(food);
            Category drink = new Category();
            drink.setName(CategoryName.valueOf("Drink"));
            this.categoryRepo.save(drink);
            Category household = new Category();
            household.setName(CategoryName.valueOf("Household"));
            this.categoryRepo.save(household);
            Category other = new Category();
            other.setName(CategoryName.valueOf("Other"));
            this.categoryRepo.save(other);
        }
    }

    @Override
    public Optional<Category> findByName(CategoryName name) {
        return Optional.ofNullable(this.categoryRepo.findByName(name).orElse(null));
    }
}
