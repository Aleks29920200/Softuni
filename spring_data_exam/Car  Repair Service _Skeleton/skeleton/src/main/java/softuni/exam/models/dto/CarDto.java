package softuni.exam.models.dto;
import softuni.exam.models.entity.CarType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="car")
@XmlAccessorType(value= XmlAccessType.FIELD)
public class CarDto {
    @XmlElement
    private String carType;
    @XmlElement(name="carMake")
    @Size(min=2,max=30)
    private String carMake;
    @XmlElement(name="carModel")
    @Size(min=2,max=30)
    private String carModel;
    @XmlElement(name="year")
    @Positive
    private int year;
    @XmlElement(name="plateNumber")
    @Size(min=2, max=30)
    private String plateNumber;
    @XmlElement(name="kilometers")
    @Positive
    private int kilometers;
    @XmlElement(name="engine")
    @Min(value=1)
    private double engine;


    public CarDto() {
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
