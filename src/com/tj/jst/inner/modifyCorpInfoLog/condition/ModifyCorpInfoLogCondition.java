package com.tj.jst.inner.modifyCorpInfoLog.condition;

import java.util.Date;

import com.tj.jst.base.page.Condition;

public class ModifyCorpInfoLogCondition extends Condition{
	
	//企业名称
	private String corpName ;
	//企业组织机构代码证号
	private String corpCode ;
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		
		if(!"".equals(corpName) && null != corpName){
			sb.append(" and corpName like '%"+corpName.trim()+"%' ");
		}
		if(!"".equals(corpCode) && null != corpCode){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%' ");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and modifyDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and modifyDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		String sql = "select * from MODIFYCORPINFO_LOG" + sb.toString() + " order by modifyDate desc ";
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		
		if(!"".equals(corpName) && null != corpName){
			sb.append(" and corpName like '%"+corpName.trim()+"%' ");
		}
		if(!"".equals(corpCode) && null != corpCode){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%' ");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and modifyDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and modifyDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		String sqlCount = "select count(*) from MODIFYCORPINFO_LOG " + sb.toString();
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

	
	
}
