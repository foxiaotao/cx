package com.itheima.query;

import org.apache.commons.lang3.StringUtils;

public class AchievementQuery extends BaseQuery{
	private String name;
	private String members;
	private String type;  // 0 专利  1论文  2 竞赛 3 软件
	private String year;
	
	
	protected void addWhere() {
		if(StringUtils.isNotBlank(name)){
			addWhere("o.name like ?", "%"+name+"%");
		}
		if(StringUtils.isNotBlank(members)){
			addWhere("o.members like ?", "%"+members+"%");
		}
		if(StringUtils.isNotBlank(type)){
			addWhere("o.type=?", type);
		}
		if(StringUtils.isNotBlank(year)){
			addWhere("o.year=?", year);
		}
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

}
