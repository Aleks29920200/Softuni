package com.example.springfundamentalsexam.domain.dto;

import java.util.List;

public class ProductByCategory {

    private List<OfferDto> food;
    private List<OfferDto> drink;
    private List<OfferDto> household;
    private List<OfferDto> other;

    public ProductByCategory() {

    }

    public List<OfferDto> getFood() {
        return food;
    }

    public void setFood(List<OfferDto> food) {
        this.food = food;
    }

    public List<OfferDto> getDrink() {
        return drink;
    }

    public void setDrink(List<OfferDto> drink) {
        this.drink = drink;
    }

    public List<OfferDto> getHousehold() {
        return household;
    }

    public void setHousehold(List<OfferDto> household) {
        this.household = household;
    }

    public List<OfferDto> getOther() {
        return other;
    }

    public void setOther(List<OfferDto> other) {
        this.other = other;
    }

}
