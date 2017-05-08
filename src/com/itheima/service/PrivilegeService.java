package com.itheima.service;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Privilege;


public interface PrivilegeService {
	public void savePrivilege(Privilege privilege);
	public void deletePrivilege(Serializable id);
	public void updatePrivilege(Privilege privilege);
	public List<Privilege> getAllPrivilege();
	public Privilege getPrivilegeById(Serializable id);
	public List<Privilege> getPrivilegeByUid(Long uid);
	public List<Privilege> getPrivilegeByUserLogin();
	public List<Privilege> getByRid(Long rid);
	public void saveRoleAndPrivilege(Long rid, String strIds);
}
