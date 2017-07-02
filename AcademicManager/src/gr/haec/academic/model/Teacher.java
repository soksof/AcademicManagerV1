package gr.haec.academic.model;

import java.util.Date;

public class Teacher extends Person {

	/**
	 * declaring the variables which we have taken from the data base table of coursestudent and courseapplication.
	 */
	
	protected Status status;
	protected String cv;
	protected Field field;
	protected String evaluation;
	protected Date applicationDate;

	/**
	 *Setters and Getters for all the variables. 
	 */
	
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
	
	public String getEvaluationTeacher() {
		return evaluation;
	}

	public void setEvaluationTeacher(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * Constructor for the teacher basic information .
	 * Currently used at any quary of personDao except of the application and evaluation queries .
	 */
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role, Status status,
			String cv, Field field) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.status = status;
		this.cv = cv;
		this.field = field;
	}

	/**
	 * Constructor for the teacher applicants.
	 * Currently used at getCourseApplicantTeachers query on personDao .
	 */
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role, String cv, Field field,Status status,
			Date applicationDate) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.cv = cv;
		this.field = field;
		this.status=status;
		this. applicationDate= applicationDate;
	}

	/**
	 * Constructor with the personal information of a teacher.
	 * Currently not used at any query of the personDao
	 */
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}

	/**
	 * Constructor for the evaluation of a teacher.
	 * Currently used at getTeacherEvaluation query at personDao.
	 */
	
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role, String evaluation) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		
		this.evaluation=evaluation;
		
	}
	
}