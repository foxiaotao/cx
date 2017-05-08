package com.itheima.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoaderListener;

import com.itheima.dao.PrivilegeDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.Privilege;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	@Override
	public List<Privilege> getPrivilegeByLogin() {
		// TODO jintian
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user.getUsername().equals("admin")){
			return this.getHibernateTemplate().find("from Privilege where flag=1");
		}
		//登陆显示操作权限
		return this.getHibernateTemplate().find("from Privilege p inner join fetch p.roles r where flag=1 and r.rid=?",user.getRole().getRid());
		
	}

	@Override
	public List<Privilege> getPrivielgeByRole(Serializable rid) {
		return null;
	}

	@Override
	public List<Privilege> getPrivilegeByRid(Long rid) {
//		List<Privilege> rolePrivileges = this.getHibernateTemplate().find("select p from Privilege p where p.role.rid=?",rid);
		//查询出对应角色有的权限，在所有功能权限中标记，数据回显
		List<Privilege> rolePrivileges = this.getHibernateTemplate().find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);

		//所有权限
		List<Privilege> privileges = this.getHibernateTemplate().find("from Privilege");
		
		for (Privilege privilege : privileges) {
			for (Privilege roleP : rolePrivileges) {
				if(privilege.getId() == roleP.getId()){
					privilege.setChecked(true);
				}
			}
		}
		
		return privileges;
		
	}

	@Override
	public List<Privilege> getAllPrivilegeByUser(Long rid) {
		// 查询用户的所有权限放到session中
		return this.getHibernateTemplate().find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);
	}


}
