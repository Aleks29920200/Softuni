package com.example.cardealer.dto;

import com.example.cardealer.entities.BaseEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierInputDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private boolean is_Importer;

    public SupplierInputDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getImporter() {
        return is_Importer;
    }

    public void setImporter(boolean isImporter) {
        this.is_Importer=isImporter;
    }
}

