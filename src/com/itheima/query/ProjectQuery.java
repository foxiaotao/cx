package com.itheima.query;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class ProjectQuery extends BaseQuery {
	private String No;
	private String name;
	private String members;
	private String statue;//状态   0 立项  1 中期检查   2 结题
	private String type;//状态   0 立项  1 中期检查   2 结题
	private String year;//立项年份
	@Override
	protected void addWhere() {
		if(StringUtils.isNotBlank(No)){
			addWhere("o.No=?", No);
		}
		if(StringUtils.isNotBlank(name)){
			addWhere("o.name like ?", "%"+name+"%");
		}
		if(StringUtils.isNotBlank(members)){
			addWhere("o.members like ?", "%"+members+"%");
		}
		if(StringUtils.isNotBlank(statue)){
			addWhere("o.statue=?", statue);
		}
		if(StringUtils.isNotBlank(type)){
			addWhere("o.type=?", type);
		}
		if(StringUtils.isNotBlank(year)){
			addWhere("o.year=?", year);
		}
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
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
