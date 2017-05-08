package com.itheima.service;

import com.itheima.domain.Project;
import com.itheima.query.PageResult;
import com.itheima.query.ProjectQuery;

public interface ProjectService {
	public void save(Project project);
	public void delete(Long pid);
	public void update(Project project);
	public Project getProjectByPid(Long pid);
	public PageResult<Project> getPageResult(ProjectQuery projectQuery);
}
