package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@XmlRootElement(name="task")
@XmlAccessorType(value= XmlAccessType.FIELD)
public class TaskDto {
    @XmlElement(name="price")
    @Positive
    private BigDecimal price;
    @XmlElement(name="date")
    private String date;
    @XmlElement(name= "car")
    private CarOfTask car;
    @XmlElement(name="mechanic")
    private MechanicOfTask mechanic;
    @XmlElement(name="part")
    private PartOfTask part;

    public TaskDto() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CarOfTask getCar() {
        return car;
    }

    public void setCar(CarOfTask car) {
        this.car = car;
    }

    public MechanicOfTask getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicOfTask mechanic) {
        this.mechanic = mechanic;
    }

    public PartOfTask getPart() {
        return part;
    }

    public void setPart(PartOfTask part) {
        this.part = part;
    }
}
