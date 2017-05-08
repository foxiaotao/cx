package com.itheima.query;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.itheima.domain.Department;
import com.itheima.domain.Role;

public class UserQuery extends BaseQuery {

	private Long uid;
	private String username;
	private String number;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private String address;// 家庭住址
	private Long age;// 成员年龄
	private Date joindate;// 加入组织时间
	private Long year;// 入学年份
	//页面传过来的是did  user表中  did=1
	private Department department = new Department();
	private Role role = new Role();
	
	@Override
	protected void addWhere() {
		if(uid!=null){
			addWhere("o.uid=?", uid);
		}
		if(StringUtils.isNotBlank(username)){
			addWhere("o.username like ?", "%"+username+"%");
		}
		if(StringUtils.isNotBlank(number)){
			addWhere("o.number like ?", number+"%");
		}
		if(StringUtils.isNotBlank(password)){
			addWhere("o.password=?", password);
		}
		if(StringUtils.isNotBlank(phone)){
			addWhere("o.phone like ?", phone+"%");
		}
		if(StringUtils.isNotBlank(email)){
			addWhere("o.email like ?", email);
		}
		if(StringUtils.isNotBlank(sex)){
			addWhere("o.sex=?", sex);
		}
		if(StringUtils.isNotBlank(address)){
			addWhere("o.address like ?", "%"+address+"%");
		}
		if(department.getDid()!=null){
			//hql select o from User o inner join fetch o.deparment d where o.name like ? and o.password=? and d.did=? 
			// select o from User o where o.name like ? and o.password=?,params
			// select o from User o inner join fetch o.department d where d.did = did o.name like ? and o.password=?,params
			addWhere("o.department.did=?",department.getDid());
		}
		if(role.getRid()!=null){
			addWhere("o.role.rid=?",role.getRid());
		}
		if(year!=null){
			addWhere("o.year=?", year);
		}
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
