package com.tj.jst.outside.business.designSurveyStaff.condition;

import com.tj.jst.base.page.Condition;

/**
 * 勘察设计图审人员
 * @author hhc
 *
 */
public class DesignSurveyStaffCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//项目名称
	private String prjName;
	//项目编号
	private String prjNum;
	//报建单位组织机构代码
	private String conCorpCode;
	
	public DesignSurveyStaffCondition()
	{
		
	}
	
	public DesignSurveyStaffCondition(String conCorpCode)
	{
		this.conCorpCode = conCorpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where conCorpCode='"+conCorpCode+"' ");
		
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
		
		String sql = "select * from TBPROJECTDESIGNECONUSERINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where conCorpCode='"+conCorpCode+"' ");
				
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
		
		String sqlCount="select count(*) from TBPROJECTDESIGNECONUSERINFO "+sb.toString();
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

	public String getConCorpCode() {
		return conCorpCode;
	}

	public void setConCorpCode(String conCorpCode) {
		this.conCorpCode = conCorpCode;
	}

}
