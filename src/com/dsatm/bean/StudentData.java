package com.dsatm.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class StudentData {
	@NotEmpty(message = "USN cannot be empty")
	private String usn;

	@NotEmpty(message = "Student name cannot be empty")
	private String fullName;

	@NotEmpty(message = "Date of Birth cannot be empty")
	private String dateOfBirth;

	@NotEmpty(message = "Department cannot be empty")
	private String department;

	@NotEmpty(message = "Phone Number cannot be empty")
	private String phoneNo;

	@NotNull(message = "Semester no cannot be empty")
	private Integer semester;

	@NotEmpty(message = "EmailId cannot be empty")
	private String emailId;

	private String teacher_id;

	private String status;

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
