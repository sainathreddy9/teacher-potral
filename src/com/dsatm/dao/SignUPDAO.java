package com.dsatm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsatm.bean.Teacher;

@Repository("iSignUpDAO")

public class SignUPDAO implements ISignUPDAO {
	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;
	 
	public int insertAdminSingUp(Teacher userDTO) {
		String ap="Mlpqaz@2019";
		int count = 0;
		if(ap.equals(userDTO.getapassword())) {
		
			String sql = "INSERT INTO users VALUES(?,?)";
			sql = "Insert into teacher (TEACHER_ID, FIRST_NAME, MIDDLE_NAME," + "LAST_NAME, DOB, PASSWORD, DEPT_NAME,"
					+ "PHONE, EMAILID, QUALIFICATION, YEARSOFEXP " + ") values (?, ?, ?," + "?, ?, ?, ?," + "?, ?, ?, ?)";
			Object[] params = new Object[] { userDTO.getTeacherId(), userDTO.getFirstName(), userDTO.getMiddleName(),
					userDTO.getLastName(), userDTO.getDob(), userDTO.getPassword(), userDTO.getDepartment(),
					userDTO.getPhone(), userDTO.getEmailId(), userDTO.getQualification(), userDTO.getExperience() };
			count = simpleJdbcTemplate.update(sql, params);
		}
		//System.out.println("hi" + count);
		return count;
		
	}

	public Teacher loadTeacherProfile(String teacherId) {
		Teacher teacher = new Teacher();
		String sqlQuery = "SELECT TEACHER_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, DOB, PASSWORD, DEPT_NAME as department,"
				+ "PHONE, EMAILID, QUALIFICATION, YEARSOFEXP as experience FROM TEACHER WHERE TEACHER_ID ='" + teacherId
				+ "'";
		List<Teacher> teachersList = new ArrayList<Teacher>();
		teachersList = simpleJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Teacher>(Teacher.class));
		if (teachersList != null && !teachersList.isEmpty()) {
			teacher = teachersList.get(0);
		}
		return teacher;
	}

	public Teacher updateTeacherProfile(Teacher teacherDto) {
		String updateQuery = "UPDATE TEACHER set DEPT_NAME = ?, PHONE = ?, EMAILID = ?, QUALIFICATION = ?,"
				+ " YEARSOFEXP = ? WHERE TEACHER_ID = ?";
		Object[] params = new Object[] { teacherDto.getDepartment(), teacherDto.getPhone(), teacherDto.getEmailId(),
				teacherDto.getQualification(), teacherDto.getExperience(), teacherDto.getTeacherId() };
		simpleJdbcTemplate.update(updateQuery, params);
		return loadTeacherProfile(teacherDto.getTeacherId());

	}

}
