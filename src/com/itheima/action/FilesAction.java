package com.itheima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Department;
import com.itheima.domain.Files;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.FilesQuery;
import com.itheima.query.PageResult;
import com.itheima.service.DepartmentService;
import com.itheima.service.FilesService;
import com.opensymphony.xwork2.ActionContext;
@Controller("filesAction")
@Scope("prototype")
public class FilesAction extends BaseAction<Files> {
	@Resource
	private FilesService filesService;
	@Resource
	private DepartmentService departmentService;
	//上传
	private File resource;
	private String resourceFileName;
	
	//下载
	private InputStream inputStream;
	
	private int pageSize = 15;
	
	//批量删除的ids
	private Long[] ids;
	//审核
	private Long []fids;
	
	FilesQuery filesQuery = new FilesQuery();
	@PrivilegeAnnotation(name="文件维护")
	public String showFilesByCondition(){
		//设置显示页数  从页面传过来的
		filesQuery.setPageSize(this.pageSize);
		PageResult<Files> pageResult = this.filesService.getFilesByCondition(filesQuery);
		pageResult.setUrl("filesAction_showFilesByCondition.action?filesQuery.");//属性驱动
		ActionContext.getContext().put("pageResult", pageResult);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		return "listAction";
	}
	@PrivilegeAnnotation(name="文件上传")
	public String addUI(){
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		return "addUI";
	}
//	FileUploadInterceptor
	@PrivilegeAnnotation(name="文件上传")
	public String addFiles(){//文件上传
		Files newfile = new Files();
		BeanUtils.copyProperties(this.getModel(), newfile);
		
		//判断所填信息是否为空
		if(newfile.getDepartment().getDid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		if(StringUtils.isBlank(newfile.getType())){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		
		newfile.setName(resourceFileName);//把上传文件的名字给对象，方便往service层调用
		this.filesService.saveFiles(resource, newfile);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		//转发到添加页面
		return "add";
	}

	//文件下载
	@PrivilegeAnnotation(name="文件下载")
	public String download(){
		Files files = this.filesService.getFilesByFid(this.getModel().getFid());
		String path = files.getUrl();
		try {
			inputStream = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			ActionContext.getContext().getValueStack().push("文件已删除或不存在！");
			return "errer";
		}
		resourceFileName = files.getName();
		if(resourceFileName.matches("\\.[a-zA-Z]+?")){
		resourceFileName = "未命名"+resourceFileName;
		}
		
		return "download";
	}
	@PrivilegeAnnotation(name="文件修改")
	public String updateUI(){
		Files files = this.filesService.getFilesByFid(this.getModel().getFid());
		ActionContext.getContext().getValueStack().push(files);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		
		return "updateUI";
	}
	
	@PrivilegeAnnotation(name="文件修改")
	public String update(){
		Files files = this.filesService.getFilesByFid(this.getModel().getFid());
		Files updateFiles = this.getModel();
		//判断所填信息是否为空
		if(updateFiles.getDepartment().getDid()==null){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		if(StringUtils.isBlank(updateFiles.getType())){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		files.setType(updateFiles.getType());
		files.setDepartment(updateFiles.getDepartment());
		files.setDescription(updateFiles.getDescription());
		files.setName(updateFiles.getName());
		
		this.filesService.updateFiles(files);
		return "action2action";
	}
	//删除一个
	@PrivilegeAnnotation(name="文件删除")
	public String deleteFiles(){
		this.filesService.deleteFiles(this.getModel().getFid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="删除本人文件")
	public String deleteBySelf(){
		this.filesService.deleteFiles(this.getModel().getFid());
		return "action2share";
	}
	//删除全部
	@PrivilegeAnnotation(name="文件删除")
	public String deleteBatch(){
		this.filesService.deleteFileByIds(ids);
		return "action2action";
	}
	@PrivilegeAnnotation(name="删除本人文件")
	public String deleteBatchMyself(){
		this.filesService.deleteFileByIds(ids);
		return "action2share";
	}
	//文件审核
	@PrivilegeAnnotation(name="文件审核")
	public String approveUI(){
		//设置显示页数  从页面传过来的
		filesQuery.setPageSize(this.pageSize);
		PageResult<Files> pageResult = this.filesService.getFilesByConditionNotApprove(filesQuery);
		if(pageResult.getRows()==null){
			ActionContext.getContext().getValueStack().push("暂时没有需要审核的文件");
			return "errer";
		}
		pageResult.setUrl("filesAction_approveUI.action?filesQuery.");//属性驱动
		ActionContext.getContext().put("pageResult", pageResult);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		return "approveUI";
	}
	@PrivilegeAnnotation(name="文件审核")
	public String approve(){
		this.filesService.saveApproveFiles(fids);
		return "toApproveUIAction";
		
	}
	@PrivilegeAnnotation(name="中心共享资料")
	public String showFilesByConditionshare(){
		//设置显示页数  从页面传过来的
		filesQuery.setPageSize(this.pageSize);
		filesQuery.setType("1");
		PageResult<Files> pageResult = this.filesService.getFilesByCondition(filesQuery);
		pageResult.setUrl("filesAction_showFilesByCondition.action?filesQuery.");//属性驱动
		ActionContext.getContext().put("pageResult", pageResult);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		return "share";
	}
	
	
	@PrivilegeAnnotation(name="个人资料")
	public String showFilesByConditionByMyself(){
		//设置显示页数  从页面传过来的
		filesQuery.setPageSize(this.pageSize);
		//设置为私有类型
		filesQuery.setType("0");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//设置为当前登录用户
		filesQuery.setUser(user);
		PageResult<Files> pageResult = this.filesService.getFilesByCondition(filesQuery);
		pageResult.setUrl("filesAction_showFilesByCondition.action?filesQuery.");//属性驱动
		ActionContext.getContext().put("pageResult", pageResult);
		
		//页面部门选择
		List<Department> departments = this.departmentService.getAllDepartment();
		Department d= new Department();
		d.setDid(null);
		d.setName("---请选择---");
		departments.add(0, d);
		ActionContext.getContext().put("departments", departments);
		return "myself";
	}
	
	
	
	//get set
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

	public FilesQuery getFilesQuery() {
		return filesQuery;
	}

	public void setFilesQuery(FilesQuery filesQuery) {
		this.filesQuery = filesQuery;
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

	public Long[] getFids() {
		return fids;
	}

	public void setFids(Long[] fids) {
		this.fids = fids;
	}

	
}
