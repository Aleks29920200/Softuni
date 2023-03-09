package com.example.cardealer.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="sales")
public class Sale extends BaseEntity{
    @Column
    private BigDecimal discount;
    @OneToOne
    private Car car;
    @OneToOne
    private Customer customer;

    public Sale(BigDecimal discount) {
        this.discount = discount;
    }

    public Sale() {
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
