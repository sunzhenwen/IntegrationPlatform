package com.tj.jst.outside.business.authorization.condition;

import com.tj.jst.base.page.Condition;

/**
 * 授权
 * @author hhc
 *
 */
public class AuthorizationCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//项目名称
	private String prjName;
	//项目编号
	private String prjNum;
	//组织机构代码
	private String corpCode;
	private String auCorpName;
	private String auCorpCode;
	public AuthorizationCondition()
	{
		
	}
	
	public AuthorizationCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode.trim()+"' ");
		
//		if(startDate!= null && !"".equals(startDate)){
//			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
//		}
//		if(endDate != null && !"".equals(endDate)){
//			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
//		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(auCorpName!= null && !"".equals(auCorpName)){
			sb.append(" and auCorpName like '%"+auCorpName.trim()+"%'"); 
		}
		if(auCorpCode!= null && !"".equals(auCorpCode)){
			sb.append(" and auCorpCode like '%"+auCorpCode.trim()+"%'"); 
		}
		String sql = "select * from TO_AUTHORIZATION "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode.trim()+"' ");
				
//		if(startDate!= null && !"".equals(startDate)){
//			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
//		}
//		if(endDate != null && !"".equals(endDate)){
//			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
//		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(auCorpName!= null && !"".equals(auCorpName)){
			sb.append(" and auCorpName like '%"+auCorpName.trim()+"%'"); 
		}
		if(auCorpCode!= null && !"".equals(auCorpCode)){
			sb.append(" and auCorpCode like '%"+auCorpCode.trim()+"%'"); 
		}
		String sqlCount="select count(*) from TO_AUTHORIZATION "+sb.toString();
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getAuCorpName() {
		return auCorpName;
	}

	public void setAuCorpName(String auCorpName) {
		this.auCorpName = auCorpName;
	}

	public String getAuCorpCode() {
		return auCorpCode;
	}

	public void setAuCorpCode(String auCorpCode) {
		this.auCorpCode = auCorpCode;
	}

}
