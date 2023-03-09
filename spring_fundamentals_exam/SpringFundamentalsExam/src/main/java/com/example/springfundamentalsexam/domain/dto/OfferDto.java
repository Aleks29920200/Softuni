package com.example.springfundamentalsexam.domain.dto;



import jakarta.validation.constraints.*;


public class OfferDto {

    @Size(min=5,max=20,message = "Description length must be between 5 and 20 characters")
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @Positive(message = "Price must be positive number!")
    private Double price;
    @NotBlank(message = "You must select a condition")
    private String conditionName;
    public OfferDto() {

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
    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }
}
