package com.yh.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yh.jdbc.utils.JDBCUtil;

public class PenerateTest {
	//��ȡ�Զ����ɵ��Խ������ַ�����
	public static void main(String[] args) throws Exception {
		// 1.�������ݿ⣬��дsql���
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (name,age) values (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "���1");
		ps.setInt(2,14);
		//2.���������鵽�˾����
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, ps, rs);
	}
	
	//�ڶ��ֻ�ȡ�Զ����ɵ�id�ķ���
	void test() throws Exception {
		// 1.�������ݿ⣬��дsql���
		Connection conn = JDBCUtil.getConn();
		//�������ݵ�sql��䣬���ݿ���Զ�����Ψһ��id����Ϊ��ȷ�������ݵı�ʶ
		String sql = "insert into student (name,age) values ('���1',14)";
		Statement st = conn.createStatement();
		// ���ÿ��Ի�ȡ����
		st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		// ��ȡ�Զ����ɵ�id
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		JDBCUtil.close(conn, st, rs);

	}

}
