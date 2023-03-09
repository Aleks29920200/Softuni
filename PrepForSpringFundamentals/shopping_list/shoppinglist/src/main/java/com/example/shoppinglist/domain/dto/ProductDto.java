package com.example.shoppinglist.domain.dto;


import com.example.shoppinglist.annotation.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class ProductDto {
    @Size(min=3,max=20,message = "Length must be between 3 and 20 characters")
    @NotBlank(message = "Performer cannot be empty")
    @UniqueName
    private String name;
    @Size(min=5,message = "Description length must be more than 5 characters")
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @Positive(message = "Price must be positive.")
    private Double price;
    @FutureOrPresent(message = "The date cannot be in the past")
    @DateTimeFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private LocalDateTime neededBefore;
    @NotBlank(message = "You must select a category")
    private String categoryName;
    public ProductDto() {

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

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }
}
