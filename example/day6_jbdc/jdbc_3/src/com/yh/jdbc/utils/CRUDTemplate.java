package com.yh.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yh.jdbc.daomain.Student;

public class CRUDTemplate {
	
	/*
	 * �����ظ���̫�ߣ�Ҫ������Ż�
	 *  1.���һ������ 
	 *  2.Ҫ��������������һ��sql��䣬һ������ ��һ������sql���ģ��
	 * �ڶ�������Ϊ�ɱ����������������
	 *  3.����ֵ ����ֵΪint����������Ӱ�� params�ɱ������ʵ����һ������
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			// ��������
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//ִ�����
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
		return 0;
	}
	
	public static List<Student> executeQuery(String sql,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//����һ������
		List<Student> list = new ArrayList<Student>();
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			//��������
			for(int i = 0; i < params.length;i++) {
				ps.setObject(i+1, params[i]);
			}

			rs = ps.executeQuery();
			
			if (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return list;	
	}
	
}
