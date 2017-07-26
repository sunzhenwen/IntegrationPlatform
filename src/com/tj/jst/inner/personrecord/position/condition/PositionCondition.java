package com.tj.jst.inner.personrecord.position.condition;

import com.tj.jst.base.page.Condition;

public class PositionCondition extends Condition {

	// ��Ա����
	private String personName;
	// ֤������
	private String idCard;
	// ��ҵ����
	private String corpName;
	// ��λ����
	private String duty;

	public PositionCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where FIsDeleted=0 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and FName like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and FEntName like '" + corpName.trim() + "%'");
		}
		if (duty != null && !"".equals(duty)) {
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and FCardID like '" + idCard.trim() + "%'");
		}
		String sql = "select row_number() over(order by FRegDate desc) as rownumber,fPersonID, FName, FCardID, FSex, FEntName, FDuty FROM Position_Certificate"
				+ sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where FIsDeleted=0 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and FName like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and FEntName like '" + corpName.trim() + "%'");
		}
		if (duty != null && !"".equals(duty)) {
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and FCardID like '" + idCard.trim() + "%'");
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
