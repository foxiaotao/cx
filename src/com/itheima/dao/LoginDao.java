package com.itheima.dao;

import com.itheima.dao.base.BaseDao;
import com.itheima.domain.User;

public interface LoginDao extends BaseDao<User> {

	User getUserByLogin(User user);

}
