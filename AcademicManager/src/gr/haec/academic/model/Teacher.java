package gr.haec.academic.model;

import java.util.Date;

public class Teacher extends Person {

	protected Status status;
	protected String cv;
	protected Field field;
	protected int courseID;
	protected Date applicationDate;
	protected String CourseTeacherApplicationcol;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCourseTeacherApplicationcol() {
		return CourseTeacherApplicationcol;
	}

	public void setCourseTeacherApplicationcol(String courseTeacherApplicationcol) {
		CourseTeacherApplicationcol = courseTeacherApplicationcol;
	}

	
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String password, String taxNumber, String iban, Role role, Status status,
			String cv, Field field, int courseID, Date applicationDate, String CourseTeacherApplicationcol) {
		super(personID, name, surname, email, phone, sex, address, dob, username, password, taxNumber, iban, role);
		this.status = status;
		this.cv = cv;
		this.field = field;
		this.courseID=courseID;
		this.applicationDate=applicationDate;
		this.CourseTeacherApplicationcol=CourseTeacherApplicationcol;
		
	}
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}
}
