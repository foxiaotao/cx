package com.itheima.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Privilege;
import com.itheima.service.PrivilegeService;
import com.opensymphony.xwork2.ActionContext;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege> {
	@Resource
	private PrivilegeService privilegeService;
	
	private Long rid;
	private String strIds;
	//登陆显示权限
	public String showPrivilegeByUserLogin(){
		List<Privilege> privileges = this.privilegeService.getPrivilegeByUserLogin();
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	//加载功能树
	@PrivilegeAnnotation(name="角色权限设置")
	public String loadFunPrivilegeTree() throws InterruptedException{
		Thread.sleep(500);
		List<Privilege> privileges =  privilegeService.getByRid(rid);
		//准备数据
		ActionContext.getContext().getValueStack().push(privileges);
		
		return SUCCESS;
	}
	public String biuldRoleAndPrivilege(){
		privilegeService.saveRoleAndPrivilege(rid,strIds);
		
		return SUCCESS;
	}
	
	
	
	
	
	
	//------------set get
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getStrIds() {
		return strIds;
	}
	public void setStrIds(String strIds) {
		this.strIds = strIds;
	}
	
	
}
