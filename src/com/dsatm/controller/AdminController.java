package com.dsatm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsatm.service.IUsersService;

@Controller
public class AdminController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	IUsersService usersBO;

	@RequestMapping("contact")
	public String contactUs(Model model) {
		return "contactUs";
	}

	@RequestMapping("history")
	public String history(Model model) {
		return "history";
	}

	@RequestMapping("affiliatedColleges")
	public String affiliatedColleges(Model model) {
		return "affiliatedColleges";
	}

	@RequestMapping("aboutUs")
	public String aboutUs(Model model) {
		return "aboutUs";
	}
}
