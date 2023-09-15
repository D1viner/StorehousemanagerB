package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.*;
import com.utils.*;
import com.dao.*;

public class UserDAOImpl implements IUserDAO {

	@Override
	public User login(String username, String password, String role) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		System.out.print(username+password+role);
		String sql = "select * from user where username = ? and password = ? and role = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, role);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		User a = null;
		if (rs.next()) {
			a = new User(username,password,role);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return a;
	}

	@Override
	public int register(String username, String password, String role) throws SQLException {
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "insert into user values(?,?,?);";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, role);
		// 3. ִ�и������
		int result = stmt.executeUpdate();
		
		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public int deleteByUsername(String username) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "delete from user where username = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);

		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);
		return result;
	}

	@Override
	public int update(User ur) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "update user set password=?,role=? where username=?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, ur.getPassword());
		stmt.setString(2, ur.getRole());
		stmt.setString(3, ur.getUsername());



		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public User findByUsername(String username) throws SQLException {
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from user where username = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		User ur = null;
		if (rs.next()) {
			String password = rs.getString("password");
			String role = rs.getString("role");
			// ����ѧ������
			ur = new User(username, password, role);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return ur;
	}

	@Override
	public List<User> findAll() throws SQLException {
		// 1. ��ȡ����
				Connection conn = DbUtils.getConnection();

				// 2. ������ѯ����
				// Ԥ�����ѯ����
				String sql = "select * from user;";
				PreparedStatement stmt = conn.prepareStatement(sql);


				// 3. ִ�в�ѯ���
				ResultSet rs = stmt.executeQuery();

				// 4. �ӽ�����н�������
				List<User> urs = new ArrayList<>();
				while (rs.next()) 
				{
					String username = rs.getString("username");
					String password = rs.getString("password");
					String role = rs.getString("role");
					// ����ѧ������
					User ur = new User(username, password, role);
					urs.add(ur);
				}

				// 4. �ͷ���Դ
				DbUtils.destory(conn, stmt, null);

				return urs;
	}

}
