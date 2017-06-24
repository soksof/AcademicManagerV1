package gr.haec.academic.model;

import java.util.Date;

public class Assignments {

	/**
	 * declaring the variables which we have taken from the data base table of assignments and studentassignments.
	 */
	
	protected float grades;
	protected int assignmentID;
	protected Date submitDate;
	protected String description;
	protected Date startDate;
	protected Date endDate;
	protected String answer;
	protected String comments;
	
	/**
	 *Setters and Getters for all the variables. 
	 */
	
	public float getGrades() {
		return grades;
	}

	public void setGrades(float grades) {
		this.grades = grades;
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
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
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
	
	public String getAnswer(){
		return answer;
	}
	
	public void setAnswer(String answer){
		this.answer=answer;
	}
	
	public String getComments(){
		return comments;
	}
	
	public void setComments(String comments){
		this.comments=comments;
	}
	
	/**
	 * Constructor with all the information for an assignment.
	 * 
	 */
	
	public Assignments(float grades,int assignmentID, Date submitDate,String description,Date startDate,Date endDate,
			String answer,String comments){
		
		this.grades=grades;
		this.assignmentID=assignmentID;
		this.submitDate=submitDate;
		this. description= description;
		this.startDate=startDate;
		this.endDate=endDate;
		this.answer=answer;
		this.comments=comments;
		
		
	}
	
}

