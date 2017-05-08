package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	private Long bid;
	private String No;

	private String name;
	private Double price;
	private String statue;
	private Date start;
	private Date end;
	private User user;
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
}
