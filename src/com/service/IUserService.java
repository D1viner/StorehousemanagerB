package com.service;

import java.util.List;

import com.pojo.User;

public interface IUserService {
	public User login(String username,String password,String role);
	
	public boolean register(User ur);
	
	// ɾ��ѧ��
	public boolean removeByUsername(String username);
	
	// ����ѧ����Ϣ
	public boolean modify(User ur);
	
	// ��ѯѧ��
	public User queryByUsername(String username);
	
	// ��ѯ����
	public List<User> queryAll();
}
