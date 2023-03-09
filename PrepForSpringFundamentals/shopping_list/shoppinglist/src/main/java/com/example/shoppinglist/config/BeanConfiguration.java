package com.example.shoppinglist.config;


import com.example.shoppinglist.domain.dto.ProductByCategory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductByCategory productByCategory(){
        return new ProductByCategory();
    }
}
