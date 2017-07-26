package com.tj.jst.outside.business.corpReport.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public class CorpReportCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//��
	private String reportYear;
	//����
	private String quarter;
	//��֯��������
	private String corpCode;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
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
