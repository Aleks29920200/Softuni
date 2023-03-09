package com.example.coffee_shop.entity;


import com.example.coffee_shop.annotation.UniqueName;
import jakarta.validation.constraints.*;
import org.springframework.context.annotation.Description;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class OrderDto {
    @Size(min=3,max=20)
    @NotBlank
    @UniqueName
    private String name;
    @Positive
    private Double price;
    @PastOrPresent
    @DateTimeFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private LocalDateTime orderTime;
    @NotBlank(message = "You must select a category")
    private String categoryName;
    @Size(min=5)
    private String description;
    public OrderDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
