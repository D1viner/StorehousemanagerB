package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.pojo.Storehouse;

public interface IStorehouseDAO {
	public int insert(Storehouse st)  throws SQLException;
	public int deleteByNo(String no)  throws SQLException;
	public int update(Storehouse st)  throws SQLException;
	public Storehouse findByNo(String no)  throws SQLException;
	public List<Storehouse> findAll()  throws SQLException;
}
