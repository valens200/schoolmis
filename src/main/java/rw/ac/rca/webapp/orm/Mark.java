package rw.ac.rca.webapp.orm;

import lombok.*;
import rw.ac.rca.webapp.util.EMarkType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mark")
@Getter
@Setter
public class Mark {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int Id;
    private int marks;
    @ManyToOne
    private Student owner;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Semester semester;
    private EMarkType type;

    public Mark(int marks, Student owner) {
        this.marks = marks;
        this.owner = owner;
    }
}
