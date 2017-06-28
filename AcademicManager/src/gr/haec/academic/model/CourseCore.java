package gr.haec.academic.model;

public class CourseCore {
	private int ccID;
	private String ccCode;
	private String ccTitle;
	private String ccDescr;
	private Field field;
	private String prereqCcCode;

	/**
	 * default constructor
	 */
	public CourseCore(){
		
	}
	/**
	 * constructor using all fields
	 * @param ccID
	 * @param ccCode
	 * @param ccTitle
	 * @param ccDescr
	 * @param field
	 * @param prereqCcCode
	 */
	public CourseCore(int ccID, String ccCode, String ccTitle, String ccDescr, String prereqCcCode, Field field) {
		super();
		this.ccID = ccID;
		this.ccCode = ccCode;
		this.ccTitle = ccTitle;
		this.ccDescr = ccDescr;
		this.field = field;
		this.prereqCcCode = prereqCcCode;
	}
	/**
	 * @return the ccID
	 */
	public int getCcID() {
		return ccID;
	}
	/**
	 * @param ccID the ccID to set
	 */
	public void setCcID(int ccID) {
		this.ccID = ccID;
	}
	/**
	 * @return the ccCode
	 */
	public String getCcCode() {
		return ccCode;
	}
	/**
	 * @param ccCode the ccCode to set
	 */
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}
	/**
	 * @return the ccTitle
	 */
	public String getCcTitle() {
		return ccTitle;
	}
	/**
	 * @param ccTitle the ccTitle to set
	 */
	public void setCcTitle(String ccTitle) {
		this.ccTitle = ccTitle;
	}
	/**
	 * @return the ccDescr
	 */
	public String getCcDescr() {
		return ccDescr;
	}
	/**
	 * @param ccDescr the ccDescr to set
	 */
	public void setCcDescr(String ccDescr) {
		this.ccDescr = ccDescr;
	}
	/**
	 * @return the field
	 */
	public Field getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(Field field) {
		this.field = field;
	}
	/**
	 * @return the prereqCcCode
	 */
	public String getPrereqCcCode() {
		return prereqCcCode;
	}
	/**
	 * @param prereqCcCode the prereqCcCode to set
	 */
	public void setPrereqCcCode(String prereqCcCode) {
		this.prereqCcCode = prereqCcCode;
	}
	
}
