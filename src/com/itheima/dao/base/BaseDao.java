package com.itheima.dao.base;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Files;
import com.itheima.query.BaseQuery;
import com.itheima.query.PageResult;

public interface BaseDao<T> {
	void addEntity(T t);
	void deleteEntity(Serializable id);
	void updateEntity(T t);
	List<T> queryAllEntity();
	/**
	 * 利用完整的hql语句查询
	 * @param hqlselect obj from User obj where obj.name like?
	 * @param params 查询参数 new Object[]{"%itcast%"}
	 * @param start查询起始行
	 * @param limit查询返回最大条数
	 * @return
	 */
	List query(String hql,Object[] params,int start,int limit);
	List query(String hql,Object[] params);
	List<T> getEntityByIds(Serializable[] id);
	/**
	 * @param condition 查询条件，注意不要在这前面加 and 
	 * @param params
	 * @param start
	 * @param limit
	 * @return
	 */
	List<T> queryEntity(String condition,Object[] params,int start,int limit);
	List<T> queryEntity(String condition,Object[] params);
	
	<E> E uniqueResult(String hql,Object[] params);
	
	/**
	 * @param entityClazz
	 * @param baseQuery
	 * @return 含有分页信息的类
	 */
	public PageResult<T> findPageResult(final Class<T> entityClazz,final BaseQuery baseQuery);
	
	T getEntityById(Serializable id);
	/**
	 * 查询指定类的最大主键索引
	 * @param entityClazz
	 * @return
	 */
	Long getMaxIndex(final Class<T> entityClazz);
	/**
	 * 查询继承本接口，泛型参数中类所对应的数据表
	 * @return
	 */
	Long getMaxIndex();
}
