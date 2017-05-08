package com.itheima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.dao.LoginDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<User> implements LoginDao {

	@Override
	public User getUserByLogin(User user) {
		List<User> users =  this.getHibernateTemplate().find("from User where number=? and password=?",user.getNumber(),user.getPassword());
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}
}
