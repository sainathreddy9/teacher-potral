package com.dsatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsatm.bean.StudentData;
import com.dsatm.dao.IStudentRegistrationDao;

@Service("iRegistrationService")
public class RegistrationService implements IRegistrationService {
	@Autowired
	IStudentRegistrationDao iRegistrationDao;

	public int createStudentDetails(StudentData studentDataa) {
		return iRegistrationDao.insertStudentDetails(studentDataa);
	}
}
