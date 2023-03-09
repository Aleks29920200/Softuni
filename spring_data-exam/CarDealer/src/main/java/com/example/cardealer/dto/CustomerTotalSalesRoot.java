package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesRoot {
    @XmlElement
    private List<CustomerTotalSales> sales;

    public CustomerTotalSalesRoot() {
    }

    public List<CustomerTotalSales> getSales() {
        return sales;
    }

    public void setSales(List<CustomerTotalSales> sales) {
        this.sales = sales;
    }
}
