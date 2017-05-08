package com.itheima.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.ProjectDao;
import com.itheima.domain.Project;
import com.itheima.query.PageResult;
import com.itheima.query.ProjectQuery;
import com.itheima.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectDao projectDao;
	
	
	public void save(Project project) {
		//通过项目成立时间，获取项目成立年份
		String year = new SimpleDateFormat("yyyy-MM-dd").format(project.getStart()).split("-")[0];
		project.setYear(year);
		this.projectDao.addEntity(project);
	}

	public void delete(Long pid) {
		this.projectDao.deleteEntity(pid);
	}

	public void update(Project project) {
		//year 可能丢失
		//通过项目成立时间，获取项目成立年份
		String year = new SimpleDateFormat("yyyy-MM-dd").format(project.getStart()).split("-")[0];
		project.setYear(year);
		this.projectDao.updateEntity(project);
	}

	public Project getProjectByPid(Long pid) {
		return this.projectDao.getEntityById(pid);
	}

	public PageResult<Project> getPageResult(ProjectQuery projectQuery) {
		return this.projectDao.findPageResult(Project.class, projectQuery);
	}

}
