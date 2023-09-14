package com.service;

import java.sql.SQLException;
import java.util.List;

import com.pojo.*;

public interface ISthouseService {
	// ����ѧ��
	public boolean add(Sthouse st);
	
	// ɾ��ѧ��
	public boolean removeById(String id);
	
	// ����ѧ����Ϣ
	public boolean modify(Sthouse st);
	
	// ��ѯѧ��
	public Sthouse queryById(String id);
	
	// ��ѯ����
	public List<Sthouse> queryAll();
}
