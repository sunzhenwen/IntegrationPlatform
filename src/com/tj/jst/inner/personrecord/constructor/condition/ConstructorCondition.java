package com.tj.jst.inner.personrecord.constructor.condition;

import com.tj.jst.base.page.Condition;

public class ConstructorCondition extends Condition {

	// 人员名称
	private String personName;
	// 证件号码
	private String idCard;
	// 学历
	private String eduLevelNum;
	// 学位
	private String degreeNum;
	// 企业id
	private String corpId;
	// 公司名称
	private String corpName;

	public ConstructorCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 ");

		if (corpId != null && !"".equals(corpId)) {
			sb.append(" and corpId like '" + corpId.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '" + corpName.trim() + "%'");
		}
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personName like '" + personName.trim() + "%'");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and idCard like '" + idCard.trim() + "%'");
		}
		if (eduLevelNum != null && !"".equals(eduLevelNum)) {
			sb.append(" and EDULEVELNUM = '"
					+ Integer.parseInt(eduLevelNum.trim()) + "'");
		}
		if (degreeNum != null && !"".equals(degreeNum)) {
			sb.append(" and DEGREENUM = '" + Integer.parseInt(degreeNum.trim())
					+ "'");
		}

		String sql = "select * from V_CONSTRUCTOR" + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 设置排序
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 ");

		if (corpId != null && !"".equals(corpId)) {
			sb.append(" and corpId like '" + corpId.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '" + corpName.trim() + "%'");
		}
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personName like '" + personName.trim() + "%'");
		}
		if (idCard != null && !"".equals(idCard)) {
			sb.append(" and idCard like '" + idCard.trim() + "%'");
		}
		if (eduLevelNum != null && !"".equals(eduLevelNum)) {
			sb.append(" and EDULEVELNUM = '"
					+ Integer.parseInt(eduLevelNum.trim()) + "'");
		}
		if (degreeNum != null && !"".equals(degreeNum)) {
			sb.append(" and DEGREENUM = '" + Integer.parseInt(degreeNum.trim())
					+ "'");
		}
		String sqlCount = "select count(*) from V_CONSTRUCTOR " + sb.toString();
		System.out.println("sqlCount = " + sqlCount);
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

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
