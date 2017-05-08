package com.itheima.query;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 抽象出公共的查询信息：当前页面，一页显示多少条数据，hql信息
 * @author suntao
 *
 */
/**
 * @author Administrator
 *
 */
public abstract class BaseQuery {
	private int currentPage = 1;
	private int pageSize = 15;
	/**
	 * 封装查询的hql语句，具体的查询条件来自于子类
	 */
	private StringBuffer builder = new StringBuffer();
	private List params = new ArrayList();
	
	/**
	 * 必须让子类复写，在这里面先判断是否有条件，有添加条件
	 */
	protected abstract void addWhere();
	
	/**
	 * 保证addWhere只被调用一次
	 */
	private boolean flag = false;
	
	/**
	 * 
	 * @param hql
	 * @param objects
	 */
	protected void addWhere(String hql,Object...objects){
		//第2-n次的条件
		if(builder.length()>0){
			builder.append(" and ");
		}
		builder.append(hql);
		//addAll,Arrays.adList
		params.addAll(Arrays.asList(objects));
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 直接给BaseDao使用: o.username like ? and o.email like ?
	 * @return
	 */
	public String getWhere(){
		if(!flag){
			this.addWhere();
		}
		flag = true;
		return builder.toString();
	}
	
	/**
	 * 直接给BaseDao使用： %admin%,%admin%
	 * @return
	 */
	public List getParams() {
		return params;
	}
	
	
	
}
