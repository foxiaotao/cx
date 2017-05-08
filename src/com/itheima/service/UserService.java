package com.itheima.service;

import java.io.Serializable;
import java.util.List;


import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
import com.itheima.query.UserQuery;

public interface UserService {
	public List<User> getAllUser();
	public void saveUser(User user);
	public void deleteUser(Serializable uid);
	public void updateUser(User user);
	public User getUserByUid(Serializable uid);
	public PageResult<User> getPageResult(UserQuery userQuery);
	public void deleteBatchUser(Serializable[] ids);
	public User getUserByNumber(String number);
}
