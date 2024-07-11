package com.dsatm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsatm.bean.StudentAttendanceData;
import com.dsatm.bean.ClassData;
import com.dsatm.dao.IClassAttendanceDao;

@Service("iClassAttendanceService")
public class ClassAttendanceService implements IClassAttendanceService {

	@Autowired
	IClassAttendanceDao iClassAttendanceDao;

	@Override
	public List<StudentAttendanceData> getStudents(String classId, int semester, String attnDate) {
		List<StudentAttendanceData> studentList = null;

		studentList = iClassAttendanceDao.getStudents(classId, semester, attnDate);
		return studentList;
	}

	@Override
	public String createStudentDetails(ClassData classData) {
		return iClassAttendanceDao.insertStudentDetails(classData);
	}
}
