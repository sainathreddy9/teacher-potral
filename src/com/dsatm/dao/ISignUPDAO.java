package com.dsatm.dao;

import com.dsatm.bean.Teacher;

public interface ISignUPDAO {
	public int insertAdminSingUp(Teacher userDTO);
	public Teacher loadTeacherProfile(String teacherId);
	public Teacher updateTeacherProfile(Teacher teacherDto);
}
