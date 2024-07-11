package com.dsatm.service;

import com.dsatm.bean.Teacher;

public interface ISignUPService {
	public int insertAdminSingUp(Teacher userDTO);
	public Teacher loadTeacherProfile(String teacherId);
	public Teacher updateTeacherProfile(Teacher userDTO);
}
