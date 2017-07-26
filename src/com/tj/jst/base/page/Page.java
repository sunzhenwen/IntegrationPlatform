package com.tj.jst.base.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @author hhc
 *
 */
public class Page {
	
	//静态变量，用于设置每页显示记录数
	public static int DEFAULT_PAGE_SIZE = 8;  

	public int pageSize = DEFAULT_PAGE_SIZE;   //一页包含的记录数

	private long start;  //当前页的开始记录索引

	private long totalCount;  //查询记录总数
	
	private String orderByItem;  //排序
	
	private List data;   //该页中的集合数据

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE,"",new ArrayList());
	}

	public Page(long start, long totalSize, int pageSize,String p_orderByItem,List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.orderByItem = p_orderByItem;
		this.data = data;
	}
	
	public Page(long start, long totalSize, int pageSize,String p_orderByItem,Connection conn,PreparedStatement pstmt,ResultSet rs,List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.orderByItem = p_orderByItem;
		this.conn = conn;
		this.pstmt = pstmt;
		this.rs = rs;
		this.data = data;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public  long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPageNo() {
		long pageNo = start / pageSize + 1;
		Long lPageNo = new Long(pageNo);
		return lPageNo.intValue();
	}

	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
	}

	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	
	public static int getEndOfPage(int startIndex,int pageSize)
	{
		return startIndex + pageSize;
	}
	
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrderByItem() {
		return orderByItem;
	}

	public void setOrderByItem(String orderByItem) {
		this.orderByItem = orderByItem;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	
}
