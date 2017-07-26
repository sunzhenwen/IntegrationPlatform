package com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ѯ��ҵ��Ա
 * @author Administrator
 *
 */
public class QueryPrjStaffCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String idCard;
	private String corpCode;

	public QueryPrjStaffCondition()
	{
		
	}
	
	public QueryPrjStaffCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and cardid like '"+idCard.trim()+"%'");
		}
		
		String sql = "select * from other_project_staff"+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and cardid like '"+idCard.trim()+"%'");
		}
		
		String sqlCount="select count(*) from other_project_staff "+sb.toString();
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
