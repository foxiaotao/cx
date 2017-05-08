package com.itheima.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.domain.Privilege;
import com.itheima.domain.User;
import com.itheima.service.LoginService;
import com.itheima.service.PrivilegeService;
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	public String login(){
		User u = new User();
		BeanUtils.copyProperties(this.getModel(), u);
		User user = this.loginService.login(u);

		if(user==null){
			this.addActionMessage("用户名密码错误");
			return "login";
		}
		else{
			//存放登陆用户的所有权限
			List<Privilege> privileges = this.privilegeService.getPrivilegeByUid(user.getUid());

			//因为hibernate延迟加载,在关闭之前加载数据
			user.getDepartment().getName();
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			session.setAttribute("user", user);
			session.setAttribute("privileges", privileges);
			//设置session的为30min
			session.setMaxInactiveInterval(3600000);
			
			//访问者的id
			String visiterAddr =  ServletActionContext.getRequest().getRemoteAddr();
			ServletActionContext.getRequest().getSession().setAttribute("visiterAddr", visiterAddr);
			return "index";
		}
	}
}
