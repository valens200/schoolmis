package rw.ac.rca.webapp.orm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classroom")
@Getter
@Setter
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private int id;
    private String code;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom")
    private List<Instructor> instructors;

}
