package com.dsatm.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsatm.bean.StudentAttendanceData;
import com.dsatm.bean.ClassData;

@Repository("iClassAttendanceDao")
public class ClassAttendanceDao implements IClassAttendanceDao {

	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;

	Logger logger = Logger.getLogger(ClassAttendanceDao.class);

	@Override
	public List<StudentAttendanceData> getStudents(String classId, int semester, String attnDate) {
		logger.info("Request for scheduled programs");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date tmpDate = null;
		
		try {
			tmpDate = format1.parse(attnDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attnDate = format.format(tmpDate);
		String sqlStmt = "SELECT count(*) from CLASS_ATTENDANCE where CLASS = ? and SEMESTER = ? and ATTNDATE = ?";
		Object[] params = new Object[] { classId, semester, attnDate };

		int id = 0;
		id = simpleJdbcTemplate.queryForInt(sqlStmt, params);

		if (id != 0) {
			sqlStmt = "SELECT ID from CLASS_ATTENDANCE where CLASS = ? and SEMESTER = ? and ATTNDATE = ?";
			id = simpleJdbcTemplate.queryForInt(sqlStmt, params);
			sqlStmt = "SELECT s.ID as studentId, s.USN, s.STUDENT_NAME, st.ATTN_STATUS as STATUS FROM STUDENT s "
					+ "INNER JOIN STUDENT_ATTENDANCE st on s.id = st.student_id " + " WHERE st.class_attn_id = " + id
					+ " ORDER BY STUDENT_NAME";
		} else {
			sqlStmt = "SELECT ID as studentId, USN, STUDENT_NAME, 'Y' as STATUS FROM STUDENT " + " WHERE DEPT_NAME = '"
					+ classId + "' AND SEMESTER_SECTION = " + semester + " ORDER BY STUDENT_NAME";
		}
		List<StudentAttendanceData> studentsList = new ArrayList<StudentAttendanceData>();

		studentsList = simpleJdbcTemplate.query(sqlStmt,
				new BeanPropertyRowMapper<StudentAttendanceData>(StudentAttendanceData.class));

		return studentsList;
	}

	public String insertStudentDetails(ClassData classData) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		boolean updateFlag = false;
		String updateStr = "created";
		String sqlstmt = "";
		Date tmpDate = null;
		try {
			tmpDate = format1.parse(classData.getAttenDate().replaceAll("/", "-"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String attenDate = format.format(tmpDate);
		List<StudentAttendanceData> studentsList = getStudents(classData.getClassId(), classData.getSemester(),
				classData.getAttenDate());
		ClassData classData1 = loadClassAttendance(classData);
		int id = 0;
		if (classData1 != null && classData1.getId() != 0) {
			id = classData1.getId();
			updateFlag = true;
		} else {
			id = simpleJdbcTemplate.queryForInt("SELECT CLASS_ATTENDANCE_ID_SEQ.NEXTVAL FROM DUAL");
		}

		if (!updateFlag) {
			sqlstmt = "INSERT INTO CLASS_ATTENDANCE (ID, CLASS, SEMESTER, ATTNDATE, TEACHER_ID) "
					+ " VALUES(?, ?, ?, ?, ?)";

			Object[] params = new Object[] { id, classData.getClassId(), classData.getSemester(), attenDate,
					classData.getTeacherId() };

			simpleJdbcTemplate.update(sqlstmt, params);
		}

		List<Integer> studentIdsList = classData.getStudentIdsList();
		List<StudentAttendanceData> tempStudentsList = classData.getStudentsList();
		String attnStatus = "N";
		String previousStatus = "N";
		if (updateFlag) {
			updateStr = "updated";
			sqlstmt = "UPDATE STUDENT_ATTENDANCE SET ATTN_STATUS=?, UPDATED_DATE = CURRENT_TIMESTAMP, UPDATED_BY = ? WHERE CLASS_ATTN_ID = ? AND STUDENT_ID = ?";
			for (StudentAttendanceData student : studentsList) {
				previousStatus = student.getStatus();
				if (studentIdsList.contains(student.getStudentId())) {
					attnStatus = "Y";
				} else {
					attnStatus = "N";
				}
				if(!previousStatus.equals(attnStatus)) {
					Object[] paramsDelete = new Object[] { attnStatus, classData.getTeacherId(), id, student.getStudentId() };
					simpleJdbcTemplate.update(sqlstmt, paramsDelete);
				}
			}
		} else {
			sqlstmt = "INSERT INTO STUDENT_ATTENDANCE (CLASS_ATTN_ID, STUDENT_ID, ATTN_STATUS, UPDATED_BY) " + "values (?, ?, ?, ?)";
			for (StudentAttendanceData student : studentsList) {
				if (studentIdsList.contains(student.getStudentId())) {
					attnStatus = "Y";
				} else {
					attnStatus = "N";
				}
				Object[] params1 = new Object[] { id, student.getStudentId(), attnStatus, classData.getTeacherId() };
				simpleJdbcTemplate.update(sqlstmt, params1);
			}
		}
		String result = "Class Attendance " + updateStr + " successfully, Class : '" + classData.getClassId()
				+ "' for Section :" + classData.getSemester() + " for Date :" + classData.getAttenDate();
		logger.info(result);

		return result;
	}

	public ClassData loadClassAttendance(ClassData classData) {
		ClassData classData1 = null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date tmpDate = null;
		try {
			tmpDate = format1.parse(classData.getAttenDate().replaceAll("/", "-"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String attenDate = format.format(tmpDate);
		String sqlStmt = "SELECT ID, CLASS, SEMESTER, ATTNDATE, TEACHER_ID FROM CLASS_ATTENDANCE " + " WHERE CLASS = '"
				+ classData.getClassId() + "' AND ATTNDATE = '" + attenDate + "'";
		List<ClassData> classDataList = new ArrayList<ClassData>();
		classDataList = simpleJdbcTemplate.query(sqlStmt, new BeanPropertyRowMapper<ClassData>(ClassData.class));
		if (classDataList != null && !classDataList.isEmpty()) {
			classData1 = classDataList.get(0);
		}
		return classData1;
	}
}
