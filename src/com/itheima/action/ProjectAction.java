package com.itheima.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Project;
import com.itheima.domain.ProjectStatue;
import com.itheima.query.PageResult;
import com.itheima.query.ProjectQuery;
import com.itheima.service.ProjectService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class ProjectAction extends BaseAction<Project> {
	@Resource
	private ProjectService projectService;
	
	ProjectQuery projectQuery = new ProjectQuery();
	private int pageSize = 15;
	
	//批量删除
	private Long[] ids;
	
	
	@PrivilegeAnnotation(name="项目浏览")
	public String showProjectByPage(){
		//项目状态
		List<ProjectStatue> statuelist = new ArrayList<ProjectStatue>();
		statuelist.add(new ProjectStatue(null, "请选择"));
		statuelist.add(new ProjectStatue("0", "立项"));
		statuelist.add(new ProjectStatue("1", "中期检查"));
		statuelist.add(new ProjectStatue("2", "结题"));
		ActionContext.getContext().put("statuelist", statuelist);
		
		
		projectQuery.setPageSize(pageSize);
		PageResult<Project> pageResult = this.projectService.getPageResult(projectQuery);
		pageResult.setUrl("porjectAction_showProjectByPage.action?projectQuery.");
		ActionContext.getContext().put("pageResult", pageResult);
		return "listAction";
	}
	@PrivilegeAnnotation(name="项目添加")
	public String addUI(){
		return "addUI";
	}
	@PrivilegeAnnotation(name="项目添加")
	public String add(){
		Project project = new Project();
		BeanUtils.copyProperties(this.getModel(), project);
		this.projectService.save(project);
		return "action2action";
	}
	@PrivilegeAnnotation(name="项目修改")
	public String updateUI(){
		Project project = this.projectService.getProjectByPid(this.getModel().getPid());
		ActionContext.getContext().getValueStack().push(project);
		return "updateUI";
	}
	@PrivilegeAnnotation(name="项目修改")
	public String update(){
		Project project = new Project();
		BeanUtils.copyProperties(this.getModel(), project);
		this.projectService.update(project);
		return "action2action";
	}
	@PrivilegeAnnotation(name="项目删除")
	public String delete(){
		deleteProject(this.getModel().getPid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="项目删除")
	public String deleteBatch(){
		
		for (Long pid : ids) {
			deleteProject(pid);
		}
		return "action2action";
	}
	
	private void deleteProject(Long pid) {
		this.projectService.delete(pid);
	}
	public ProjectQuery getProjectQuery() {
		return projectQuery;
	}


	public void setProjectQuery(ProjectQuery projectQuery) {
		this.projectQuery = projectQuery;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
}
