package com.dsatm.service;

import java.util.List;

import com.dsatm.bean.StudentAttendanceData;
import com.dsatm.bean.ClassData;

public interface IClassAttendanceService {
	public List<StudentAttendanceData> getStudents(String classId, int semester, String attnDate);
	public String createStudentDetails(ClassData classData);
}
