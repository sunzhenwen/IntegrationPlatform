package com.tj.jst.inner.corpfilings.queryCorpApply.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ����������ѯ
 * @author Administrator
 *
 */
public class QueryCorpFilingsCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//��ҵ����
	private String corpName;
	//����Id
	private String deptId;
	//��ԱId
	private String personalID;
	
	public QueryCorpFilingsCondition()
	{
		
	}
	
	public QueryCorpFilingsCondition(String deptId)
	{
		this.deptId = deptId;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
		//StringBuffer sb=new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and appType!=0 ");
		StringBuffer sb=new StringBuffer(" where corpName not like '%����%' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		
		String sql = "select * from V_TBCORPBASICINFO "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		//StringBuffer sb=new StringBuffer(" where rtrim(SPARE1)='"+deptId+"' and appType!=0 ");
		StringBuffer sb=new StringBuffer(" where corpName not like '%����%' ");	
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		
		String sqlCount="select count(*) from V_TBCORPBASICINFO "+sb.toString();
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

}
