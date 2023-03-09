package com.example.coffee_shop.init;

import com.example.coffee_shop.service.CategoryServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private CategoryServiceImpl categoryService;

    public ConsoleRunner(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedAll();
    }
}
