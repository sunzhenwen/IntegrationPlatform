package com.tj.jst.outside.business.contractFiling.condition;

import com.tj.jst.base.page.Condition;

/**
 * 监理合同备案
 * @author hhc
 *
 */
public class SupervisorContractFilingCondition extends Condition {

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
	//合同类别
	private String contractTypeNum;
	
	public SupervisorContractFilingCondition()
	{
		
	}
	
	public SupervisorContractFilingCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where trim(processSteps)=3 and contractTypeNum='400' ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and APPLYCORPCODE='"+corpCode.trim()+"'"); 
		}
		//2016-04-29添加
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and aucorpcode='"+corpCode.trim()+"'"); 
		}
		String sql = "select * from v_tbcontractrecordmanage "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where trim(processSteps)=3 and contractTypeNum='400' ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and APPLYCORPCODE='"+corpCode.trim()+"'"); 
		}
		//2016-04-29添加
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and aucorpcode='"+corpCode.trim()+"'"); 
		}
		String sqlCount="select count(*) from v_tbcontractrecordmanage "+sb.toString();
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

}
