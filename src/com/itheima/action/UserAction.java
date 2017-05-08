package com.itheima.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Department;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.query.PageResult;
import com.itheima.query.UserQuery;
import com.itheima.service.DepartmentService;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	
	UserQuery userQuery = new UserQuery();
	private int pageSize = 15;//接受来页面  自主设置的页面数
	
	private Long[] ids;
	
	@PrivilegeAnnotation(name="查看成员")
	public String showUserByCondition(){
		//显示用户基本信息
		userQuery.setPageSize(pageSize);//创建pageResult时，pageSize是从baseQuery中调用的get方法
		PageResult<User> pageResult = userService.getPageResult(userQuery);
		pageResult.setUrl("userAction_showUserByCondition.action?userQuery.");
		
		//从session中获取登录用户
		User loginUser = getUserFromSession();
		//如果不是超级管理员登录
		List<User> showUser = new ArrayList<User>();
		if(!"超级管理员".equals(loginUser.getRole().getName())){
			//如果不是超级管理员  不能看到超级管理员的密码
			for (User user : pageResult.getRows()) {
				if("超级管理员".equals(user.getRole().getName())){
					user.setPassword("");
				}
				showUser.add(user);
			}
			pageResult.setRows(showUser);
		}
		
		ActionContext.getContext().put("pageResult", pageResult);
		//显示所有部门信息
		List<Department> departments = departmentService.getAllDepartment();
		Department d = new Department();
		d.setName("请选择");
		d.setDid(null);
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		
		//显示角色
		List<Role> roles = roleService.getAllRole();
		
		Role r = new Role();
		r.setRid(null);
		r.setName("请选择");
		roles.add(0, r);
		ActionContext.getContext().put("roles", roles);
		return "listAction";
	}
	
	@PrivilegeAnnotation(name="成员添加")
	public String addUI(){
		//把全部的角色和部门查出来放到map中
		List<Department> departments = this.departmentService.getAllDepartment();
		List<Role> roles = this.roleService.getAllRole();
		
		//判断登录用户的权限能不能添加超级管理员
		User user = getUserFromSession();
		List<Role> roles2 = new ArrayList<Role>();
		//不将超级管理员放到集合中
		if("超级管理员".equals(user.getRole().getName())){
			ActionContext.getContext().put("roles", roles);
		}
		else{
			for (Role role : roles) {
				if("成员".equals(role.getName())){
					roles2.add(role);
				}
			}
			ActionContext.getContext().put("roles", roles2);
		}
		ActionContext.getContext().put("departments", departments);
		
		return "addUI";
	}
	
	@PrivilegeAnnotation(name="成员添加")
	public String add(){
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		//模型中只有did
		//判断所填信息是否为空
		if(StringUtils.isBlank(user.getNumber())){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "privilege_errer";
		}
		if(user.getDepartment().getDid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "privilege_errer";
		}
		if(user.getRole().getRid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "privilege_errer";
		}
		//保存
		Date nowDate = new Date();
		user.setJoindate(nowDate);
		this.userService.saveUser(user);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="修改成员")
	public String updateUI(){
		User user = this.userService.getUserByUid(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		
		//显示所有部门信息
		List<Department> departments = departmentService.getAllDepartment();
		ActionContext.getContext().put("departments", departments);
		
		//显示角色
		List<Role> roles = roleService.getAllRole();
		
		//判断登录用户的权限能不能添加超级管理员
		User u = getUserFromSession();
		List<Role> roles2 = new ArrayList<Role>();
		//不将超级管理员放到集合中
		if("超级管理员".equals(u.getRole().getName())){
			ActionContext.getContext().put("roles", roles);
		}
		else{
			for (Role role : roles) {
				if("成员".equals(role.getName())){
					roles2.add(role);
				}
			}
			ActionContext.getContext().put("roles", roles2);
		}
		return "updateUI";
	}
	
	@PrivilegeAnnotation(name="修改成员")
	public String update(){
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		
		if(StringUtils.isBlank(user.getNumber())){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		if(user.getDepartment().getDid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		if(user.getRole().getRid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		
		this.userService.updateUser(user);
		return "action2action";
	}
	//删除一个
	
	@PrivilegeAnnotation(name="成员删除")
	public String delete(){
		User user = this.userService.getUserByUid(this.getModel().getUid());
		//从session中获取登录用户
		User loginUser = getUserFromSession();
		//如果不是超级管理员登录
		if(!"超级管理员".equals(loginUser.getRole().getName())){
			//user 是需要被删除的 user
			if("超级管理员".equals(user.getRole().getName())){
				ActionContext.getContext().getValueStack().push("你不能删除超级管理员");
				return "privilege_errer";
			}
		}
		this.userService.deleteUser(user.getUid());
		return "action2action";
	}
	//删除多个
	
	@PrivilegeAnnotation(name="成员删除")
	public String deleteBatch(){
		
		//从session中获取登录用户
		User loginUser = getUserFromSession();
		//如果不是超级管理员登录
		if(!"超级管理员".equals(loginUser.getRole().getName())){
			//user ids 是需要被删除的 user ids
			for (Long uid : ids) {
				User user = this.userService.getUserByUid(uid);
				if("超级管理员".equals(user.getRole().getName())){
					ActionContext.getContext().getValueStack().push("你不能删除超级管理员");
					return "privilege_errer";
				}
			}
		}
		this.userService.deleteBatchUser(ids);
		return "action2action";
	}
	@PrivilegeAnnotation(name="修改密码")
	public String updatePasswordUI(){
		//从session中获取对象，获取他的主键
		User u = getUserFromSession();
		//从数据库在查一次
		User user = this.userService.getUserByUid(u.getUid());
		ActionContext.getContext().getValueStack().push(user);
		return "passwordUI";
	}
	@PrivilegeAnnotation(name="修改密码")
	public String updatePassword(){
		User user = this.userService.getUserByUid(this.getModel().getUid());
		user.setPassword(this.getModel().getPassword());
		this.userService.updateUser(user);
		return "action2personalInformation";
	}
	@PrivilegeAnnotation(name="个人信息")
	public String personalInformation(){
		//从session中获取对象，获取他的主键
		User u = getUserFromSession();
		//从数据库在查一次
		User user = this.userService.getUserByUid(u.getUid());
		ActionContext.getContext().getValueStack().push(user);
		return "personalInformation";
	}
	@PrivilegeAnnotation(name="个人信息修改")
	public String updateInfoUI(){
		//从session中获取对象，获取他的主键
		User u = getUserFromSession();
		//从数据库在查一次
		User user = this.userService.getUserByUid(u.getUid());
		ActionContext.getContext().getValueStack().push(user);
		return "updateInformation";
	}
	@PrivilegeAnnotation(name="个人信息修改")
	public String updateInfo(){
		User user = this.userService.getUserByUid(this.getModel().getUid());
		
		User u = new User();
		BeanUtils.copyProperties(this.getModel(), u);
		user.setPhone(u.getPhone());
		user.setEmail(u.getEmail());
		user.setSex(u.getSex());
		user.setAddress(u.getAddress());
		user.setAge(u.getAge());
		user.setYear(u.getYear());
		
		
		this.userService.updateUser(user);
		
		return "action2personalInformation";
	}
	
	
	
	//------------------------------------------------
	private User getUserFromSession(){
		
		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	
	public UserQuery getUserQuery() {
		return userQuery;
	}
	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}


	
}
