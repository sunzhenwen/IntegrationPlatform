package com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʡ��Ŀ,��Ա����
 * @author Administrator
 *
 */
public class ProjectStaffCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String idCard;
	//��ҵid
	private String corpId;
	//��ʡ������Ŀ����
	private String otherPrjId;
	
	public ProjectStaffCondition()
	{
		
	}
	
	public ProjectStaffCondition(String corpId)
	{
		this.corpId = corpId;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and IDCARD18 like '"+idCard.trim()+"%'");
		}
		if(otherPrjId != null && !"".equals(otherPrjId)){
			sb.append(" and otherPrjId like '"+otherPrjId.trim()+"%'");
		}
		
		String sql = "select * from OTHER_PROJECT_CONSTRUCTOR"+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and IDCARD18 like '"+idCard.trim()+"%'");
		}
		if(otherPrjId != null && !"".equals(otherPrjId)){
			sb.append(" and otherPrjId like '"+otherPrjId.trim()+"%'");
		}
		
		String sqlCount="select count(*) from OTHER_PROJECT_CONSTRUCTOR "+sb.toString();
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}
	
}
