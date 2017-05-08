package com.itheima.service;

import java.io.File;
import java.io.IOException;

import com.itheima.domain.Achievement;
import com.itheima.query.AchievementQuery;
import com.itheima.query.PageResult;

public interface AchievementService {
	public void save(File file,String resourceFileName,Achievement achievement) throws Exception, IOException;
	public void delete(Long aid);
	public void update(File file,String fileName,Achievement achievement);
	public Achievement getAchievementByAid(Long aid);
	public PageResult<Achievement> getPageResult(AchievementQuery achievementQuery);
}
