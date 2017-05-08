package com.itheima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Achievement;
import com.itheima.query.AchievementQuery;
import com.itheima.query.PageResult;
import com.itheima.service.AchievementService;
import com.opensymphony.xwork2.ActionContext;

@Controller("achievementAction")
@Scope("prototype")
public class AchievementAction extends BaseAction<Achievement> {
	@Resource
	private AchievementService achievementService;
	
	//文件上传
	private File resource;
	private String resourceFileName;
	
	//批量
	private Long[] ids;
	
	//分页条件
	private AchievementQuery achievementQuery = new AchievementQuery();
	private int pageSize = 15;
	
	//下载
	private InputStream inputStream;
	
	
	@PrivilegeAnnotation(name="成果浏览")
	public String showAchievementByPage(){
		achievementQuery.setPageSize(pageSize);
		PageResult<Achievement> pageResult = this.achievementService.getPageResult(achievementQuery);
		//  ??
		pageResult.setUrl("achievementAction_showAchievementByPage.action?achievementQuery.");
		ActionContext.getContext().put("pageResult", pageResult);
		return "listAction";
	}
	
	
	@PrivilegeAnnotation(name="成果添加")
	public String addUI(){
		return "addUI";
	}
	
	@PrivilegeAnnotation(name="成果添加")
	public String add() throws IOException, Exception{
		Achievement achievement = new Achievement();
		BeanUtils.copyProperties(this.getModel(), achievement);
		if(StringUtils.isBlank(achievement.getType())){
			ActionContext.getContext().getValueStack().push("必填信息不能为空");
			return "info_errer";
		}
		this.achievementService.save(resource,resourceFileName, achievement);
		return "action2action";
	}
	@PrivilegeAnnotation(name="成果修改")
	public String updateUI(){
		Achievement achievement = this.achievementService.getAchievementByAid(this.getModel().getAid());
		ActionContext.getContext().getValueStack().push(achievement);
		return "updateUI";
	}
	@PrivilegeAnnotation(name="成果修改")
	public String update(){
		
		Achievement achievement = new Achievement();
		BeanUtils.copyProperties(this.getModel(), achievement);
		this.achievementService.update(resource,resourceFileName,achievement);
		return "action2action";
	}
	@PrivilegeAnnotation(name="成果删除")
	public String delete(){
		deleteAchievement(this.getModel().getAid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="成果删除")
	public String deleteBatch(){
		for (Long aid : ids) {
			deleteAchievement(aid);
		}
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="成果浏览")
	public String download(){
		//佐证下载
		Achievement achievement = this.achievementService.getAchievementByAid(this.getModel().getAid());
		String path = achievement.getUrl();
		try {
			inputStream = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			ActionContext.getContext().getValueStack().push("文件已删除或不存在！");
			return "errer";
		}
		String url = achievement.getUrl();
		resourceFileName = achievement.getName()+"_佐证材料"+url.substring(url.lastIndexOf("."));
		if(resourceFileName.matches("\\.[a-zA-Z]+?")){
		resourceFileName = "未命名"+resourceFileName;
		}
		
		return "download";
	}
//	@PrivilegeAnnotation(name="成果浏览")
//	public String look(){
//		//佐证查看
//		
//	}
	
	
	//私有
	private void deleteAchievement(Long aid){
		this.achievementService.delete(aid);
	}
	
	//  set ---  get
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

	public AchievementQuery getAchievementQuery() {
		return achievementQuery;
	}
	public void setAchievementQuery(AchievementQuery achievementQuery) {
		this.achievementQuery = achievementQuery;
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


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
