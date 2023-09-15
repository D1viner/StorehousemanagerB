package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.dao.Impl.*;
import com.pojo.*;

public class UserServiceImpl implements IUserService{
	
	IUserDAO dao = new UserDAOImpl();
	
	@Override
	public User login(String username, String password, String role) {

		User a = null;
		try {
			a = dao.login(username, password,role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public boolean register(User ur) {
		int result=0;
		try {
			result = dao.register(ur.getUsername(), ur.getPassword(), ur.getRole());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

	@Override
	public boolean removeByUsername(String username) {
		int result = 0;
		try {
			result = dao.deleteByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

	@Override
	public boolean modify(User ur) {
		int result = 0;
		try {
			result = dao.update(ur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

	@Override
	public User queryByUsername(String username) {
		User ur = null;
		try {
			ur = dao.findByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ur;
	}

	@Override
	public List<User> queryAll() {
		List<User> urs = null;
		try {
			urs = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urs;
	}

}
