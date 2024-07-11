package com.dsatm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsatm.bean.TimeTableDetails;

@Repository("iTimeTableDao")
public class TimeTableDao implements ITimeTableDao {

	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;

	Logger logger = Logger.getLogger(TimeTableDao.class);

	@Override
	public List<TimeTableDetails> loadTimeTable(String classId, int semester) {
		logger.info("Request for load timetable.");

		// List<TimeTableDetails> timeTableList = new ArrayList<TimeTableDetails>();
		String sqlStmt = "SELECT  TIMETABLEID, DAY as day, period1, period2, period3, period4, period5 , period6 "
				+ " FROM TIMETABLE_DETAILS TTD" + " INNER JOIN  TIMETABLE TT " + " ON TTD.TIMETABLEID = TT.ID"
				+ " WHERE TT.CLASSID = '" + classId + "' AND TT.SEMESTER = '" + semester + "'";

		List<TimeTableDetails> timeTableList = simpleJdbcTemplate.query(sqlStmt,
				new BeanPropertyRowMapper<TimeTableDetails>(TimeTableDetails.class));

		return timeTableList;
	}

}
