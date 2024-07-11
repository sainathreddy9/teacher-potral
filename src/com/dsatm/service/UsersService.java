package com.dsatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsatm.bean.Login;
import com.dsatm.dao.IUsersDao;

@Service("usersBO")
public class UsersService implements IUsersService {

	@Autowired
	IUsersDao usersDAO;

	public Login getLogin(Login login) {
		return usersDAO.getLogin(login);
	}
}
