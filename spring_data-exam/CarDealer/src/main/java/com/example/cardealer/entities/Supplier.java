package com.example.cardealer.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="suppliers")
public class Supplier extends BaseEntity {
    @Column
    private String name;
    @Column
    private boolean is_Importer;
    @OneToMany(mappedBy = "supplier",targetEntity = Part.class)
    private List<Part> parts;

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Supplier(String name, boolean is_Importer) {
        this.name = name;
        this.is_Importer = is_Importer;
    }

    public Supplier() {
        parts=new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsImporter() {
        return is_Importer;
    }

    public void setIsImporter(boolean is_Importer) {
        this.is_Importer = is_Importer;
    }
}
