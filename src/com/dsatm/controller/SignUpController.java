package com.dsatm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsatm.bean.Login;
import com.dsatm.bean.Teacher;
import com.dsatm.service.ISignUPService;

@Controller

public class SignUpController {
	@Autowired
	ISignUPService iSignUpService;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("adminSignUp")
	public String adminSignUp(Model model) {
		Teacher userDTO = null;
		userDTO = new Teacher();
		model.addAttribute("adminDetails", userDTO);
		return "adminSignUp";
	}

	@RequestMapping("checkSignUp")
	public String checkSignUp(@ModelAttribute("adminDetails") @Valid Teacher userDTO, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("adminDetails", userDTO);
			return "adminSignUp";
		} else if (!userDTO.getConfirmPassword().matches(userDTO.getPassword())) {
			model.addAttribute("error1", "Password missmatch");
			return "adminSignUp";
		} else {
			try {
				int count = iSignUpService.insertAdminSingUp(userDTO);
				if(count == 0) {
					model.addAttribute("error", "Incorrect Admin password. ");
					return "adminSignUp";
				} else {
					model.addAttribute("error", "Signup successful, Enter your credentials to login.");
					model.addAttribute("loginBean", new Login());
					return "login";
				}
			} catch (DataAccessException dae) {
				model.addAttribute("error", dae.getMessage());
				return "adminSignUp";
			}

		}
	}

	@RequestMapping("loadTeacherProfile")
	public String loadTeacherProfile(@ModelAttribute("adminDetails") @Valid Teacher userDTO, BindingResult result,
			Model model) {
		String teacherId = (String) request.getSession().getAttribute("teacher_id");
		Teacher teacher = iSignUpService.loadTeacherProfile(teacherId);
		model.addAttribute("adminDetails", teacher);
		return "loadTeacherProfile";
	}

	@RequestMapping("updateProfile")
	public String updateProfile(@ModelAttribute("adminDetails") @Valid Teacher teacherDto, BindingResult result,
			Model model) {
		String teacherId = (String) request.getSession().getAttribute("teacher_id");
		teacherDto.setTeacherId(teacherId);
		try {
			Teacher teacher = iSignUpService.updateTeacherProfile(teacherDto);
			model.addAttribute("results", "Profile Updated successfully.");
			model.addAttribute("adminDetails", teacher);
			return "loadTeacherProfile";
		} catch (DataAccessException dae) {
			model.addAttribute("error", "Some technical error contact Syatem Administrator");
			return "loadTeacherProfile";
		}
	}

}
