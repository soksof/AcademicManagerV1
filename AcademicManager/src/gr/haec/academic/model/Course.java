package gr.haec.academic.model;

import java.sql.Date;

public class Course {

	private int courseID;
	private String title;
	private Date startDate;
	private Date endDate;
	private Status status;
	private int totalHours;
	private String timetable;
	private String description;
	private String syllabus;
	private int prereqCourseID;
	private int cost;
	private int discount;
	private String classroom;
	private int maxStudents;
	private int minStudents;
	private int credits;
	protected int assignmentID;
	private String assignmentDescription;
	protected Date startDateAssignment;
	protected Date endDateAssignment;
	protected int studentID;
	protected String evaluation;
	protected Date evaluationDate;
	
	
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
		return prereqCourseID;
	}
	public void setPrereqCourseID(int prereqCourseID) {
		this.prereqCourseID = prereqCourseID;
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

	
	public Course(int courseID, String title, Date startDate,Date endDate, Status status, int totalHours, String timetable, 
			String description, String syllabus, int prereqCourseID, int cost, int discount, String classroom, int maxStudents, 
			int minStudents, int credits, int assignmentID, String assignmentDescription, Date startDateAssignment, Date endDateAssignment, 
			int studentID, String evaluation, Date evaluationDate){
		this.courseID=courseID;
		this.title=title;
		this.startDate=startDate;
		this.endDate=endDate;
		this.status=status;
		this.totalHours=totalHours;
		this.timetable=timetable;
		this.description=description;
		this.syllabus=syllabus;
		this.prereqCourseID=prereqCourseID;
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
	}
	
}
