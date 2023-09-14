package com.service;

import java.sql.SQLException;

import com.dao.*;
import com.dao.Impl.*;
import com.pojo.*;

public class AdminServiceImpl implements IAdminServcie{
	
	IAdminDAO dao = new AdminDAOImpl();

	@Override
	public Admin login(String username, String password) {
		
		Admin a = null;
		try {
			a = dao.findByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

}
