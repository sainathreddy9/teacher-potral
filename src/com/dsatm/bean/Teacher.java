package com.dsatm.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Teacher {
	@NotEmpty(message = "Teacher Id cannot be empty")
	private String teacherId;

	@NotEmpty(message = "First name cannot be empty")
	private String firstName;

	private String middleName;

	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;

	@NotEmpty(message = "Date of Birth cannot be empty")
	private String dob;

	@NotEmpty(message = "PassWord cannot be empty")
	@Size(min = 5, max = 12, message = "Password should be in between 5 to 12 characters")
	private String password;

	@NotEmpty(message = "Password cannot be empty")
	private String confirmPassword;

	private String qualification;

	private int experience;

	private String phone;

	private String emailId;

	private String department;
	
	private String apassword;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public String getapassword() {
		return apassword;
	}
	public void setapassword(String aPassword) {
		this.apassword = aPassword;
	}
}
