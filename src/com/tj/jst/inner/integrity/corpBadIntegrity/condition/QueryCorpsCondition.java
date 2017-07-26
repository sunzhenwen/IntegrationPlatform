package com.tj.jst.inner.integrity.corpBadIntegrity.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ҵ��ѯ
 * @author Administrator
 *
 */
public class QueryCorpsCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//��ҵ����
	private String corpName;
	//��֯��������
	private String corpCode;
	//����Id
	private String deptId;
	//��ԱId
	private String personalID;
	
	public QueryCorpsCondition()
	{
		
	}
	
	public QueryCorpsCondition(String deptId)
	{
		this.deptId = deptId;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATDATE desc ");
		//��ѯ��ǰ���õ�λ��
		//StringBuffer sb=new StringBuffer(" where appType!=2 or appType!=0 ");
		StringBuffer sb=new StringBuffer(" where 1=1 ");
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 ");
				
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
		System.out.println("sqlCount= "+sqlCount);
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
