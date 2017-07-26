package com.tj.jst.inner.integrity.corpGoodIntegrity.condition;

import com.tj.jst.base.page.Condition;

public class CorpGoodIntegrityCondition extends Condition {

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

	public CorpGoodIntegrityCondition() {

	}

	public CorpGoodIntegrityCondition(String deptId) {
		this.deptId = deptId;
	}

	// ��ѯ���
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" createDate desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 and STATUS = 0 ");

		if (personalID != null && !"".equals(personalID)) {
			sb.append(" and rtrim(departId)='" + deptId
					+ "'");
		}
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

		String sql = "select * from tbcorpgoodcreditinfo " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	// ��ѯ�������
	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 and STATUS = 0 ");

		if (personalID != null && !"".equals(personalID)) {
			sb.append(" and rtrim(departId)='" + deptId
					+ "'");
		}
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

		String sqlCount = "select count(*) from tbcorpgoodcreditinfo "
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
	
}
