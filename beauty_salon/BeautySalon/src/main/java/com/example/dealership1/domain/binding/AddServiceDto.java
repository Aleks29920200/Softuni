package com.example.dealership1.domain.binding;

import jakarta.validation.constraints.*;

public class AddServiceDto {
    @Size(min=2,max=20,message = "Name must be between 2 and 20 symbols")
    @NotBlank(message = "Name cannot be empty!")
    private String name;
    @Positive(message = "Price must be positive number")
    private Float price;
    private String category;

    public AddServiceDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
