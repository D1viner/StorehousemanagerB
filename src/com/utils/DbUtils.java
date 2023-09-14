package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 数据库的工具类
public class DbUtils {

	// 静态代码块 (在类第一次加载时执行 并只执行一次)
	static {
		// 1. 加载驱动
		try {
			// 通过类的全限定类名获取类对象
			Class c = Class.forName("com.mysql.jdbc.Driver");// 5.x驱动
//			Class c = Class.forName("com.mysql.cj.jdbc.Driver");// 8.x驱动
//			System.out.println("1. 驱动加载正常:" + c);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到mysql驱动");
		}
	}

	// 连接数据库
	public static Connection getConnection() {
		// 2. 连接数据库
		// jdbc java连接数据库的一个组件，是一个标准。定义接口
		// 厂商的驱动中具体实现这些接口
		// 如果更换不同类型数据库，只需要更换驱动即可，基本不需要修改代码。
		// 如果出现乱码?useUnicode=true&characterEncoding=UTF-8
		String url = "jdbc:mysql://localhost:3306/storehouse?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("2. 连接成功!" + conn);
		} catch (SQLException e) {
			System.out.println("连接失败" + e.getMessage());
		}
		return conn;
	}

	// 释放资源
	public static void destory(Connection conn, Statement stmt, ResultSet rs) {
		// 5. 释放资源
		if (rs != null) {
			try {
				// 关闭结果集
				rs.close();
//				System.out.println("关闭结果集ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				// 关闭查询对象
				stmt.close();
//				System.out.println("关闭查询对象ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				// 关闭连接
				conn.close();
//				System.out.println("关闭连接ok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
