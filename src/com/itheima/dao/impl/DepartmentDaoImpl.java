package com.itheima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.dao.DepartmentDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.Department;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

	
}
