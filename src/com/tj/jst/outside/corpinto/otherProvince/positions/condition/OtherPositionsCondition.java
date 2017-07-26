package com.tj.jst.outside.corpinto.otherProvince.positions.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public class OtherPositionsCondition extends Condition {

	//��Ա����
	private String personName;
	//֤������
	private String cardId;
	//��ҵ����
	private String corpName;
	//��λ����
	private String duty;
	//��ҵ����
	private String corpId;
	
	public OtherPositionsCondition()
	{
		
	}
	
	public OtherPositionsCondition(String corpId)
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
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(cardId != null && !"".equals(cardId)){
			sb.append(" and cardId like '"+cardId.trim()+"%'");
		}
		String sql = "select * from POSITION_CERTIFICATE"+sb.toString();
		System.out.println("sql= "+sql);
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
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(cardId != null && !"".equals(cardId)){
			sb.append(" and cardId like '"+cardId.trim()+"%'");
		}
		String sqlCount = "select count(*) from POSITION_CERTIFICATE"+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
