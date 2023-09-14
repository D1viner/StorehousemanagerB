package com.service;

import java.sql.SQLException;
import java.util.List;

import com.pojo.*;

public interface IStorehouseService {
	// ����ѧ��
	public boolean add(Storehouse st);
	
	// ɾ��ѧ��
	public boolean removeByNo(String no);
	
	// ����ѧ����Ϣ
	public boolean modify(Storehouse st);
	
	// ��ѯѧ��
	public Storehouse queryByNo(String no);
	
	// ��ѯ����
	public List<Storehouse> queryAll();
}
