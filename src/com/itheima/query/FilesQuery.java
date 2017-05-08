package com.itheima.query;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.itheima.domain.Department;
import com.itheima.domain.User;

public class FilesQuery extends BaseQuery {

	private String name;
	private String approve;// 0 为临时上传状态，1为通过审批
	private String desctiption;
	private String type;// 0为个人私有资料，别人不能查看，1为公共共享资料
	private Date uploadtime;// 上传时间
	private Long length;// 文件大小

	private User user = new User();// 所属用户
	private Department department = new Department();// 所属部门，仅用来分类，与部门没有其他逻辑关系
	@Override
	protected void addWhere() {
		if(StringUtils.isNotBlank(name)){
			addWhere("o.name like ?","%"+name+"%");
		}
		if(StringUtils.isNotBlank(approve)){
			addWhere("o.approve=?",approve);
		}
		if(StringUtils.isNotBlank(desctiption)){
			addWhere("o.desctiption=?",desctiption);
		}
		if(StringUtils.isNotBlank(type)){
			addWhere("o.type=?",type);
		}
		if(uploadtime!=null){
			addWhere("o.uploadtime<=?",uploadtime);
		}
		if(length!=null){
			addWhere("o.length=?",length);
		}
		if(user.getUid()!=null){
			addWhere("o.user.uid=?",user.getUid());
		}
		if(StringUtils.isNotBlank(user.getNumber())){
			addWhere("o.user.number=?",user.getNumber());
		}
		if(department.getDid()!=null){
			addWhere("o.department.did=?",department.getDid());
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

}
