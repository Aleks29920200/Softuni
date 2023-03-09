package com.example.shoppinglist.domain.entity;

import com.example.shoppinglist.domain.entity.BaseEntity;
import com.example.shoppinglist.domain.entity.Category;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price ;
    @Column(nullable = false)
    private LocalDateTime neededBefore;
    @ManyToOne
    private Category category;

    public Product() {
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

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
