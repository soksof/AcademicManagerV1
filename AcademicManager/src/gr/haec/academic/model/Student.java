package gr.haec.academic.model;

import java.util.Date;
/**
 * 
 * @author instructor
 *
 */
public class Student extends Person {

	protected Date applicationDate;
	protected String evaluation;
	protected float assignmentGrades;
	protected int assignmentID;
	protected Date submitDate;
	protected int studentID;
	protected String evaluationTeacher;
	protected float finalGrade;
	
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

	public float getAssignmentGrades() {
		return assignmentGrades;
	}

	public void setAssignmentGrades(float assignmentGrades) {
		this.assignmentGrades = assignmentGrades;
	}

	public float getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getEvaluationTeacher() {
		return evaluationTeacher;
	}

	public void setEvaluationTeacher(String evaluationTeacher) {
		this.evaluationTeacher = evaluationTeacher;
	}

	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String password, String taxNumber, String iban, Role role, int courseID,
			Date applicationDate, String evaluation, float assignmentGrades, int assignmentID, Date submitDate, 
			int studentID, String evaluationTeacher, float finalGrade) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.applicationDate = applicationDate;
		this.evaluation = evaluation;
		this.assignmentGrades=assignmentGrades;
		this.finalGrade=finalGrade;
		this.assignmentID=assignmentID;
		this.submitDate=submitDate;
		this.studentID=studentID;
		this.evaluationTeacher=evaluationTeacher;
	}
	
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username,String taxNumber, String iban, Role role, String evaluation) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.evaluation = evaluation;
	}
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username,String taxNumber, String iban, Role role, String evaluation,float finalGrade) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.evaluation = evaluation;
		this.finalGrade=finalGrade;
	}
}
	