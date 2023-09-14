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


public class StorehouseDAOImpl implements IStorehouseDAO{
	@Override
	public int insert(Storehouse st) throws SQLException {

		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "insert into storehouse values(?,?,?,?,?,?);";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, st.getNo());
		stmt.setString(2, st.getName());
		stmt.setInt(3, st.getPrice());
		stmt.setString(4, st.getNum());
		stmt.setString(5, st.getStorehouseid());
		stmt.setString(6, st.getInventorydate());


		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public int deleteByNo(String no) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "delete from storehouse where no = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, no);

		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);
		return result;
	}

	@Override
	public int update(Storehouse st) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "update storehouse set name=?,price=?,num=?,storehouseid=?,inventorydate=? where no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, st.getName());
		stmt.setInt(2, st.getPrice());
		stmt.setString(3, st.getNum());
		stmt.setString(4, st.getStorehouseid());
		stmt.setString(5, st.getInventorydate());
		stmt.setString(6, st.getNo());


		// 3. ִ�и������
		int result = stmt.executeUpdate();

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return result;
	}

	@Override
	public Storehouse findByNo(String no) throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from storehouse where no = ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, no);

		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		Storehouse st = null;
		if (rs.next()) {
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String num = rs.getString("num");
			String storehouseid = rs.getString("storehouseid");
			String inventorydate = rs.getString("inventorydate");
			// ����ѧ������
			st = new Storehouse(no, name, price, num, storehouseid,inventorydate);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return st;
	}

	@Override
	public List<Storehouse> findAll() throws SQLException {
		// 1. ��ȡ����
		Connection conn = DbUtils.getConnection();

		// 2. ������ѯ����
		// Ԥ�����ѯ����
		String sql = "select * from storehouse;";
		PreparedStatement stmt = conn.prepareStatement(sql);


		// 3. ִ�в�ѯ���
		ResultSet rs = stmt.executeQuery();

		// 4. �ӽ�����н�������
		List<Storehouse> sts = new ArrayList<>();
		while (rs.next()) 
		{
			String no = rs.getString("no");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String num = rs.getString("num");
			String storehouseid = rs.getString("storehouseid");
			String inventorydate = rs.getString("inventorydate");
			// ����ѧ������
			Storehouse st = new Storehouse(no, name, price, num, storehouseid,inventorydate);
			sts.add(st);
		}

		// 4. �ͷ���Դ
		DbUtils.destory(conn, stmt, null);

		return sts;
	}
}
