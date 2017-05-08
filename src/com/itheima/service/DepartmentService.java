package com.itheima.service;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Department;

public interface DepartmentService {
	public void saveDepartment(Department department);
	public void deleteDepartment(Serializable id);
	public void updateDepartment(Department department);
	public List<Department> getAllDepartment();
	public Department getDepartmentByDid(Serializable id);
}
