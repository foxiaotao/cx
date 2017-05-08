package com.itheima.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.AchievementDao;
import com.itheima.domain.Achievement;
import com.itheima.query.AchievementQuery;
import com.itheima.query.PageResult;
import com.itheima.service.AchievementService;
import com.itheima.util.FileUploadUtils;
import com.itheima.util.UploadToWEB_INF;
@Service
public class AchievementServiceImpl implements AchievementService {
	
	@Resource
	private AchievementDao achievementDao;
	
	
	public void save(File file,String resourceFileName,Achievement achievement) throws Exception, IOException {
		//tomcat中的路径
		String path = UploadToWEB_INF.saveUploadFile(file,resourceFileName);
		//把项目径路存在数据库中
		achievement.setContextPath(path.substring(path.indexOf("_")));
		//上传到指定磁盘，防止文件丢失
		String url = FileUploadUtils.saveUploadFile(new File(path), resourceFileName);
		achievement.setUrl(url);
		FileUploadUtils.copyFile(url, path);
		
		this.achievementDao.addEntity(achievement);
	}

	public void delete(Long aid) {
		Achievement achievement = this.achievementDao.getEntityById(aid);
		String url = achievement.getUrl();
		File file = new File(url);
		file.deleteOnExit();
		this.achievementDao.deleteEntity(aid);
	}

	public void update(File file,String fileName,Achievement achievementWeb) {
		//查出来
		Achievement achievement = this.achievementDao.getEntityById(achievementWeb.getAid());
		achievement.setMembers(achievementWeb.getMembers());
		achievement.setName(achievementWeb.getName());
		achievement.setYear(achievementWeb.getYear());
		
		String oldUrl = achievement.getUrl();
		String oldPath = achievement.getContextPath();
		if(oldUrl!=null){
			 //删除原来的文件
			 File oldFile = new File(oldUrl);
			 oldFile.deleteOnExit();
		}
		if(oldPath!=null){
			//删除原来的文件
			File oldFile = new File(oldPath);
			oldFile.deleteOnExit();
		}
		 //上传新的佐证文件
		//tomcat中的路径
		String path = UploadToWEB_INF.saveUploadFile(file,fileName);
		//把项目径路存在数据库中
		achievement.setContextPath(path.substring(path.indexOf("_")));
		//上传到指定磁盘，防止文件丢失
		String url = FileUploadUtils.saveUploadFile(new File(path), fileName);
		achievement.setUrl(url);

		this.achievementDao.updateEntity(achievement);
	}

	public Achievement getAchievementByAid(Long aid) {
		return this.achievementDao.getEntityById(aid);
	}

	public PageResult<Achievement> getPageResult(
			AchievementQuery achievementQuery) {
		return this.achievementDao.findPageResult(Achievement.class, achievementQuery);
	}

}
