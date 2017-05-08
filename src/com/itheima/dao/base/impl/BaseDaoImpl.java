package com.itheima.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.dao.base.BaseDao;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];

	}

	private ClassMetadata classMetadata;

	@PostConstruct
	public void init() {
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.clazz);
	}

	@Override
	public T getEntityById(Serializable id) {
		return (T) this.hibernateTemplate.get(clazz, id);
	}

	@Override
	public void addEntity(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void deleteEntity(Serializable id) {
		this.hibernateTemplate.delete(getEntityById(id));
	}

	@Override
	public void updateEntity(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public List query(final String hql,final Object[] params,final int start,final int limit) {
		List<Object> result = this.getHibernateTemplate().execute(new HibernateCallback<List<Object>>(){

			private Query query;

			@Override
			public List<Object> doInHibernate(Session session)
					throws HibernateException, SQLException {
				query = session.createQuery(hql);
				if(start>0){
					query.setFirstResult(start);
				}
				if(limit>0){
					query.setMaxResults(limit);
				}
				return query.list();
			}
			
		});
		return result;
	}

	@Override
	public List query(final String hql,final Object[] params) {
		return query(hql,params,-1,-1);
	}

	@Override
	public List<T> queryEntity(String condition, Object[] params, int start,int limit) {
		StringBuffer hql =new StringBuffer("SELECT obj FROM "+clazz.getName()+" obj WHERE 1=1 ");
		//if(StringUtils.hasLength(condition)){
			if(!condition.startsWith("ORDER BY")){//如果不是以order by开始，则跟条件
				hql.append(" AND ").append(condition);
			}else{
				hql.append(" ").append(condition);//如果是以order by开始，则直接order by一个字段
			}
		//}
		return query(hql.toString(), params, start, limit);
	}

	@Override
	public List<T> queryEntity(String condition, Object[] params) {
		return queryEntity(condition, params,-1,-1);
	}

	@Override
	public <E> E uniqueResult(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<T> findPageResult(final Class<T> entityClazz,final BaseQuery baseQuery) {
		int count = this.getCount(entityClazz, baseQuery);
		if(count==0){
			return new PageResult<T>();
		}
		//定义pageResult类，返回给调用者，里边包含所有条件查询和分页的信息
		final PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(),baseQuery.getPageSize(),count);
		
		final String where = baseQuery.getWhere();
		final List params = baseQuery.getParams();
		final ClassMetadata metadata = this.getHibernateTemplate().getSessionFactory().getClassMetadata(entityClazz);
		final StringBuilder builder = new StringBuilder("select o from "+ entityClazz.getName() + " o ");
		
		
		// select o from User o where o.name like ? and o.password=?,params
		List<T> rows =  this.hibernateTemplate.execute(new HibernateCallback<List<T>>() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						if (StringUtils.isNotBlank(where)) {
							// select o from User o where o.name like ? and o.password=?,params
							builder.append(" where ").append(where);
						}
						//按照主键降序
						builder.append(" order by "+classMetadata.getIdentifierPropertyName()+" desc");
						
						Query q = session.createQuery(builder.toString());
						for (int i = 0; i < params.size(); i++) {
							//jdbc 1开始  hibernate 是从0开始的
							q.setParameter(i, params.get(i));
						}
						//开启查询二级缓存
//						q.setCacheable(true);
						//每页10条    2 页 ：开始10-10
						int first = (pageResult.getCurrentPage()-1) * pageResult.getPageSize();
						int max = pageResult.getPageSize();
						q.setFirstResult(first).setMaxResults(max);
						List list = q.list();
						return list;
					}
				});
		pageResult.setRows(rows);
		return pageResult;
	}
	
	@Override
	public Long getMaxIndex(final Class<T> entityClazz) {
		final ClassMetadata metadata = this.getHibernateTemplate()
				.getSessionFactory().getClassMetadata(entityClazz);

		return this.hibernateTemplate.execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select count(*) from "
						+ clazz.getName());
				return (Long) query.uniqueResult();
			}

		});
	}

	@Override
	public Long getMaxIndex() {
		return this.getMaxIndex(this.clazz);
	}

	/**
	 * 获取给定条件的结果集的总数
	 * 
	 * @return
	 */
	private int getCount(final Class<T> entityClazz, final BaseQuery baseQuery) {
		final String where = baseQuery.getWhere();
		final List params = baseQuery.getParams();
		final ClassMetadata metadata = this.getHibernateTemplate()
				.getSessionFactory().getClassMetadata(entityClazz);
		final StringBuilder builder = new StringBuilder("select count(o) from "
				+ entityClazz.getName() + " o");
		
//		if(where.contains("d.did")){
//			builder.append(" inner join fetch o.department d ");
//		}
//		if(where.contains("r.rid")){
//			builder.append(" inner join fetch o.role r ");
//		}
		
		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session) throws HibernateException, SQLException {
						if (StringUtils.isNotBlank(where)) {
							builder.append(" where ").append(where);
						}
						Query query = session.createQuery(builder.toString());
						for (int i = 0; i < params.size(); i++) {
							query.setParameter(i, params.get(i));
						}
						
						
						Long len = (Long) query.uniqueResult();
						return (int) len.longValue();
					}
				});
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<T> queryAllEntity() {
		return this.hibernateTemplate.find("from "+clazz.getName() + " order by " + classMetadata.getIdentifierPropertyName() + " desc");
	}

	@Override
	public List<T> getEntityByIds(Serializable[] id) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append("select o from "+clazz.getName()+" o where "+classMetadata.getIdentifierPropertyName()+" in (");
		for (int i = 0; i < id.length; i++) {
			if(i>0){
				buffer.append(",");
			}
			buffer.append(id[i]);
		}
		buffer.append(")");
		
		return this.getHibernateTemplate().execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(buffer.toString());
				return query.list();
			}
			
		});
	}
}
