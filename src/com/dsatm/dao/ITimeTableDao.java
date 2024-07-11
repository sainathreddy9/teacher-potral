package com.dsatm.dao;

import java.util.List;

import com.dsatm.bean.TimeTableDetails;

public interface ITimeTableDao {
	public List<TimeTableDetails> loadTimeTable(String classId, int semester);
}
