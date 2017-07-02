package gr.haec.academic.model;

import java.util.Date;

/**
 * 
 * @author instructor
 *
 */

public class Student extends Person {

	/**
	 * declaring the variables which we have taken from the data base table of coursestudent and courseapplication.
	 */
	
	protected Date applicationDate;
	protected String evaluation;
	protected int studentID;
	protected float finalGrade;
	protected String payment;
	
	/**
	 *Setters and Getters for all the variables. 
	 */
	
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment=payment;
	}
	
	/**
	 * Constructor with all the informations regarding the paymentsof a student. 
	 * Currently don't used at any query of personDao.
	 */
	
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role,int studentID,String payment) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.studentID=studentID;
		this.payment=payment;
	}
	
	/**
	 * Constructor with the perosnal information of a student.
	 * Currently used at
	 */
	
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}
	/**
	 * Constructor fot course application from a student.
	 *
	 */
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role,Date applicationDate,int studentID) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.applicationDate = applicationDate;
		this.studentID=studentID;
	}
	
	/**
	 * Constructor for the evaluation of a student.
	 * Currently used at getStudentEvaluations query at personDao.
	 */
	
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username,String taxNumber, String iban, Role role, String evaluation,float finalGrade) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.evaluation = evaluation;
		this.finalGrade=finalGrade;
	}
	
}
	