package com.example.cardealer.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRootDto {
    @XmlElement(name = "customer")
    private List<CustomerInputDto> customers;

    public CustomerRootDto() {
    }

    public List<CustomerInputDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerInputDto> customers) {
        this.customers = customers;
    }
}
