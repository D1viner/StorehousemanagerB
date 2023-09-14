package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.pojo.*;

public interface ISthouseDAO {
	public int insert(Sthouse st)  throws SQLException;
	public int deleteById(String id)  throws SQLException;
	public int update(Sthouse st)  throws SQLException;
	public Sthouse findById(String id)  throws SQLException;
	public List<Sthouse> findAll()  throws SQLException;
}
