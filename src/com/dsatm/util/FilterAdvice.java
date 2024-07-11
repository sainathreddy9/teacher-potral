package com.dsatm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class FilterAdvice {

	@Autowired
	HttpServletRequest request;

	public void beforeMethod() {

		HttpSession session = request.getSession(false);

		// By default the student menu is displayed.
		request.setAttribute("status", "student");

		if (session != null) {
			Cookie[] cookie = ((HttpServletRequest) request).getCookies();
			if (cookie != null) {
				for (Cookie temp : cookie) {
					if (temp.getName().equals("role")) {
						/*
						 * If session is found and contains cookie as role Role is set to the request
						 * attribute and logged in status is set
						 */
						request.setAttribute("role", temp.getValue());
						request.setAttribute("status", "auth");
						break;
					}
				}
			}
		}
	}

}
