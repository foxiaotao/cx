package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class Files implements Serializable {
	private Long fid;
	private String name;
	private String url;
	private String approve;//false 为临时上传状态，true为通过审批
	private String description;
	private String type;//0为个人私有资料，别人不能查看，1为公共共享资料
	private Date uploadtime;//上传时间
	private Long length;//文件大小
	private String md5;//任意两个文件是否是同一个文件
	
	private User user;//所属用户
	private Department department;//所属部门，仅用来分类，与部门没有其他逻辑关系
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
