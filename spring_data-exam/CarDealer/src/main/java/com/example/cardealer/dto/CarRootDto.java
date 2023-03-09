package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

    @XmlRootElement(name = "cars")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class CarRootDto {

        @XmlElement(name = "car")
        private List<CarInputDto> carDtoList;

        public CarRootDto() {
        }

        public List<CarInputDto> getCarDtoList() {
            return carDtoList;
        }

        public void setCarDtoList(List<CarInputDto> carDtoList) {
            this.carDtoList = carDtoList;
        }
    }
