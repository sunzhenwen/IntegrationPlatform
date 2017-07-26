package com.tj.jst.inner.business.readyapply.condition;

import com.tj.jst.base.page.Condition;

public class ReadyHistoryCondition extends Condition {

	private String deptId;// 查询主键
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	// 项目名称
	private String prjName;
	// 项目编号
	private String prjNum;
	// 状态
	private String appType;

	public ReadyHistoryCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where  APPDEPT = '" + deptId
				+ "'  ");

		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and CREATEDATE >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and CREATEDATE <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sql = "select * from TBPROJECTFINISHMANAGE " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where  APPDEPT = '" + deptId
				+ "'  ");

		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and CREATEDATE >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and CREATEDATE <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sqlCount = "select count(*) from TBPROJECTFINISHMANAGE "
				+ sb.toString();
		return sqlCount;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
