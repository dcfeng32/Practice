package com.yh.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yh.sys.domain.Admin;
import com.yh.sys.utils.DBUtils;

public class AdminDao {

	public Admin longin(String username, String password) {
		// ��������
		Connection conn = null;
		// Ԥ�������
		PreparedStatement stmt = null;
		// �����
		ResultSet rs = null;
		// ����User����
		Admin admin = null;
		try {
			// ��ȡ����
			conn = DBUtils.getConnection();
			// ��д��¼��SQL���
			String sql = "select * from admin where username = ? and password = ?";
			// Ԥ����SQL���
			stmt = conn.prepareStatement(sql);
			// ����ֵ
			stmt.setString(1, username);
			stmt.setString(2, password);
			// ִ�в�ѯ
			rs = stmt.executeQuery();
			// �ӽ�����л�ȡ����ѯ�����ݣ���װ��User�����У����ء�
			if (rs.next()) {
				// ��װ����
				admin = new Admin();
				// ����ֵ
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			DBUtils.close(conn, stmt, rs);
		}
		return admin;
	}

}
