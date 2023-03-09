package com.example.cardealer.dto;

import com.example.cardealer.entities.Part;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithParts {
    @XmlAttribute(name="make")
    private String make;
    @XmlAttribute(name="model")
    private String model;
    @XmlAttribute(name="travelled-distance")
    private Long travelledDistance;
    @XmlElement
    private List<PartFromCar>parts;
    public CarsWithParts() {
        parts=new ArrayList<>();
    }

    public List<PartFromCar> getParts() {
        return parts;
    }

    public void setParts(List<PartFromCar> parts) {
        this.parts = parts;
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
