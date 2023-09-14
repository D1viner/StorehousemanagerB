package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojo.*;
import com.utils.*;
import com.dao.*;

public class SthouseDAOImpl implements ISthouseDAO {

	@Override
	public int insert(com.pojo.Sthouse st) throws SQLException {
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "insert into sthouse values(?,?,?);";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, st.getStorehouseid());
		stmt.setString(2, st.getStorehousename());
		stmt.setString(3, st.getStorehouseaddress());
		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public int deleteById(String id) throws SQLException {
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "delete from sthouse where storehouseid = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, id);

		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);
		return result;
	}

	@Override
	public int update(com.pojo.Sthouse st) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "update sthouse set storehousename=?,storehouseaddress=? where storehouseid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, st.getStorehousename());
		stmt.setString(2, st.getStorehouseaddress());
		stmt.setString(3, st.getStorehouseid());
		// 3. ִ�и������
		int result = stmt.executeUpdate();
		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public com.pojo.Sthouse findById(String id) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from sthouse where storehouseid = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, id);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		Sthouse st = null;
		if (rs.next()) {
			String storehouseid = rs.getString("storehouseid");
			String storehousename = rs.getString("storehousename");
			String storehouseaddress = rs.getString("storehouseaddress");
			// ����ѧ������
			st = new Sthouse(storehouseid, storehousename, storehouseaddress);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return st;
	}

	@Override
	public List<com.pojo.Sthouse> findAll() throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from sthouse;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		List<Sthouse> sts = new ArrayList<>();
		while (rs.next()) {
			String storehouseid = rs.getString("storehouseid");
			String storehousename = rs.getString("storehousename");
			String storehouseaddress = rs.getString("storehouseaddress");
			// ����ѧ������
			Sthouse st = new Sthouse(storehouseid, storehousename, storehouseaddress);
			sts.add(st);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return sts;
	}
}
