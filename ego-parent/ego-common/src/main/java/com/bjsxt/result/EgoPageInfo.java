package com.bjsxt.result;

import java.io.Serializable;
import java.util.List;

public class EgoPageInfo implements Serializable{
	private static final long serialVersionUID = 8165294377411206984L;
	//当前页
	private Integer currentPage;
	//每页显示的条数
	private Integer pageSize;
	//总条数
	private Long count;
	//总页数
	private Integer total;
	//首页
	private Integer first=1;
	//尾页
	private Integer last;
	//是否展示首页
	private Boolean hasFirst = true;
	//是否展示尾页
	private Boolean hasLast=true;
	//列表
	private List<?> rows;
	/**
	 * 默认构造器
	 */
	public EgoPageInfo() {
	}
	
	/**
	 * 自定义构造器
	 */
	public EgoPageInfo(Integer currentPage, Integer pageSize, Long count) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		if (count != null && count > 0) {
			//总页数
			this.total=(int)(count%pageSize==0?count/pageSize:(count/pageSize)+1);
			//是否展示首页
			if(currentPage != null && currentPage==1) {
				this.hasFirst=false;
			}
			//是否展示尾页
			if(currentPage != null && currentPage == total) {
				this.hasLast=false;
			}
			this.last=total;
		}
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public Boolean getHasFirst() {
		return hasFirst;
	}

	public void setHasFirst(Boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public Boolean getHasLast() {
		return hasLast;
	}

	public void setHasLast(Boolean hasLast) {
		this.hasLast = hasLast;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
