package softuni.exam.models.dto;

import javax.validation.constraints.Size;

public class MechanicDto {
    @Size(min=2)
    private String firstName;
    @Size(min=2)
    private String lastName;
    private String email;
    @Size(min=2)
    private String phone;

    public MechanicDto() {
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
