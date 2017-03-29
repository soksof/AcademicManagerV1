package gr.haec.academic.model;

public enum Status {
	Teacher_Applicant("Teacher Applicant"),
	Teacher_Course_Applicant("Teacher Course Applicant"),
	Course_Teacher("Course Teacher");
	
	private String longForm;
	
	Status(String longForm){
		this.longForm=longForm;
	}
	
	public String getLongForm(){
		return this.longForm;
	}
	@Override
	public String toString(){
		return this.longForm;
	}
}
