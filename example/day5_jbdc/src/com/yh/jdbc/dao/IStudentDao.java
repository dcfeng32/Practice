package com.yh.jdbc.dao;

import java.util.List;

import com.yh.jdbc.daomain.Student;

public interface IStudentDao {
	//1.��������
	void save(Student stu);
	
	//2.�޸�ָ��ѧ������Ϣ
	void update(Student stu);
	
	//3.ɾ��ѧ��
	void delete(int id);
	
	//4.��ȡָ����ѧ��   
	Student get(int id);
	
	//5.��ȡ���е�ѧ��    
	List<Student> getALL();
	
	
	

}
