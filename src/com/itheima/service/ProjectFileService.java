package com.itheima.service;

import java.io.File;
import java.util.List;

import com.itheima.domain.ProjectFile;

public interface ProjectFileService {
	public void saveProjectFile(File file,String fileName);
	public ProjectFile getProjectFile(Long pfid);
	public List<ProjectFile> getAllProjectFile();
	public void delete(Long pfid);
	
}
