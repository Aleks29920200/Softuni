package com.example.cardealer.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomersRootDto {
    @XmlElement(name = "customer")
    private List<OrderedCustomersDto> customers;

    public OrderedCustomersRootDto() {
        customers=new ArrayList<>();
    }

    public List<OrderedCustomersDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<OrderedCustomersDto> customers) {
        this.customers = customers;
    }
}
