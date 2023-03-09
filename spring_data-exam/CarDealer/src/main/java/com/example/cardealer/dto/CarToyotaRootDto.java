package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarToyotaRootDto {
    @XmlElement
    private List<CarDto> toyotas;

    public CarToyotaRootDto() {
        toyotas=new ArrayList<>();
    }

    public List<CarDto> getToyotas() {
        return toyotas;
    }

    public void setToyotas(List<CarDto> toyotas) {
        this.toyotas = toyotas;
    }
}
