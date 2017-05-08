package com.itheima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.dao.RoleDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.Role;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {


}
