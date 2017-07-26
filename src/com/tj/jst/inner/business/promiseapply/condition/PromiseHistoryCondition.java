package com.tj.jst.inner.business.promiseapply.condition;

import com.tj.jst.base.page.Condition;

public class PromiseHistoryCondition extends Condition {
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;
	// 项目名称
	private String prjName;
	// 项目编号
	private String prjNum;
	// 审批部门ID
	private String deptId;
	// 状态
	private String appType;

	public PromiseHistoryCondition(String deptId) {
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
		String sql = "select * from tbbuilderlicencemanage " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
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
		String sqlCount = "select count(*) from tbbuilderlicencemanage "
				+ sb.toString();
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
