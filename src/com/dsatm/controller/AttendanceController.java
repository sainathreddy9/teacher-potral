package com.dsatm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsatm.bean.StudentAttendanceData;
import com.dsatm.bean.ClassData;
import com.dsatm.service.IClassAttendanceService;

@Controller
public class AttendanceController {
	@Autowired
	HttpServletRequest request1;

	@Autowired
	IClassAttendanceService iClassAttendanceService;

	@RequestMapping("classAttendance")
	public String classAttendance(@ModelAttribute("classDetails") @Valid ClassData classData, BindingResult result,
			Model model) {
		
		model.addAttribute("classDetails", new ClassData());
		return "classAttendance";
	}

	@RequestMapping("loadStudents")
	public String loadStudents(@ModelAttribute("classDetails") @Valid ClassData classData, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("classDetails", classData);
			return "classAttendance";
		}

		List<StudentAttendanceData> studentsList = iClassAttendanceService.getStudents(classData.getClassId(),
				classData.getSemester(), classData.getAttenDate());
		List<Integer> studentIdsList = new ArrayList<Integer>();
		for (StudentAttendanceData student : studentsList) {
			studentIdsList.add(student.getStudentId());
		}

		classData.setStudentIdsList(studentIdsList);
		classData.setStudentsList(studentsList);

		model.addAttribute("classDetails", classData);
		return "loadStudents";
	}

	@RequestMapping("createAttendance")
	public String createAttendance(@ModelAttribute("classDetails") @Valid ClassData classData, BindingResult result,
			Model model) {
		String results = null;
		if (result.hasErrors()) {
			model.addAttribute("classDetails", classData);
			return "redirect:loadStudents.htm";
		} else {
			if (classData.getStudentIdsList() != null && !classData.getStudentIdsList().isEmpty()) {
				try {
					results = iClassAttendanceService.createStudentDetails(classData);
					model.addAttribute("results", results);
					model.addAttribute("classData", new ClassData());
					return "classAttendance";
				} catch (DataAccessException dae) {
					model.addAttribute("error", dae.getMessage());
					return "classAttendance";
				}

			} else {
				model.addAttribute("results", "No Student is selected");
				return "classAttendance";
			}
		}
	}
}
