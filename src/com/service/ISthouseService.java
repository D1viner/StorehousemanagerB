package com.service;

import java.sql.SQLException;
import java.util.List;

import com.pojo.*;

public interface ISthouseService {
	// 插入学生
	public boolean add(Sthouse st);
	
	// 删除学生
	public boolean removeById(String id);
	
	// 更新学生信息
	public boolean modify(Sthouse st);
	
	// 查询学生
	public Sthouse queryById(String id);
	
	// 查询所有
	public List<Sthouse> queryAll();
}
