package com.tj.jst.base.page;

import java.io.Serializable;

/**
 * 基础分页工具类
 * @author Administrator
 *
 */
public abstract class Condition implements Serializable, Cloneable {

	private static final long serialVersionUID = -7448688547460880575L;

	private String orderByItem = "";  //排序
	private String groupByItem = "";  //分组
	
	private int pageSize = Page.DEFAULT_PAGE_SIZE;  //每页包含的记录数
	private int pageNo = 1;  //默认当前页
	
	//查询数据语句
	public abstract String getInitialSql();
	//查询数量语句
	public abstract String getCountSql();
	
	public String getCompleteSql() {
		//获取数据查询语句
		String completeSql = getInitialSql();
		if (!orderByItem.equals(""))
		{
			//拼接排序
			completeSql += " order by " + orderByItem;
		}
			
		if (!groupByItem.equals(""))
		{
			//拼接分组
			completeSql += " group by " + groupByItem;
		}
		return completeSql;
	}
	
	public String getCompleteCountSql() {
		//获取数量查询语句
		String completeCountSql = getCountSql();
		if (!orderByItem.equals(""))
		{
			//拼接排序
			completeCountSql += " order by " + orderByItem;
		}
			
		if (!groupByItem.equals(""))
		{
			//拼接分组
			completeCountSql += " group by " + groupByItem;
		}
		return completeCountSql;
	}
	
	public String getGroupByItem() {
		return groupByItem;
	}

	public void setGroupByItem(String groupByItem) {
		this.groupByItem = groupByItem;
	}

	public String getOrderByItem() {
		return orderByItem;
	}

	public void setOrderByItem(String orderByItem) {
		this.orderByItem = orderByItem;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
