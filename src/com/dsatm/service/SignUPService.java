package com.dsatm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsatm.bean.Teacher;
import com.dsatm.dao.ISignUPDAO;

@Service("iSignUpService")
public class SignUPService implements ISignUPService {
	@Autowired
	ISignUPDAO iSignUpDAO;

	@Override
	public int insertAdminSingUp(Teacher teacherDto) {
		return iSignUpDAO.insertAdminSingUp(teacherDto);
	}

	@Override
	public Teacher loadTeacherProfile(String teacherId) {
		return iSignUpDAO.loadTeacherProfile(teacherId);
	}

	@Override
	public Teacher updateTeacherProfile(Teacher teacherDto) {
		return iSignUpDAO.updateTeacherProfile(teacherDto);
	}
}
