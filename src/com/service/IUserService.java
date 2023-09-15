package com.service;

import java.util.List;

import com.pojo.User;

public interface IUserService {
	public User login(String username,String password,String role);
	
	public boolean register(User ur);
	
	// 删除学生
	public boolean removeByUsername(String username);
	
	// 更新学生信息
	public boolean modify(User ur);
	
	// 查询学生
	public User queryByUsername(String username);
	
	// 查询所有
	public List<User> queryAll();
}
