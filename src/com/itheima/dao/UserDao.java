package com.itheima.dao;

import com.itheima.dao.base.BaseDao;
import com.itheima.domain.User;

public interface UserDao extends BaseDao<User> {

	User getUserByNumber(String number);

}
