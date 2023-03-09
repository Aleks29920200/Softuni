package com.example.coffee_shop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price ;
    @Column(nullable = false)
    private LocalDateTime orderTime;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User employee;

    public Order() {
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
