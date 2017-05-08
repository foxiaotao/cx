package com.itheima.query;


import org.apache.commons.lang.StringUtils;

import com.itheima.domain.User;

public class BookQuery extends BaseQuery {

	private User user = new User();
	private String name;
	private String statue;
	private String No;

	@Override
	protected void addWhere() {
		// TODO Auto-generated method stub
		if (StringUtils.isNotEmpty(user.getNumber())) {
			addWhere("o.user.number=?", user.getNumber());
		}
		if(StringUtils.isNotEmpty(statue)){
			addWhere("o.statue=?", statue);
		}
		if(StringUtils.isNotEmpty(No)){
			addWhere("o.No=?", No);
		}
		if(StringUtils.isNotEmpty(name)){
			addWhere("o.name like ?", "%"+name+"%");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
