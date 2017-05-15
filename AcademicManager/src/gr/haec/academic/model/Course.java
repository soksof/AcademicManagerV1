package gr.haec.academic.model;

import java.sql.Date;

public class Course {

	protected int courseID;
	protected String title;
	protected Date startDate;
	protected Date endDate;
	protected Status status;
	protected int totalHours;
	protected String timetable;
	protected String description;
	protected String syllabus;
	protected int prereqCoreCourse;
	protected String courseCore;
	protected int idCourseCore;
	protected int cost;
	protected int discount;
	protected String classroom;
	protected int maxStudents;
	protected int minStudents;
	protected int credits;
	protected Field field;
	protected int assignmentID;
	private String assignmentDescription;
	protected Date startDateAssignment;
	protected Date endDateAssignment;
	protected int studentID;
	protected String evaluation;
	protected Date evaluationDate;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	public String getTimetable() {
		return timetable;
	}
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public int getPrereqCourseID() {
		return prereqCoreCourse;
	}
	public void setPrereqCourseID(int prereqCoreCourse) {
		this.prereqCoreCourse = prereqCoreCourse ;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	public int getMinStudents() {
		return minStudents;
	}
	public void setMinStudents(int minStudents) {
		this.minStudents = minStudents;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getAssignmentID() {
		return assignmentID;
	}
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	public String getAssignmentDescription() {
		return assignmentDescription;
	}
	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}
	public Date getStartDateAssignment() {
		return startDateAssignment;
	}
	public void setStartDateAssignment(Date startDateAssignment) {
		this.startDateAssignment = startDateAssignment;
	}
	public Date getEndDateAssignment() {
		return endDateAssignment;
	}
	public void setEndDateAssignment(Date endDateAssignment) {
		this.endDateAssignment = endDateAssignment;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public Date getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	public String getcourseCore() {
		return timetable;
	}
	public void setcourseCore(String courseCore) {
		this.courseCore = courseCore;
	}
public int getIdCourseCore() {
	return idCourseCore;
}
public void setIdCourseCore(int idCourseCore) {
	this.idCourseCore = idCourseCore;
}
	
	public Course(int courseID, String title, Date startDate,Date endDate, Status status, int totalHours, String timetable, 
			String description, String syllabus, int prereqCoreCourse, int cost, int discount, String classroom, int maxStudents, 
			int minStudents, int credits, int assignmentID, String assignmentDescription, Date startDateAssignment, Date endDateAssignment, 
			int studentID, String evaluation, Date evaluationDate,int idCourseCore,Field field){
		this.courseID=courseID;
		this.title=title;
		this.startDate=startDate;
		this.endDate=endDate;
		this.status=status;
		this.totalHours=totalHours;
		this.timetable=timetable;
		this.description=description;
		this.syllabus=syllabus;
		this.prereqCoreCourse=prereqCoreCourse;
		this.cost=cost;
		this.discount=discount;
		this.classroom=classroom;
		this.maxStudents=maxStudents;
		this.minStudents=minStudents;
		this.credits=credits;
		this.assignmentID=assignmentID;
		this.assignmentDescription=assignmentDescription;
		this.startDateAssignment=startDateAssignment;
		this.endDateAssignment=endDateAssignment;
		this.studentID=studentID;	
		this.evaluation=evaluation;
		this.evaluationDate=evaluationDate;
		this.idCourseCore=idCourseCore;
		this.field=field;
	}
}