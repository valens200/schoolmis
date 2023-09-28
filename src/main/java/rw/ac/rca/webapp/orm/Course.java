/**
 * 
 */
package rw.ac.rca.webapp.orm;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Aphrodice Rwagaju
 *
 */
@Entity
@Table(name = "course")
@Getter
@Setter
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	private int minStudent;
	private int maxStudent;
	private Date start;
	private Date end;
	private boolean isCancelled;
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "course")
	private List<Enrol> enrols;
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "course_instructor", joinColumns = {@JoinColumn(name="course_id")}, inverseJoinColumns = {@JoinColumn(name="instructor_id")})
	private Set<Instructor> instructors;

    public Course(String courseName, String courseCode, int  maxStudent, int  minStudent, Date startDate, Date endDate) {
		this.name = courseName;
		this.code = courseCode;
		this.maxStudent = maxStudent;
		this.minStudent = minStudent;
		this.start = startDate;
		this.end = endDate;
    }


    public Set<Instructor> getInstructors() {
		return instructors;
	}
	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getMinStudent() {
		return minStudent;
	}
	public void setMinStudent(int minStudent) {
		this.minStudent = minStudent;
	}
	public int getMaxStudent() {
		return maxStudent;
	}
	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public void setStart(String start) {
		this.start = new Date(start);
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setEnd(String end) {
		this.end = new Date(end);
	}
	public boolean isCancelled() {
		return isCancelled;
	}
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	

	public List<Enrol> getEnrols() {
		return enrols;
	}
	public void setEnrols(List<Enrol> enrols) {
		this.enrols = enrols;
	}
	
	public Course() {
	}
	public Course(String name, String code, int minStudent, int maxStudent, Date start, Date end,
			boolean isCancelled) {
		this.name = name;
		this.code = code;
		this.minStudent = minStudent;
		this.maxStudent = maxStudent;
		this.start = start;
		this.end = end;
		this.isCancelled = isCancelled;
	}
	
	

}
