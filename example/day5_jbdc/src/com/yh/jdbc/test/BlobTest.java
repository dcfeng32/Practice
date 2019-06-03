package com.yh.jdbc.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.yh.jdbc.utils.JDBCUtil;

public class BlobTest {
	public static void main(String[] args) throws Exception {
		//�������ݿ⣬��дsql���
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (img) values (?)";
		//Ԥ������䣬��ֹsqlע�빥��
		PreparedStatement ps = conn.prepareStatement(sql);
		//��ȡ���̵��ļ���ת��Ϊ�������ʶ��Ķ���������������InPutStream��,�ѵ����е��ļ����������
		FileInputStream in = new FileInputStream("d:/fff.JPG");
		ps.setBlob(1, in);
		//ִ��sql���
		ps.executeUpdate();
		JDBCUtil.close(conn, ps, null);
	}
}
