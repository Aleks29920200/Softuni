package com.example.cardealer.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="parts")
public class Part extends BaseEntity {
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private BigInteger quantity;
    @ManyToOne(targetEntity = Supplier.class)
    private Supplier supplier;
    @ManyToMany(mappedBy = "part_id")
    private List<Car> car_id;

    public Part() {
        car_id =new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Car> getCar_id() {
        return car_id;
    }
    public void setCar_id(List<Car> car_id) {
        this.car_id = car_id;
    }
}
