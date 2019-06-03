package com.yh.jdbc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.yh.jdbc.dao.IStudentDao;
import com.yh.jdbc.daomain.Student;
import com.yh.jdbc.utils.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public void save(Student stu) {
		String sql = "insert into student (name,age) values (?,?)";
		//
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			qr.update(sql, stu.getName(), stu.getAge());
			             //stu.setName("fds");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student stu) {
		String sql = "update student set age = ? where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		Integer age = stu.getAge();
		try {
			qr.update(sql,age, stu.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from student where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student get(int id) {
		String sql = "select * from student where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			return qr.query(sql, new BeanHandler<Student>(Student.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getALL() {
		String sql = "select * from student";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			return qr.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

	@Override
	public Integer getCount() {
		
		return null;
	}

	

}
