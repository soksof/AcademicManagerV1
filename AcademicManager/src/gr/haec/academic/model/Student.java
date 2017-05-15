package gr.haec.academic.model;

import java.util.Date;
/**
 * 
 * @author instructor
 *
 */
public class Student extends Person {

	protected int courseID;
	protected Date applicationDate;
	protected String evaluation;
	protected float assignmentGrades;
	protected float finalGrade;
	protected int assignmentID;
	protected float grades;
	protected Date submitDate;
	protected int teacherID;
	protected int studentID;
	protected String evaluationTeacher;
	
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

	public float getGrades() {
		return grades;
	}

	public void setGrades(float grades) {
		this.grades = grades;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
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
			Date applicationDate, String evaluation, float assignmentGrades, float finalGrade, int assignmentID, float grades, Date submitDate, 
			int teacherID, int studentID, String evaluationTeacher) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.courseID = courseID;
		this.applicationDate = applicationDate;
		this.evaluation = evaluation;
		this.assignmentGrades=assignmentGrades;
		this.finalGrade=finalGrade;
		this.assignmentID=assignmentID;
		this.grades=grades;
		this.submitDate=submitDate;
		this.teacherID=teacherID;
		this.studentID=studentID;
		this.evaluationTeacher=evaluationTeacher;
	}
	
	public Student(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}
}
	