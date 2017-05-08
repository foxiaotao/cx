package com.itheima.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
import com.itheima.query.UserQuery;
import com.itheima.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	
	
	@Override
	public void saveUser(User user) {
		this.userDao.addEntity(user);
	}

	@Override
	public void deleteUser(Serializable uid) {
		this.userDao.deleteEntity(uid);
	}

	@Override
	public void updateUser(User user) {
		this.userDao.updateEntity(user);
	}

	@Override
	public User getUserByUid(Serializable uid) {
		return this.userDao.getEntityById(uid);
	}

	@Override
	public List<User> getAllUser() {
		return this.userDao.queryAllEntity();
	}

	@Override
	public PageResult<User> getPageResult(UserQuery userQuery) {

		return userDao.findPageResult(User.class, userQuery);
	}

	@Override
	public void deleteBatchUser(Serializable[] ids) {
		// TODO Auto-generated method stub
		List<User> users = this.userDao.getEntityByIds(ids);
		if(users.size()>0){
			for (User user : users) {
				this.userDao.deleteEntity(user.getUid());
			}
		}
	}

	@Override
	public User getUserByNumber(String number) {
		return this.userDao.getUserByNumber(number);
		
	}

}
