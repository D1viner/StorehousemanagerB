package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.pojo.*;
import com.dao.Impl.*;

public class StorehouseServiceImpl implements IStorehouseService{
	
	IStorehouseDAO dao= new StorehouseDAOImpl();
	
	@Override
	public boolean add(Storehouse st) 
	{
		int result=0;
		try {
			result = dao.insert(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

	@Override
	public boolean removeByNo(String no) {
		int result = 0;
		try {
			result = dao.deleteByNo(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result>0;
	}

	@Override
	public boolean modify(Storehouse st) {
		int result = 0;
		try {
			result = dao.update(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

	@Override
	public Storehouse queryByNo(String no) {
		Storehouse st = null;
		try {
			st = dao.findByNo(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public List<Storehouse> queryAll() {
		List<Storehouse> sts = null;
		try {
			sts = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sts;
	}
}
