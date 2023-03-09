package com.example.springfundamentalsexam.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name="offers")
public class Offer extends BaseEntity {
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Double price ;
    @ManyToOne
    private Condition condition;


    public Offer() {
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


    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
