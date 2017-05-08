package com.itheima.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Files;
import com.itheima.query.BaseQuery;
import com.itheima.query.FilesQuery;
import com.itheima.query.PageResult;

public interface FilesService {
	public void saveFiles(File file, Files files);
	public void deleteFiles(Serializable id);
	public void updateFiles(Files files);
	public Files getFilesByFid(Serializable id);
	public PageResult getFilesByCondition(BaseQuery baseQuery);
	public void deleteFileByIds(Long[] ids);
	public PageResult<Files> getFilesByConditionNotApprove(BaseQuery baseQuery);
	public void saveApproveFiles(Long []fids);
}
