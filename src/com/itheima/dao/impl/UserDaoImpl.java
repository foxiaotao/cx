package com.itheima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.dao.UserDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByNumber(String number) {
		// TODO Auto-generated method stub
		List<User> users = this.getHibernateTemplate().find("from User where number=?",number);
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}


}
