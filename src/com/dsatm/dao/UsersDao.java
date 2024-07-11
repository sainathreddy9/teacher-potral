package com.dsatm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsatm.bean.Login;

@Repository("usersDao")
public class UsersDao implements IUsersDao {

	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;

	public Login getLogin(Login login) {

		List<Map<String, Object>> user = simpleJdbcTemplate.queryForList(
				"SELECT teacher_id, password, first_name, middle_name, last_name FROM teacher WHERE teacher_id = ?",
				login.getLoginID());

		login = new Login();
		login.setLoginID((String) user.get(0).get("teacher_id"));
		login.setPassword((String) user.get(0).get("password"));
		login.setFullName(user.get(0).get("first_name") + " " + user.get(0).get("middle_name") + " "
				+ user.get(0).get("last_name"));
		return login;
	}

}
