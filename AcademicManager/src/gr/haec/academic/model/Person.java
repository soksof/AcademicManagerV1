package gr.haec.academic.model;

import java.util.Date;

/**
 * declaring the variables which we have taken from the data base table of person.
 */

public class Person {

	protected int personID;
	protected String name;
	protected String surname;
	protected String email;
	protected String phone;
	protected Sex sex;
	protected String address;
	protected Date dob;
	protected String username;
	protected String password;
	protected String taxNumber;
	protected String iban;
	protected Role role;

	/**
	 *Setters and Getters for all the variables. 
	 */
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(String x) {
		this.sex = Sex.valueOf(x);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(String r) {
		this.role = Role.valueOf(r);
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * This constructor contains all the informations of a person.
	 * Currently don't used at any query of personDao.
	 */
	
	public Person(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String password, String taxNumber, String iban, Role role) {
		this.personID = personID;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.address = address;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.taxNumber = taxNumber;
		this.iban = iban;
		this.role = role;
	}
	
	/**
	 * This constructor contains all the informations of a person without the password.
	 * Currently used at every query of personDao.
	 */
	
	public Person(int personID, String name, String surname, String email, String phone, Sex sex, String address,
			Date dob, String username, String taxNumber, String iban, Role role) {
		this.personID = personID;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.address = address;
		this.dob = dob;
		this.username = username;
		this.taxNumber = taxNumber;
		this.iban = iban;
		this.role = role;
	}
	/**
	 * This constructor contains only the personID,name,surname and role of a person.
	 */
	public Person(int personID, String name, String surname,Role role){
		this.personID = personID;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	
	/**
	 * Overriding toString method.
	 */
	
	public String toString(){
		return this.name+" "+this.surname+" is a "+this.role;
	}
}