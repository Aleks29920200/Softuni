package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car extends BaseEntity{
    @Column(nullable = false)
@Enumerated(EnumType.STRING)
    private CarType carType;
    @Column(nullable = false)
    private String carMake;
    @Column(nullable = false)
    private String carModel;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false,unique = true)
    private String plateNumber;
    @Column(nullable = false)
    private int kilometers;
    @Column(nullable = false)
    private double engine;

    public Car() {
    }

    public Car(CarType carType, String carMake, String carModel, int year, String plateNumber, int kilometers, double engine) {
        this.carType = carType;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }


}
