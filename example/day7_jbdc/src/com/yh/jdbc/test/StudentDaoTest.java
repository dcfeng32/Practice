package com.yh.jdbc.test;

import java.util.List;

import org.junit.Test;
import com.yh.jdbc.dao.impl.StudentDaoImpl;
import com.yh.jdbc.dao.IStudentDao;
import com.yh.jdbc.daomain.Student;

public class StudentDaoTest {

	@Test
	public void save() {
		// ����һ��ѧ������
		Student stu = new Student();
		// �����Ը�ֵ
		stu.setName("����28");
		stu.setAge(12);
		// ��ѧ�����浽���ݿ���
		IStudentDao dao = new StudentDaoImpl();
		dao.save(stu);
	}

	@Test
	public void update() {
		Student stu = new Student();
		stu.setAge(260);
		stu.setId(7);
		IStudentDao dao = new StudentDaoImpl();
		dao.update(stu);
	}

	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(1);
	}

	@Test
	public void get() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.get(3);
		// ������ҵ�����
		System.out.println(stu);
	}

	@Test
	public void getAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allstu = dao.getALL();
		System.out.println(allstu);
	}

	@Test
	public void getCount() {
		IStudentDao dao = new StudentDaoImpl();
		System.out.println(dao.getCount());
	}

}
