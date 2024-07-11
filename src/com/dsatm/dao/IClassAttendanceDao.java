package com.dsatm.dao;

import java.util.List;

import com.dsatm.bean.StudentAttendanceData;
import com.dsatm.bean.ClassData;

public interface IClassAttendanceDao {
	public List<StudentAttendanceData> getStudents(String classId, int semester, String attnDate);
	public String insertStudentDetails(ClassData classData);
}
