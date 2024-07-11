package com.dsatm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsatm.bean.Login;
import com.dsatm.service.IUsersService;

@Controller
public class AuthorizationController {

	Logger logger = Logger.getLogger(AuthorizationController.class);
	@Autowired
	HttpServletRequest request;

	@Autowired
	IUsersService usersBO;

	@RequestMapping(value = "home")
	public String homePage(Model model) {
		return "homePage";
	}

	@RequestMapping(value = "authorize")
	public String loginPage(Model model) {
		if (request.getSession().getAttribute("role") != null)
			return "forward:authorized.htm";
		else {
			request.setAttribute("status", "student");
			return "forward:cookieCheck.htm";
		}
	}

	@RequestMapping(value = "cookieCheck")
	public String cookieCheck(HttpServletResponse response) {
		Cookie cookie = new Cookie("test", "");
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		return "redirect:cookieValidation.htm";
	}

	@RequestMapping(value = "cookieValidation")
	public String validateCookie(Model model) {
		boolean flag = false;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie temp : cookies) {
				if (temp.getName().equals("test")) {
					flag = true;
					break;
				}
			}
		}
		if (flag) {
			model.addAttribute("loginBean", new Login());
			return "login";
		} else {
			return "failure";
		}
	}

	@RequestMapping(value = "authorized")
	public String authorize(Model model) {
		// HttpSession session = request.getSession(true);
		if ("admin".equals(request.getAttribute("role"))) {
			return "successLogin";
		} else
			return "forward:mac.htm";
	}

	@RequestMapping(value = "signOut", method = RequestMethod.POST)
	public String signOut(HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();

		Cookie cookie = new Cookie("role", "");
		cookie.setMaxAge(0);
		cookie = new Cookie("JSESSIONID", "");
		cookie.setMaxAge(0);

		response.addCookie(cookie);

		return "redirect:signingout.htm";
	}

	@RequestMapping(value = "login")
	public String loginAction(Model model, Login login, HttpServletResponse response) {
		logger.info("called loginAction");
		try {
			Login originalLogin = usersBO.getLogin(login);
			if (originalLogin.getPassword().equals(login.getPassword())) {
				// if (true) {
				if (!login.getRemember()) {
					request.getSession();
					// Cookie cookie = new Cookie("role",
					// originalLogin.getLoginID());
					Cookie cookie = new Cookie("role", "admin");
					response.addCookie(cookie);
					request.getSession().setAttribute("role", "admin");
					request.getSession().setAttribute("teacher_id", login.getLoginID());
					request.getSession().setAttribute("teacher_name", "Rama");
				} else {
					HttpSession session = request.getSession();
					String id = session.getId();

					Cookie cookie = new Cookie("JSESSIONID", id);
					cookie.setMaxAge(60 * 60 * 24);
					cookie.setPath("UniversityAdmissionSystem");
					response.addCookie(cookie);
					// cookie = new Cookie("role", originalLogin.getLoginID());
					cookie = new Cookie("role", "admin");
					response.addCookie(cookie);
					request.getSession().setAttribute("role", "admin");
					request.getSession().setAttribute("teacher_id", login.getLoginID());
					request.getSession().setAttribute("teacher_name", "Rama");
				}
				return "redirect:authorize.htm";
			} else {
				model.addAttribute("error", "Invalid Login or Password");
				model.addAttribute("loginBean", new Login());
				return "login";
			}
		} catch (DataAccessException e) {
			model.addAttribute("error", "Invalid Login/Password");
			model.addAttribute("loginBean", new Login());
			return "login";
		} catch (Exception e) {
			model.addAttribute("error", "Invalid Login/Password");
			model.addAttribute("loginBean", new Login());
			return "login";
		}

	}

	@RequestMapping("signingout")
	public String signingOut(Model model) {

		if ("student".equals(request.getAttribute("status"))) {
			model.addAttribute("error", "Logout successful");
			model.addAttribute("loginBean", new Login());
			return "login";
		} else
			return "redirect:authorize.htm";
	}

}
