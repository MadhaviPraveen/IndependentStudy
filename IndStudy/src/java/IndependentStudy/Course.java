package IndependentStudy;

public class Course {

	private int c_id;
	private String semester;
	private String courseName;
	private int credits; 
	
	public Course(String semester, String courseName) {
		super();
		this.semester = semester;
		this.courseName = courseName;
	}
	public Course() {
		super();
	}
	public Course(int c_id, int credits) {
		super();
		this.c_id = c_id;
		this.credits = credits;
	}
	public Course(int c_id, String semester, String courseName, int credits) {
		super();
		this.c_id = c_id;
		this.semester = semester;
		this.courseName = courseName;
		this.credits = credits;
	}
	
	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", semester=" + semester + ", courseName=" + courseName + ", credits=" + credits
				+ "]";
	}
	
	public int getc_id() {
		return c_id;
	}
	public void setc_id(int c_id) {
		this.c_id = c_id;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}

	

}
