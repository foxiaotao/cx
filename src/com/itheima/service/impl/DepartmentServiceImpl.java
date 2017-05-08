package com.itheima.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.DepartmentDao;
import com.itheima.domain.Department;
import com.itheima.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public void saveDepartment(Department department) {
		departmentDao.addEntity(department);
	}

	@Override
	public void deleteDepartment(Serializable id) {
		departmentDao.deleteEntity(id);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateEntity(department);

	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.queryAllEntity();
	}

	@Override
	public Department getDepartmentByDid(Serializable id) {
		return departmentDao.getEntityById(id);
	}

}
