package com.yh.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yh.jdbc.dao.IStudentDao;
import com.yh.jdbc.daomain.Student;
import com.yh.jdbc.utils.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {
	@Override
	public void save(Student stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			// 3.�������
			String sql = "insert into student(name,age)" + "values(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,stu.getName());
			ps.setInt(2,stu.getAge());
			// 4.ִ�����
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}

	}

	@Override
	public void update(Student stu) {
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			// 3.�������
			String sql = "delete from student where id = ? ";
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1,id);
			// 4.ִ�����
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//ts�Ǹ��࣬ps���������ֱ�Ӽ̳�
			JDBCUtil.close(conn, ps, null);
		}
	}

	@Override
	public Student get(int id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			// 3.�������
			st = conn.createStatement();
			String sql = "select * from student where id = " + id + "";
			System.out.println(sql);
			// 4.ִ�в�ѯ��䣬����sql��һ�����
			rs = st.executeQuery(sql);
			if (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				return stu;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, rs);
		}
		return null;
	}

	@Override
	public List<Student> getALL() {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			// 3.�������
			st = conn.createStatement();
			String sql = "select * from student";
			System.out.println(sql);
			// 4.ִ�в�ѯ��䣬����sql��һ�����
			rs = st.executeQuery(sql);

			// ����һ������
			List<Student> list = new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, st, rs);
		}
		return null;
	}

}
