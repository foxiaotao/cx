package com.itheima.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.PrivilegeDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Privilege;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.PrivilegeService;
@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
	@Resource
	private PrivilegeDao privilegeDao; 
	@Resource
	private RoleDao roleDao;
	@Resource
	private UserDao userDao;
	
	@Override
	public void savePrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePrivilege(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrivilege(Privilege privilege) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Privilege> getAllPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Privilege getPrivilegeById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Privilege> getPrivilegeByUid(Long uid) {
		// TODO Auto-generated method stub
		User user = userDao.getEntityById(uid);
		return privilegeDao.getAllPrivilegeByUser(user.getRole().getRid());
	}

	@Override
	public List<Privilege> getPrivilegeByUserLogin() {
		// TODO Auto-generated method stub
		return this.privilegeDao.getPrivilegeByLogin();
	}

	@Override
	public List<Privilege> getByRid(Long rid) {
		// TODO Auto-generated method stub
		return privilegeDao.getPrivilegeByRid(rid);
	}

	@Override
	public void saveRoleAndPrivilege(Long rid, String strIds) {
		// TODO Auto-generated method stub
		//根据role的rid和privilege的strIds，建立关系。
		List<Privilege> rolePrivileges = privilegeDao.getEntityByIds(strIds.split(","));
		Role role = roleDao.getEntityById(rid);
		
		
		role.setPrivileges(new HashSet<Privilege>(rolePrivileges));
		roleDao.addEntity(role);
	}

}
