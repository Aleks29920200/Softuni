package com.example.coffee_shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private CategoryName name;
    @Column(nullable = false)
    private Integer neededTime;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }


    public Integer getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }
}
