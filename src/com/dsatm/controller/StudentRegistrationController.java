/**
 * 
 */
package com.dsatm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsatm.bean.StudentData;
import com.dsatm.service.IRegistrationService;

@Controller
public class StudentRegistrationController {

	Logger logger = Logger.getLogger(StudentRegistrationController.class);

	@Autowired
	IRegistrationService iRegistrationService;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("studentRegistration")
	public String studentRegistration(Model model, HttpServletResponse response) {
		StudentData student = null;
		student = new StudentData();

		model.addAttribute("studentDetails", student);

		HttpSession session = request.getSession();
		if (session.getAttribute("role") == null) {
			session.invalidate();
			Cookie cookie = new Cookie("role", "");
			cookie.setMaxAge(0);
			cookie = new Cookie("JSESSIONID", "");
			cookie.setMaxAge(0);

			response.addCookie(cookie);
			return "forward:cookieCheck.htm";
		} else {
			return "studentRegistration";
		}
	}

	@RequestMapping("createStudent")
	public String studentRegistration(@ModelAttribute(value = "studentDetails") @Valid StudentData studentData,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("studentDetails", studentData);
			return "studentRegistration";
		} else {
			try {
				int applicantID;
				applicantID = iRegistrationService.createStudentDetails(studentData);
				model.addAttribute("id", applicantID);
				return "success";
			} catch (DataAccessException error) {
				if (error.getMessage().contains("unique constraint (MINI.STUDENT_PK)")) {
					model.addAttribute("error", "Student with USN :" + studentData.getUsn() + " already exists.");
				} else {
					logger.error("Error while creating student \n" + error.getMessage());
					System.out.println("Error while creating student \n" + error.getMessage());
					model.addAttribute("error", "Some technical error, contact Administrator.");
				}
				return "error";
			}
		}
	}
}
