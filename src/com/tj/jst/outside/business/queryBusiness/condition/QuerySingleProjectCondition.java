package com.tj.jst.outside.business.queryBusiness.condition;

import com.tj.jst.base.page.Condition;

/**
 * ���幤��
 * @author hhc
 *
 */
public class QuerySingleProjectCondition extends Condition {

	private String spNum;//��λ����
	private String buildingName;//��λ��(��)��������
	//������Ŀ����
	private String prjId;
	//����
	private String linkName;
	
	public QuerySingleProjectCondition()
	{
		
	}
	
	//��ѯ���
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

	//��ѯ����
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
