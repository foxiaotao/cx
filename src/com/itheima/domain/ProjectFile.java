package com.itheima.domain;

import java.io.Serializable;

public class ProjectFile implements Serializable {
	private Long pfid;
	private String name;
	private String url;
	public Long getPfid() {
		return pfid;
	}
	public void setPfid(Long pfid) {
		this.pfid = pfid;
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
	
}
