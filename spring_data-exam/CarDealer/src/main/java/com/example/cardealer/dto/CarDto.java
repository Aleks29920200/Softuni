package com.example.cardealer.dto;

import com.example.cardealer.entities.Part;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDto {
    @XmlAttribute(name="make")
    private String make;
    @XmlAttribute(name="model")
    private String model;
    @XmlAttribute(name="travelled-distance")
    private Long travelledDistance;


    public CarDto() {

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
