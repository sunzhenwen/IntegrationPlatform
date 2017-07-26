package com.tj.jst.outside.business.queryBusiness.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目报建
 * @author hhc
 *
 */
public class QueryConstructionCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//项目名称
	private String prjName;
	//项目分类
	private String prjTypeNum;
	//组织机构代码
	private String corpCode;
	
	public QueryConstructionCondition()
	{
		
	}
	
	public QueryConstructionCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjTypeNum!= null && !"".equals(prjTypeNum)){
			sb.append(" and PRJTYPENUM='"+prjTypeNum.trim()+"'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and BUILDCORPCODE='"+corpCode.trim()+"'"); 
		}
		
		String sql = "select * from V_TBPROJECTINFO_S "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjTypeNum!= null && !"".equals(prjTypeNum)){
			sb.append(" and PRJTYPENUM='"+prjTypeNum.trim()+"'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and BUILDCORPCODE='"+corpCode.trim()+"'"); 
		}
		String sqlCount="select count(*) from V_TBPROJECTINFO_S "+sb.toString();
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

	public String getPrjTypeNum() {
		return prjTypeNum;
	}

	public void setPrjTypeNum(String prjTypeNum) {
		this.prjTypeNum = prjTypeNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
