package com.itheima.service;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Role;

public interface RoleService {
	public void saveRole(Role role);
	public void deleteRole(Serializable id);
	public void updateRole(Role role);
	public List<Role> getAllRole();
	public Role getRoleByRid(Serializable id);
}
