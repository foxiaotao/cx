package com.itheima.intercptor;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.annotation.privilege.AnnotationParse;
import com.itheima.domain.Privilege;
import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyIntercptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//该用户所有的权限
				HttpSession httpSession = ServletActionContext.getRequest().getSession();
				User user = (User) httpSession.getAttribute("user");
				if(user!=null){
					List<Privilege> privileges = (List<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("privileges");
					//获取访问方法的权限
					Class actionClazz = invocation.getAction().getClass();
					String actionMethodName = invocation.getProxy().getMethod();//
					String privilegeName = AnnotationParse.parse(actionClazz, actionMethodName);
					Boolean flag = false;
					if(privileges!=null){
						for (Privilege privilege : privileges) {
							if(privilege.getName().equals(privilegeName)){
								flag = true;
								break;
							}
						}
						if(!flag){//一致
							ActionContext.getContext().getValueStack().push("没有权限，请向管理员申请获取权限");
							return "privilege_errer";
						}else{
							return invocation.invoke();
						}
					}
					else{
						ActionContext.getContext().getValueStack().push("没有权限，请向管理员申请获取权限");
						return "privilege_errer";
					}
				}
				else{
					ActionContext.getContext().getValueStack().push("登录过期，请重新登录");
					return "privilege_errer";
				}
	}

}
