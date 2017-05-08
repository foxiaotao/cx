package com.itheima.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.LoginDao;
import com.itheima.domain.User;
import com.itheima.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name="loginDao")
	private LoginDao loginDao;
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return this.loginDao.getUserByLogin(user);
	}

}
