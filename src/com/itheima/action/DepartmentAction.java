package com.itheima.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Department;
import com.itheima.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@PrivilegeAnnotation(name="部门管理")
	public String showAllDepartment(){
		List<Department> departments = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departments", departments);
		return "listAction";
	}
	
	@PrivilegeAnnotation(name="部门添加")
	public String addUI(){
		return "addUI";
	}
	
	@PrivilegeAnnotation(name="部门添加")
	public String add(){
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveDepartment(department);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="部门修改")
	public String updateUI(){
		//传did参数过来
		Department department = this.departmentService.getDepartmentByDid(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return "updateUI";
	}
	
	@PrivilegeAnnotation(name="部门修改")
	public String update(){
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateDepartment(department);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="部门删除")
	public String delete(){
		//传did参数过来
		Department department = this.departmentService.getDepartmentByDid(this.getModel().getDid());
		this.departmentService.deleteDepartment(department.getDid());
		return "action2action";
	}
}
