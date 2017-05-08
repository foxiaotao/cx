package com.itheima.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.itheima.dao.FilesDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.Files;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;
@Repository("filesDao")
public class FilesDaoImpl extends BaseDaoImpl<Files> implements FilesDao {

	@Override
	public List<Files> md5IsExist(String md5) {
		List<Files> files = this.getHibernateTemplate().find("from Files where md5=?",md5);
		return files;
	}


	//为通过的审核的文件
	public PageResult<Files> findPageResultNotApprove(final Class<Files> entityClazz,final BaseQuery baseQuery){
		final Long count = this.getHibernateTemplate().execute(new HibernateCallback<Long>(){
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select count(o) from Files o where o.approve='0'");
				return (Long) query.uniqueResult();
			}
		});
		final String where = baseQuery.getWhere();
		final List param = baseQuery.getParams();
		final StringBuffer sb = new StringBuffer("from Files o where approve='0' ");
		if(param.size()>0){
			sb.append(" and ");
		}
		return this.getHibernateTemplate().execute(new HibernateCallback<PageResult<Files>>(){
			@Override
			public PageResult<Files> doInHibernate(Session session)
					throws HibernateException, SQLException {
				PageResult<Files> pageResult = new PageResult<Files>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), count.intValue());
				sb.append(where);
				Query query = session.createQuery(sb.toString());
				for (int i = 0; i < param.size(); i++) {
					query.setParameter(i, param.get(i));
				}
				query.setFirstResult(pageResult.getStartNum());
				query.setMaxResults(pageResult.getPageSize());
				pageResult.setRows(query.list());
				return pageResult;
			}
			
		});
	}

		
}
