package com.dsatm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsatm.bean.TimeTable;
import com.dsatm.bean.TimeTableDetails;
import com.dsatm.service.ITimeTableService;

@Controller
public class TimeTableController {
	@Autowired
	ITimeTableService iTimeTableService;

	@RequestMapping("viewTimeTable")
	public String classAttendance(@ModelAttribute("timetableDetails") @Valid TimeTable timeTable, BindingResult result,
			Model model) {

		model.addAttribute("timetableDetails", new TimeTable());
		return "viewTimeTable";
	}

	@RequestMapping("loadTimeTable")
	public String loadTimeTable(@ModelAttribute("timetableDetails") @Valid TimeTable timeTable, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("timetableDetails", timeTable);
			return "viewTimeTable";
		}

		List<TimeTableDetails> timeTableDetailsList = iTimeTableService.loadTimeTable(timeTable.getClassId(),
				timeTable.getSemester());

		timeTable.setTimeTableDetails(timeTableDetailsList);

		model.addAttribute("timetableDetails", timeTable);

		return "loadTimeTable";
	}
}
