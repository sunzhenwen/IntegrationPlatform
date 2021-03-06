package com.tj.jst.outside.business.queryBusiness.condition;

import com.tj.jst.base.page.Condition;

/**
 * 单体工程
 * @author hhc
 *
 */
public class QuerySingleProjectCondition extends Condition {

	private String spNum;//单位编码
	private String buildingName;//单位建(构)筑物名称
	//主体项目主键
	private String prjId;
	//环节
	private String linkName;
	
	public QuerySingleProjectCondition()
	{
		
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' and createtype='"+linkName+"' ");
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");
		
		if(spNum!= null && !"".equals(spNum)){
			sb.append(" and unitcode like '%"+spNum+"%'"); 
		}
		if(buildingName!= null && !"".equals(buildingName)){
			sb.append(" and subprjname like '%"+buildingName+"%'"); 
		}

		
		String sql = "select * from TBPROJECTUNITINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' and createtype='"+linkName+"' ");
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");
		
		if(spNum!= null && !"".equals(spNum)){
			sb.append(" and unitcode like '%"+spNum+"%'"); 
		}
		if(buildingName!= null && !"".equals(buildingName)){
			sb.append(" and subprjname like '%"+buildingName+"%'"); 
		}
		String sqlCount="select count(*) from TBPROJECTUNITINFO "+sb.toString();
		return sqlCount;
	}

	public String getSpNum() {
		return spNum;
	}

	public void setSpNum(String spNum) {
		this.spNum = spNum;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

}
