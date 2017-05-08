package com.itheima.dao;

import java.io.Serializable;
import java.util.List;

import com.itheima.dao.base.BaseDao;
import com.itheima.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {
	public List<Privilege> getPrivilegeByLogin();
	public List<Privilege> getPrivielgeByRole(Serializable rid);
	public List<Privilege> getPrivilegeByRid(Long rid);
	public List<Privilege> getAllPrivilegeByUser(Long rid);
	
}
