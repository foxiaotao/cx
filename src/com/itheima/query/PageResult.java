package com.itheima.query;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
	private int currentPage;
	private int pageSize;
	//总记录数
	private int totalRows;
	//总页数
	private int totalPage;
	private List<T> rows = new ArrayList<T>();
	//起始页码
	private int startNum;
	private int endNum;
	private String url;
	public PageResult(){}
	public PageResult(int currentPage, int pageSize, int totalRows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
		// currentPage和pageSize最小值必须是1
		this.currentPage = Math.max(this.currentPage, 1);
		this.pageSize = Math.max(this.pageSize, 1);
		// 总页数:计算出来
		this.totalPage = (this.totalRows + this.pageSize - 1) / this.pageSize;
		// 错误处理
		// 当前页面不能大于总页数
		this.currentPage = Math.min(this.currentPage, this.totalPage);
		//中间选择页码
		if(this.totalPage<10){
			this.startNum=1;
			this.endNum=this.totalPage;
		}
		else{
			if(currentPage<=5){
				this.startNum=1;
				this.endNum=9;
			}
			else{
				if(this.currentPage+4>=this.totalPage){
					this.endNum=this.totalPage;
					this.startNum=this.totalPage-8;
				}
				else{
					this.startNum=this.currentPage-4;
					this.endNum = this.currentPage+4;
				}
			}
		}
		
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

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
