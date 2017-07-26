package com.tj.jst.inner.corpfilings.notforeign.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业备案
 * @author Administrator
 *
 */
public class CorpFilingsCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//企业名称
	private String corpName;
	//组织机构代码
	private String corpCode;
	//部门Id
	private String deptId;
	//人员Id
	private String personalID;
	
	public CorpFilingsCondition()
	{
		
	}
	
	public CorpFilingsCondition(String deptId)
	{
		this.deptId = deptId;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and appType=0 ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		
		String sql = "select * from V_TBCORPFOREIGNINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and appType=0 ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and creatDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and creatDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		String sqlCount="select count(*) from V_TBCORPFOREIGNINFO "+sb.toString();
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

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
