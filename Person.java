package CSC3610_Group_Project;

import java.util.Date;

public class Person {
	
	//Variables 
	private String firstName, lastName, phone, email, address, userName, password;
	private Date DOB; 
	private int SSN;
	
	//constructor
	public Person(String firstName, String lastName, String phone, String email, String address, String userName,
			String password, Date dOB, int SSN) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.DOB = dOB;
		this.SSN = SSN;
	}

	//Constructor
	public Person() {
		super();
	}
	
	// getters and setters
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

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + ", DOB=" + DOB
				+ ", SSN=" + SSN + "]";
	}

}
