package com.yh.jdbc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import org.junit.Test;


public class LoginTest {
	@Test//���Խ��
	public void test() throws Exception {
		System.out.println(this.login("����", "123"));
	}
	
	String login(String userName, String pwd) throws Exception {
		// 1.�������ݿ�
		Connection conn = JDBCUtil.getConn();
		// 2.��ѯ�û��������룬ͬʱ��ͬʱ��ȷ
		String sql = "select * from user where name = ? and pwd = ?";
		// 3.ִ��sql���
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, userName);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) { 
			//�ر���Դ
			JDBCUtil.close(conn, ps, rs);
			return "��¼�ɹ���";
		} else {
			JDBCUtil.close(conn, ps, rs);
			return "��¼ʧ�ܣ�";
		}
	}
}
