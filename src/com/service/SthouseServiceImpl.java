package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.pojo.*;
import com.dao.Impl.*;

public class SthouseServiceImpl implements ISthouseService{
	
	ISthouseDAO dao = new SthouseDAOImpl();

	@Override
	public boolean add(Sthouse st) {
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

	}

	@Override
	public boolean removeById(String id) {
		int result = 0;
		try {
			result = dao.deleteById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result>0;
	}

	@Override
	public boolean modify(Sthouse st) {
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
	public Sthouse queryById(String id) {
		Sthouse st = null;
		try {
			st = dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public List<Sthouse> queryAll() {
		List<Sthouse> sts = null;
		try {
			sts = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sts;
	}

}
