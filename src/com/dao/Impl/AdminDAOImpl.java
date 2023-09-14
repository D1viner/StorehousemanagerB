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
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from admin where username = ? and password = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);
		stmt.setString(2, password);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		Admin a = null;
		if (rs.next()) {
			int id = rs.getInt(1);
			// ����ѧ������
			a = new Admin(id,username,password);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return a;
	}

}
