package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mechanics")
public class Mechanic extends BaseEntity {
    @Column(nullable = false,unique = true)

    private String firstName;
    @Column(nullable = false)

    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

    public Mechanic() {
    }

    public Mechanic(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Mechanic: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
