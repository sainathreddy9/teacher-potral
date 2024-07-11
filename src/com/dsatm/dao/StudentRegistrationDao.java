package com.dsatm.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsatm.bean.StudentData;

@Repository("iRegistrationDao")
public class StudentRegistrationDao implements IStudentRegistrationDao {

	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;

	Logger logger = Logger.getLogger(StudentRegistrationDao.class);

	public StudentRegistrationDao() {
	}

	public int insertStudentDetails(StudentData studentData) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date tmpDate = null;
		try {
			tmpDate = format1.parse(studentData.getDateOfBirth());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dob = format.format(tmpDate);

		int id = simpleJdbcTemplate.queryForInt("SELECT STUDENT_ID_SEQ.NEXTVAL FROM DUAL");

		String sqlstmt = "INSERT INTO Student (ID, USN, STUDENT_NAME, DOB, DEPT_NAME,"
				+ " SEMESTER_SECTION, PHONE, EMAILID, TEACHER_ID, STATUS)" + " VALUES(?, ?, ?, ?, " + "?, ?, ?, "
				+ "?, ?, ?)";

		Object[] params = new Object[] { id, studentData.getUsn(), studentData.getFullName(), dob,
				studentData.getDepartment(), studentData.getSemester(), studentData.getPhoneNo(),
				studentData.getEmailId(), studentData.getTeacher_id(), "created" };

		simpleJdbcTemplate.update(sqlstmt, params);

		logger.info("Student created successfully, Student ID: " + id + ", Name:" + studentData.getFullName());

		return id;
	}
}