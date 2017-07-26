package com.tj.jst.outside.business.corpReport.condition;

import com.tj.jst.base.page.Condition;

/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public class CorpReportCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//年
	private String reportYear;
	//季度
	private String quarter;
	//组织机构代码
	private String corpCode;
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(reportYear!= null && !"".equals(reportYear)){
			sb.append(" and reportYear='"+reportYear.trim()+"'"); 
		}
		if(quarter!= null && !"".equals(quarter)){
			sb.append(" and quarter like '%"+quarter.trim()+"%'"); 
		}
		
		String sql = "select * from CORP_REPORT "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(reportYear!= null && !"".equals(reportYear)){
			sb.append(" and reportYear='"+reportYear.trim()+"'"); 
		}
		if(quarter!= null && !"".equals(quarter)){
			sb.append(" and quarter like '%"+quarter.trim()+"%'"); 
		}
		String sqlCount="select count(*) from CORP_REPORT "+sb.toString();
		return sqlCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
