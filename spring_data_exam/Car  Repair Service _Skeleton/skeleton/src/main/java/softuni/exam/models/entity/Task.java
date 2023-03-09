package softuni.exam.models.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Task extends BaseEntity{
    private BigDecimal price;
    private LocalDateTime date;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Mechanic mechanic;
    @ManyToOne
    private Part part;

    public Task() {
    }

    public Task(BigDecimal price, LocalDateTime date, Car car, Mechanic mechanic,Part part) {
        this.price = price;
        this.date = date;
        this.car = car;
        this.mechanic = mechanic;
        this.part = part;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", car=" + car.toString() +
                ", mechanic=" + mechanic.toString() +
                "price=" + price +
                '}';
    }
}
