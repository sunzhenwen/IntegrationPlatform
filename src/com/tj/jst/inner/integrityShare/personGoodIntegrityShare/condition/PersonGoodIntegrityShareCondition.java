package com.tj.jst.inner.integrityShare.personGoodIntegrityShare.condition;

import com.tj.jst.base.page.Condition;

public class PersonGoodIntegrityShareCondition extends Condition {

	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	// 企业名称
	private String corpName;
	// 部门Id
	private String deptId;
	// 人员Id
	private String personalID;
	// 人员名称
	private String personName;
	// 证件号码
	private String idCard18;

	public PersonGoodIntegrityShareCondition() {

	}

	public PersonGoodIntegrityShareCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" createDate desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 and STATUS = 0");

//		if (personalID != null && !"".equals(personalID)) {
//			sb.append(" and rtrim(departId)='" + deptId
//					+ "'");
//		}
		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and createDate >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and createDate <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personName like '%" + personName.trim() + "%'");
		}
		if (idCard18 != null && !"".equals(idCard18)) {
			sb.append(" and idCard18 like '%" + idCard18.trim() + "%'");
		}

		String sql = "select * from tbregpersongoodcreditinfo " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1=1 and STATUS = 0");

//		if (personalID != null && !"".equals(personalID)) {
//			sb.append(" and rtrim(departId)='" + deptId
//					+ "'");
//		}
		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and createDate >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and createDate <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '%" + corpName.trim() + "%'");
		}
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personName like '%" + personName.trim() + "%'");
		}
		if (idCard18 != null && !"".equals(idCard18)) {
			sb.append(" and idCard18 like '%" + idCard18.trim() + "%'");
		}

		String sqlCount = "select count(*) from tbregpersongoodcreditinfo "
				+ sb.toString();
		System.out.println("sqlConty = " + sqlCount);
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

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdCard18() {
		return idCard18;
	}

	public void setIdCard18(String idCard18) {
		this.idCard18 = idCard18;
	}

}
