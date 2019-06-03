package com.yh.jdbc.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {

	public static DataSource ds = null;

	static {
		try {
			// ��ȡ�����ļ�
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("resource/db.properties");
			p.load(in);
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	// ����һ����������ȡ����Դ����dbutils����ds
	public static DataSource getDS() {
		return ds;
	}

	public static Connection getConn() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		// 5.�ͷ���Դ
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
