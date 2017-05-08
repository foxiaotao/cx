package com.itheima.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Resource(name="roleService")
	private RoleService roleService;
	
	
	@PrivilegeAnnotation(name="角色管理")
	public String showAllRole(){
		List<Role> roles = this.roleService.getAllRole();
		ActionContext.getContext().put("roles", roles);
		return "listAction";
	}
	
	@PrivilegeAnnotation(name="角色添加")
	public String addUI(){
		return "addUI";
	}
	
	@PrivilegeAnnotation(name="角色添加")
	public String add(){
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveRole(role);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="角色修改")
	public String updateUI(){
		Role role = this.roleService.getRoleByRid(this.getModel().getRid());
		ActionContext.getContext().getValueStack().push(role);
		return "updateUI";
	}
	
	@PrivilegeAnnotation(name="角色修改")
	public String update(){
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.updateRole(role);
		return "action2action";
		
	}
	
	@PrivilegeAnnotation(name="角色删除")
	public String delete(){
		this.roleService.deleteRole(this.getModel().getRid());
		return "action2action";
	}
//	public String (){
//		
//		
//	}
//	public String (){
//		
//		
//	}
	
}
