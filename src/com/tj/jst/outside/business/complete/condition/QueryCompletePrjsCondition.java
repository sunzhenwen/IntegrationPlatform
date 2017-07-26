package com.tj.jst.outside.business.complete.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QueryCompletePrjsCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//组织机构代码
	private String corpCode;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;

	public QueryCompletePrjsCondition()
	{
		
	}
	
	public QueryCompletePrjsCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where TO_NUMBER(trim(processSteps))>=6 and AUCORPCODE='"+this.getCorpCode()+"' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from v_pros_TBPROJECTINFO_S "+sb.toString();
		return sql;
	}
	
	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where TO_NUMBER(trim(processSteps))>=6 and AUCORPCODE='"+this.getCorpCode()+"' ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_pros_TBPROJECTINFO_S "+sb.toString();
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

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

}
