package com.yh.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.yh.jdbc.utils.JDBCUtil;

public class BatchTest {

	public static void main(String[] args) throws Exception {
		  
		//1.�������ݿ⣬��дsql��䣬Ԥ�������
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (name,age) values (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//����sql��ִ��ʱ��
		long begin = System.currentTimeMillis();
			//ѭ����������
			for(int i = 0; i <1000; i++) {
				ps.setString(1, "����");
				ps.setInt(2, 15);
				//���������
				ps.addBatch();
			}
			//ִ�����
			ps.executeBatch();
		long end = System.currentTimeMillis();
		
		long time = end - begin;
		System.out.println(time);
	}
}
