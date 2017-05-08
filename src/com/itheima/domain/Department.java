package com.itheima.domain;


import java.io.Serializable;
import java.util.Set;

public class Department implements Serializable {
	private Long did;
	private String name;
	private String description;
	private Set<User> users;
	private Set<Files> files;
//	private Set<Book> books;
//	private Set<Project> projects;
	
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Files> getFiles() {
		return files;
	}
	public void setFiles(Set<Files> files) {
		this.files = files;
	}
//	public Set<Book> getBooks() {
//		return books;
//	}
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//	}
//	public Set<Project> getProjects() {
//		return projects;
//	}
//	public void setProjects(Set<Project> projects) {
//		this.projects = projects;
//	}
	
}
