package com.tj.jst.inner.personrecord.position.condition;

import com.tj.jst.base.page.Condition;

public class PositionCondition extends Condition {

	// 人员名称
	private String personName;
	// 证件号码
	private String idCard;
	// 企业名称
	private String corpName;
	// 岗位名称
	private String duty;

	public PositionCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
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
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
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
