package com.example.shoppinglist.domain.dto;

import com.example.shoppinglist.domain.entity.Product;

import java.util.List;

public class ProductByCategory {

    private List<ProductDto> food;
    private List<ProductDto> drink;
    private List<ProductDto> household;
    private List<ProductDto> other;

    public ProductByCategory() {

    }

    public List<ProductDto> getFood() {
        return food;
    }

    public void setFood(List<ProductDto> food) {
        this.food = food;
    }

    public List<ProductDto> getDrink() {
        return drink;
    }

    public void setDrink(List<ProductDto> drink) {
        this.drink = drink;
    }

    public List<ProductDto> getHousehold() {
        return household;
    }

    public void setHousehold(List<ProductDto> household) {
        this.household = household;
    }

    public List<ProductDto> getOther() {
        return other;
    }

    public void setOther(List<ProductDto> other) {
        this.other = other;
    }

}
