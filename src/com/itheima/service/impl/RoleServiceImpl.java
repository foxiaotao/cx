package com.itheima.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public void saveRole(Role role) {
		roleDao.addEntity(role);

	}

	@Override
	public void deleteRole(Serializable id) {
		roleDao.deleteEntity(id);

	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateEntity(role);

	}

	@Override
	public List<Role> getAllRole() {
		return roleDao.queryAllEntity();
	}

	@Override
	public Role getRoleByRid(Serializable id) {
		return roleDao.getEntityById(id);
	}

}
