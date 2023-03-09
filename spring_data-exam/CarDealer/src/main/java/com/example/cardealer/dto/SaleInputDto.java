package com.example.cardealer.dto;

import com.example.cardealer.entities.BaseEntity;
import com.example.cardealer.entities.Car;
import com.example.cardealer.entities.Customer;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement(name="sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleInputDto {
        @XmlElement
        private BigDecimal discount;
        @XmlTransient
        private Car car;
        @XmlTransient
        private Customer customer;

    public SaleInputDto() {
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
