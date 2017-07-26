package com.tj.jst.inner.querycorpreport.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业统计报表分页类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryCorpReportCondition extends Condition {

	private String corpName;// 企业名称
	private String corpCode;// 企业组织机构代码证
	private String reportYear;// 年度
	private String quarter;// 季度

	public QueryCorpReportCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where 1=1 ");

		if (reportYear != null && !"".equals(reportYear)) {
			sb.append(" and reportYear='" + reportYear.trim() + "'");
		}
		if (quarter != null && !"".equals(quarter)) {
			sb.append(" and quarter like '%" + quarter.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode like '%" + corpCode.trim() + "%'");
		}
		String sql = "select * from CORP_REPORT " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where 1=1 ");

		if (reportYear != null && !"".equals(reportYear)) {
			sb.append(" and reportYear='" + reportYear.trim() + "'");
		}
		if (quarter != null && !"".equals(quarter)) {
			sb.append(" and quarter like '%" + quarter.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (corpCode != null && !"".equals(corpCode)) {
			sb.append(" and corpCode like '%" + corpCode.trim() + "%'");
		}
		String sqlCount = "select count(*) from CORP_REPORT " + sb.toString();
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
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

}
