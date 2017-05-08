package com.itheima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.ProjectFile;
import com.itheima.service.ProjectFileService;
import com.opensymphony.xwork2.ActionContext;


@Controller("projectFileAction")
@Scope("prototype")
public class ProjectFileAction extends BaseAction<ProjectFile> {
	@Resource(name="projectFileService")
	private ProjectFileService projectFileService;
	
	//上传
	private File resource;
	private String resourceFileName;
	//下载
	private InputStream inputStream;
	
	@PrivilegeAnnotation(name="项目文件")
	public String showAllProjectFile(){
		List<ProjectFile> projectFiles = this.projectFileService.getAllProjectFile();
		ActionContext.getContext().put("projectFiles", projectFiles);
		return "listAction";
	}
	@PrivilegeAnnotation(name="项目文件上传")
	public String addUI(){
		return "addUI";
	}
	@PrivilegeAnnotation(name="项目文件上传")
	public String add(){
		this.projectFileService.saveProjectFile(resource, resourceFileName);
		return "action2action";
	}
	
	
	@PrivilegeAnnotation(name="项目文件删除")
	public String delete(){
		this.projectFileService.delete(this.getModel().getPfid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="项目文件下载")
	public String download(){
		ProjectFile projectFile = this.projectFileService.getProjectFile(this.getModel().getPfid());
		String path = projectFile.getUrl();
		try {
			inputStream = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			ActionContext.getContext().getValueStack().push("文件已删除或不存在！");
			return "errer";
		}
		resourceFileName = projectFile.getName();
		if(resourceFileName.matches("\\.[a-zA-Z]+?")){
		resourceFileName = "未命名"+resourceFileName;
		}
		
		return "download";
	}
	
	
	
	
	
	public File getResource() {
		return resource;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}
	public String getResourceFileName() {
		return resourceFileName;
	}
	public void setResourceFileName(String resourceFileName) {
		this.resourceFileName = resourceFileName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
