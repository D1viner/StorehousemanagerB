package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ���ݿ�Ĺ�����
public class DbUtils {

	// ��̬����� (�����һ�μ���ʱִ�� ��ִֻ��һ��)
	static {
		// 1. ��������
		try {
			// ͨ�����ȫ�޶�������ȡ�����
			Class c = Class.forName("com.mysql.jdbc.Driver");// 5.x����
//			Class c = Class.forName("com.mysql.cj.jdbc.Driver");// 8.x����
//			System.out.println("1. ������������:" + c);
		} catch (ClassNotFoundException e) {
			System.out.println("�Ҳ���mysql����");
		}
	}

	// �������ݿ�
	public static Connection getConnection() {
		// 2. �������ݿ�
		// jdbc java�������ݿ��һ���������һ����׼������ӿ�
		// ���̵������о���ʵ����Щ�ӿ�
		// ���������ͬ�������ݿ⣬ֻ��Ҫ�����������ɣ���������Ҫ�޸Ĵ��롣
		// �����������?useUnicode=true&characterEncoding=UTF-8
		String url = "jdbc:mysql://localhost:3306/storehouse?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("2. ���ӳɹ�!" + conn);
		} catch (SQLException e) {
			System.out.println("����ʧ��" + e.getMessage());
		}
		return conn;
	}

	// �ͷ���Դ
	public static void destory(Connection conn, Statement stmt, ResultSet rs) {
		// 5. �ͷ���Դ
		if (rs != null) {
			try {
				// �رս����
				rs.close();
//				System.out.println("�رս����ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				// �رղ�ѯ����
				stmt.close();
//				System.out.println("�رղ�ѯ����ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				// �ر�����
				conn.close();
//				System.out.println("�ر�����ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
