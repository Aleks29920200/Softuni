package com.example.shoppinglist.init;

import com.example.shoppinglist.service.CategoryServiceImpl;
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
