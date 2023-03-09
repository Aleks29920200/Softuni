package com.example.cardealer.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cars")
public class Car extends BaseEntity {
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private Long travelledDistance;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parts_cars",
            joinColumns = {
                    @JoinColumn(name = "car_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "part_id", referencedColumnName = "id")})
    private List<Part>part_id;
    public Car() {
        part_id=new ArrayList<>();
    }
    public List<Part> getParts() {
        return part_id;
    }
    public void setParts(List<Part> part_id) {
        this.part_id = part_id;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

}
