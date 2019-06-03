package com.yh.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.yh.jdbc.dao.IStudentDao;
import com.yh.jdbc.dao.impl.StudentDaoImpl;
import com.yh.jdbc.daomain.Student;

public class StudentDaoTest {
	public static void main(String[] args) {
		//����һ��ѧ��
		Student stu = new Student();
		stu.setName("����");
		stu.setAge(11);
		//��ѧ�����浽���ݿ���
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}
	
	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(1);
	}
	
	@Test
	public void get() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.get(768);
		System.out.println(stu);
	}
	
	@Test
	public void getAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allstu = dao.getALL();
		System.out.println(allstu);
	}
	
	

}
