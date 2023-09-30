 /**
 * 
 */
package rw.ac.rca.webapp.orm;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

 /**
  * @author Aphrodice Rwagaju
  *
  */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8680703317249517930L;
	private boolean isInternational;
	private boolean isPartTime;
	private boolean isRepeating;

	public Student() {
	}

	public Student(boolean isInternational, boolean isPartTime, boolean isRepeating) {
		this.isInternational = isInternational;
		this.isPartTime = isPartTime;
		this.isRepeating = isRepeating;
	}
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
	private List<Enrol> enrols;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private ClassRoom classroom;

    public Student(String firstName, String lastName, String studentPhoneNumber, Date studentDOB, boolean b, boolean b1, boolean b2) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(studentPhoneNumber);
		this.setDateOfBirth(studentDOB);
		this.setPartTime(b1);
		this.setRepeating(b2);
    }

    public boolean isInternational() {
		return isInternational;
	}
	public void setInternational(boolean isInternational) {
		this.isInternational = isInternational;
	}
	public boolean isPartTime() {
		return isPartTime;
	}
	public void setPartTime(boolean isPartTime) {
		this.isPartTime = isPartTime;
	}
	
	public List<Enrol> getEnrols() {
   		return enrols;
	}
	public void setEnrollments(List<Enrol> enrols) {
		this.enrols = enrols;
	}
	
	public boolean isRepeating() {
		return isRepeating;
	}
	public void setRepeating(boolean isRepeating) {
		this.isRepeating = isRepeating;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	@Override
//	String getAllNames() {
//		return getFirstName()+ " "+ getLastName();
//	}
	
}
