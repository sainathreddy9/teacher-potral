package com.dsatm.bean;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassData {
	private int id;
	@NotEmpty(message = "Class cannot be empty")
	private String classId;
	private String teacherId;
	@NotEmpty(message = "Date cannot be empty")
	private String attenDate;
	private int semester;
	private List<StudentAttendanceData> studentsList;
	private List<Integer> studentIdsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getAttenDate() {
		return attenDate;
	}

	public void setAttenDate(String attenDate) {
		this.attenDate = attenDate;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public List<StudentAttendanceData> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<StudentAttendanceData> studentsList) {
		this.studentsList = studentsList;
	}

	public List<Integer> getStudentIdsList() {
		return studentIdsList;
	}

	public void setStudentIdsList(List<Integer> studentIdsList) {
		this.studentIdsList = studentIdsList;
	}
}
