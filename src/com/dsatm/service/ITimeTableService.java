package com.dsatm.service;

import java.util.List;

import com.dsatm.bean.TimeTableDetails;

public interface ITimeTableService {

	public List<TimeTableDetails> loadTimeTable(String classId, int semester);
}
