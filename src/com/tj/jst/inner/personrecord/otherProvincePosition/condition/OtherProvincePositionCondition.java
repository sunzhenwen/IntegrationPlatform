package com.tj.jst.inner.personrecord.otherProvincePosition.condition;

import com.tj.jst.base.page.Condition;

public class OtherProvincePositionCondition extends Condition {

	// ��Ա����
	private String personName;
	// ֤������
	private String idCard;
	// ��ҵ����
	private String corpName;
	// ��λ����
	private String duty;

	public OtherProvincePositionCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and name like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and entName like '" + corpName.trim() + "%'");
		}
		if (duty != null && !"".equals(duty)) {
			sb.append(" and duty = '" + duty + "' ");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and cardID like '" + idCard.trim() + "%'");
		}
		String sql = "select row_number() over(order by createdate desc) as rownumber,personID, name, cardID, sex, entName, duty FROM Position_Certificate"
				+ sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and name like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and entName like '" + corpName.trim() + "%'");
		}
		if (duty != null && !"".equals(duty)) {
			sb.append(" and duty = '" + duty + "' ");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and cardID like '" + idCard.trim() + "%'");
		}
		String sqlCount = "select count(*) from Position_Certificate "
				+ sb.toString();
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

}
