package com.itheima.dao.impl;


import org.springframework.stereotype.Repository;

import com.itheima.dao.ProjectFileDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.ProjectFile;
@Repository("projectFileDao")
public class ProjectFileDaoImpl extends BaseDaoImpl<ProjectFile> implements
		ProjectFileDao {


}
