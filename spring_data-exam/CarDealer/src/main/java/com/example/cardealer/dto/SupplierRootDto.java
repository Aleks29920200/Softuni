package com.example.cardealer.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierInputDto> supplierDtos;

    public SupplierRootDto() {
    }

    public List<SupplierInputDto> getSupplierDtos() {
        return supplierDtos;
    }

    public void setSupplierDtos(List<SupplierInputDto> supplierDtos) {
        this.supplierDtos = supplierDtos;
    }
}
