package rw.ac.rca.webapp.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "parent")
public class Parent extends Person{
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "parent")
    private List<Student> students;

    public Parent(String firstName, String lastName, String phoneNumber, Date dateOfBirth) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
    }

    public Parent() {

    }
}
