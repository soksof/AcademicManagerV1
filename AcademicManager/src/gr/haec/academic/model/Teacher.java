package gr.haec.academic.model;

import java.util.Date;

public class Teacher extends Person {

	protected Status status;
	protected String cv;
	protected Field field;

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

	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String password, String taxNumber, String iban, Role role, Status status,
			String cv, Field field) {
		super(personID, name, surname, email, phone, sex, address, dob, username, password, taxNumber, iban, role);
		this.status = status;
		this.cv = cv;
		this.field = field;
	}

	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role, String cv, Field field) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.cv = cv;
		this.field = field;
	}

	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
	}

	// constructor for courses and teachers that teach them
	public Teacher(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String password, String taxNumber, String iban, Role role, String cv,
			Field field) {
		super(personID, name, surname, email, phone, sex, address, dob, username, taxNumber, iban, role);
		this.cv = cv;
		this.field = field;
	}
}