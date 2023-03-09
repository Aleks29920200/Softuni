package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name="parts")
public class Part extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String partName;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private int quantity;


    public Part() {
    }

    public Part(String partName, float price, int quantity) {
        this.partName = partName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
