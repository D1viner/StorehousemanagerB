package com.service;

import java.sql.SQLException;
import java.util.List;

import com.pojo.*;

public interface IStorehouseService {
	// 插入学生
	public boolean add(Storehouse st);
	
	// 删除学生
	public boolean removeByNo(String no);
	
	// 更新学生信息
	public boolean modify(Storehouse st);
	
	// 查询学生
	public Storehouse queryByNo(String no);
	
	// 查询所有
	public List<Storehouse> queryAll();
}
