package project;

import java.util.Date;

public abstract class Person {
	
	
	//Variables 
	private String firstName, lastName, phone, email, address, userName, password;
	private Date DOB; 
	private int SSN;
	
	//Constructor
	public Person() {
		super();
	}
	
	//protected getters and setters
	protected String getFirstName() {
		return firstName;
	}	
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected String getPhone() {
		return phone;
	}
	protected void setPhone(String phone) {
		this.phone = phone;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getAddress() {
		return address;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	protected String getUserName() {
		return userName;
	}
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected Date getDOB() {
		return DOB;
	}
	protected void setDOB(Date dOB) {
		DOB = dOB;
	}
	protected int getSSN() {
		return SSN;
	}
	protected void setSSN(int sSN) {
		SSN = sSN;
	}
	
	

}
