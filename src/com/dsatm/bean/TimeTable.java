package com.dsatm.bean;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class TimeTable {
	private int id;

	@NotEmpty(message = "Class cannot be empty")
	private String classId;

	private int semester;

	private List<TimeTableDetails> timeTableDetails;

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

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public List<TimeTableDetails> getTimeTableDetails() {
		return timeTableDetails;
	}

	public void setTimeTableDetails(List<TimeTableDetails> timeTableDetails) {
		this.timeTableDetails = timeTableDetails;
	}

}
