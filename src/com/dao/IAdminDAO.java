package com.dao;

import java.sql.SQLException;

import com.pojo.Admin;

public interface IAdminDAO {

	public Admin findByUsernameAndPassword(String username,String password) throws SQLException ;
}
