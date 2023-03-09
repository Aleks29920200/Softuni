package com.example.cardealer.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
    @Column
    private String name;
    @Column
    private Date birthDate;
    @Column
    private boolean isYoungDriver;

    public Customer(String name,Date birthDate, boolean is_younger_driver) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = is_younger_driver;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        this.isYoungDriver = youngDriver;
    }
}
