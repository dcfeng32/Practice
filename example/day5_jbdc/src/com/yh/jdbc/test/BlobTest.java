package com.yh.jdbc.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.yh.jdbc.utils.JDBCUtil;

public class BlobTest {
	public static void main(String[] args) throws Exception {
		//连接数据库，编写sql语句
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (img) values (?)";
		//预编译语句，防止sql注入攻击
		PreparedStatement ps = conn.prepareStatement(sql);
		//读取磁盘的文件，转化为计算机能识别的二进流（输入流是InPutStream）,把电脑中的文件放入程序中
		FileInputStream in = new FileInputStream("d:/fff.JPG");
		ps.setBlob(1, in);
		//执行sql语句
		ps.executeUpdate();
		JDBCUtil.close(conn, ps, null);
	}
}
