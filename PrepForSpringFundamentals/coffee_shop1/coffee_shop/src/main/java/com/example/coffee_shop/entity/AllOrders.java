package com.example.coffee_shop.entity;

import java.util.List;

public class AllOrders{

    private List<Order> food;

    public AllOrders() {

    }

    public List<Order> getFood() {
        return food;
    }

    public void setFood(List<Order> food) {
        this.food = food;
    }



}
