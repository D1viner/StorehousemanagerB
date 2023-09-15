package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.*;

public interface IUserDAO {
	public User login(String username,String password,String role) throws SQLException ;
	public int register(String username,String password,String role) throws SQLException ;
	
	public int deleteByUsername(String username)  throws SQLException;
	public int update(User ur)  throws SQLException;
	public User findByUsername(String username)  throws SQLException;
	public List<User> findAll()  throws SQLException;
}
