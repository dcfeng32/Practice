package com.yh.jdbc.test;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		//��ȡ�����ļ�
		Properties p = new Properties();
		FileInputStream in = new FileInputStream("resource/db.properties");
		p.load(in);
	
		//�ڼ���������ж�ȡ�ļ������
		System.out.println(p.getProperty("url")+"+++"+p.getProperty("user"));
		

	}

}
