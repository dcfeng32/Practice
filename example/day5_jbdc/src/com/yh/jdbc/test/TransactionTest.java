package com.yh.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yh.jdbc.utils.JDBCUtil;

public class TransactionTest {
	public static void main(String[] args) throws Exception {
		
//		 ���zs�˻������
//		 ����zs���˻�1000
//		 ����ls�˻�1000
	
		//1.�������ݿ�
		Connection conn = JDBCUtil.getConn();
		//�������
		String sql = "select * from accout where name = ? and money > ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "zs");
		ps.setInt(2, 1000);
		//ִ�����
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			throw new RuntimeException("ûǮ��Ү");
		}
		//2.����zs�˻�
		sql = "update accout set money = money - ? where name = ? ";
		ps = conn.prepareStatement(sql);
		ps.setDouble(1,1000);
		ps.setString(2,"zs");
		ps.executeUpdate();
		//3.����ls�˻�
		sql = "update accout set money = money + ?where name = ?";
		ps = conn.prepareStatement(sql);
		ps.setDouble(1,1000);
		ps.setString(2,"ls");
		ps.executeUpdate();
		//4.�ͷ���Դ
		JDBCUtil.close(conn, ps, rs);
		
	}
	
	

}
