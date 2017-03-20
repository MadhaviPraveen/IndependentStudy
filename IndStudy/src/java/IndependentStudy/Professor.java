package IndependentStudy;
import java.util.Date;
public class Professor {
	
	private int p_id;
	private String firstName;
	private String lastName;
	private Date dob;
	private int experience;
	private String studyPlace;
	
	public Professor() {
		super();
	}

	public Professor(int p_id, int experience) {
		super();
		this.p_id = p_id;
		this.experience = experience;
	}

	public Professor(String firstName, String lastName, Date dob, String studyPlace) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.studyPlace = studyPlace;
	}
	
	public Professor(int p_id, String firstName, String lastName, Date dob, int experience, String studyPlace) {
		super();
		this.p_id = p_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.experience = experience;
		this.studyPlace = studyPlace;
	}
	public String toString() {
		return "Professor [p_id=" + p_id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", experience=" + experience + ", studyPlace=" + studyPlace + "]";
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNname() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getStudyPlace() {
		return studyPlace;
	}

	public void setStudyPlace(String studyPlace) {
		this.studyPlace = studyPlace;
	}

}
