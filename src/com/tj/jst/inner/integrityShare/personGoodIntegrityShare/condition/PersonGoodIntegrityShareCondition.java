package com.tj.jst.inner.integrityShare.personGoodIntegrityShare.condition;

import com.tj.jst.base.page.Condition;

public class PersonGoodIntegrityShareCondition extends Condition {

	// ��ʼʱ��
	private String startDate;
	// ����ʱ��
	private String endDate;
	// ��ҵ����
	private String corpName;
	// ����Id
	private String deptId;
	// ��ԱId
	private String personalID;
	// ��Ա����
	private String personName;
	// ֤������
	private String idCard18;

	public PersonGoodIntegrityShareCondition() {

	}

	public PersonGoodIntegrityShareCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" createDate desc ");
		// ��ѯ��ǰ���õ�λ��
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
		// ��ѯ��ǰ���õ�λ��
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
