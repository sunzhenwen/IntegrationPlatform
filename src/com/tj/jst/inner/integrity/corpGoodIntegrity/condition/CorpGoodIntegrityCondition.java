package com.tj.jst.inner.integrity.corpGoodIntegrity.condition;

import com.tj.jst.base.page.Condition;

public class CorpGoodIntegrityCondition extends Condition {

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

	public CorpGoodIntegrityCondition() {

	}

	public CorpGoodIntegrityCondition(String deptId) {
		this.deptId = deptId;
	}

	// 查询语句
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" createDate desc ");
		// 查询当前可用单位；
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

	// 查询数量语句
	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 查询当前可用单位；
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
