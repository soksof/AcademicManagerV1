package gr.haec.academic.model;

/**
 *  declaring the ENUM choices for the teacher status.
 */

public enum Status {
	Teacher_Applicant("Teacher Applicant"),
	Teacher_Course_Applicant("Teacher Course Applicant"),
	Course_Teacher("Course Teacher");
	
	private final String longForm;
	
	Status(final String longForm){
		this.longForm=longForm;
	}
	
	public String getLongForm(){
		return this.longForm;
	}
	@Override
	public String toString(){
		return this.longForm;
	}
	public static Status getValue(String s) {
		  for(Status e: Status.values()) {
		    if(e.longForm.compareTo(s)==0) {
		      return e;
		    }
		  }
		  return null;// not found
		}
}
