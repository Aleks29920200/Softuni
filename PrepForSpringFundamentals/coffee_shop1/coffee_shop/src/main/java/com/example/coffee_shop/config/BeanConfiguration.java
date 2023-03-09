package com.example.coffee_shop.config;


import com.example.coffee_shop.entity.AllOrders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
@Bean
    public AllOrders orders(){
   return new AllOrders();
}
}
