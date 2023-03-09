package com.example.coffee_shop.service;

import com.example.coffee_shop.entity.Category;
import com.example.coffee_shop.entity.CategoryName;
import com.example.coffee_shop.repository.CategoryRepo;
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
            food.setName(CategoryName.valueOf("Coffee"));
            food.setNeededTime(2);
            this.categoryRepo.save(food);
            Category drink = new Category();
            drink.setName(CategoryName.valueOf("Cake"));
            drink.setNeededTime(10);
            this.categoryRepo.save(drink);
            Category household = new Category();
            household.setName(CategoryName.valueOf("Drink"));
            household.setNeededTime(1);
            this.categoryRepo.save(household);
            Category other = new Category();
            other.setName(CategoryName.valueOf("Other"));
            other.setNeededTime(5);
            this.categoryRepo.save(other);
        }
    }

    @Override
    public Optional<Category> findByName(CategoryName name) {
        return Optional.ofNullable(this.categoryRepo.findByName(name).orElse(null));
    }
}
