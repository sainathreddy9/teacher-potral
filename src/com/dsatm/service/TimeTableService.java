package com.dsatm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsatm.bean.TimeTableDetails;
import com.dsatm.dao.ITimeTableDao;

@Service("iTimeTableService")
public class TimeTableService implements ITimeTableService {

	@Autowired
	ITimeTableDao iTimeTableDao;

	@Override
	public List<TimeTableDetails> loadTimeTable(String classId, int semester) {
		List<TimeTableDetails> timeTableList = null;

		timeTableList = iTimeTableDao.loadTimeTable(classId, semester);
		return timeTableList;
	}

}
