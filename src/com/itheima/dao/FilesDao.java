package com.itheima.dao;

import java.util.List;

import com.itheima.dao.base.BaseDao;
import com.itheima.domain.Files;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;

public interface FilesDao extends BaseDao<Files> {
	public List<Files> md5IsExist(String md5);

	public PageResult<Files> findPageResultNotApprove(final Class<Files> entityClazz,final BaseQuery baseQuery);

}
