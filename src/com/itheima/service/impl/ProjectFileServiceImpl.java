package com.itheima.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.ProjectFileDao;
import com.itheima.domain.ProjectFile;
import com.itheima.service.ProjectFileService;
import com.itheima.util.FileUploadUtils;
@Service("projectFileService")
public class ProjectFileServiceImpl implements ProjectFileService {
	@Resource(name="projectFileDao")
	private ProjectFileDao projectFileDao;
	
	
	public void saveProjectFile(File file, String fileName) {
		String url = FileUploadUtils.saveUploadFile(file, fileName);
		ProjectFile projectFile = new ProjectFile();
		projectFile.setName(fileName);
		projectFile.setUrl(url);
		this.projectFileDao.addEntity(projectFile);
	}

	public ProjectFile getProjectFile(Long pfid) {
		return this.projectFileDao.getEntityById(pfid);
	}

	public List<ProjectFile> getAllProjectFile() {
		return this.projectFileDao.queryAllEntity();
	}

	public void delete(Long pfid) {
		ProjectFile projectFile = this.projectFileDao.getEntityById(pfid);
		File file = new File(projectFile.getUrl());
		file.deleteOnExit();
		this.projectFileDao.deleteEntity(pfid);
		
	}

}
