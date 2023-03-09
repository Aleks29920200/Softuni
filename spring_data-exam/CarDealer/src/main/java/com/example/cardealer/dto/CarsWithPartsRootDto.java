package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithPartsRootDto {
    @XmlElement
    private List<CarsWithParts> cars;

    public CarsWithPartsRootDto() {
        cars=new ArrayList<>();
    }

    public List<CarsWithParts> getCars() {
        return cars;
    }

    public void setCars(List<CarsWithParts> cars) {
        this.cars = cars;
    }
}
