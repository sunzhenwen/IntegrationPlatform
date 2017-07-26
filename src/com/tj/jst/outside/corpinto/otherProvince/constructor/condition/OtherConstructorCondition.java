package com.tj.jst.outside.corpinto.otherProvince.constructor.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public class OtherConstructorCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String idCard;
	//ѧ��
	private String eduLevelNum;
	//ѧλ
	private String degreeNum;
	//��ҵid
	private String corpId;
	private String corpCode;
	
	public OtherConstructorCondition()
	{
		
	}
	
	public OtherConstructorCondition(String corpCode)
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
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(eduLevelNum!= null && !"".equals(eduLevelNum)){
			sb.append(" and EDULEVELNUM = '"+Integer.parseInt(eduLevelNum.trim())+"'"); 
		}
		if(degreeNum != null && !"".equals(degreeNum)){
			sb.append(" and DEGREENUM = '"+Integer.parseInt(degreeNum.trim())+"'");
		}
		
		String sql = "select * from V_CONSTRUCTOR"+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(eduLevelNum!= null && !"".equals(eduLevelNum)){
			sb.append(" and EDULEVELNUM = '"+Integer.parseInt(eduLevelNum.trim())+"'"); 
		}
		if(degreeNum != null && !"".equals(degreeNum)){
			sb.append(" and DEGREENUM = '"+Integer.parseInt(degreeNum.trim())+"'");
		}
		String sqlCount="select count(*) from V_CONSTRUCTOR "+sb.toString();
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

	public String getEduLevelNum() {
		return eduLevelNum;
	}

	public void setEduLevelNum(String eduLevelNum) {
		this.eduLevelNum = eduLevelNum;
	}

	public String getDegreeNum() {
		return degreeNum;
	}

	public void setDegreeNum(String degreeNum) {
		this.degreeNum = degreeNum;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
