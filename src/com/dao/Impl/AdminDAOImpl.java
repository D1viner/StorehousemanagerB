package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.*;
import com.utils.*;
import com.dao.*;

public class AdminDAOImpl implements IAdminDAO{

	@Override
	public Admin findByUsernameAndPassword(String username, String password) throws SQLException {
		// 1. 获取连接
		Connection conn = DbUtils.getConnection();

		// 2. 创建查询对象
		// 预编译查询对象
		String sql = "select * from admin where username = ? and password = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);
		stmt.setString(2, password);

		// 3. 执行查询语句
		ResultSet rs = stmt.executeQuery();

		// 4. 从结果集中解析数据
		Admin a = null;
		if (rs.next()) {
			int id = rs.getInt(1);
			// 放入学生对象
			a = new Admin(id,username,password);
		}

		// 4. 释放资源
		DbUtils.destory(conn, stmt, null);

		return a;
	}

}
