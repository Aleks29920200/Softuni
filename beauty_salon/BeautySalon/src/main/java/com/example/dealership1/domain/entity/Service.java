package com.example.dealership1.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="services")
public class Service extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceCategory category;

    public Service() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public ServiceCategory getCategory() {
        return category;
    }

    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

}
