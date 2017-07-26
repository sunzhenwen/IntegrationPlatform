package com.tj.jst.inner.business.planapply.condition;

import com.tj.jst.base.page.Condition;

public class PlanHistoryCondition extends Condition {
	private String prjName; // 项目名称
	private String censorCorpName; // 施工图审查机构名称
	private String censorCorpCode; // 施工图审查机构组织机构代码
	private String appDept;// 审批单位id
	private String appType;// 状态

	public PlanHistoryCondition(String appDept) {
		this.appDept = appDept;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where  appDept = '" + appDept
				+ "'");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (censorCorpName != null && !"".equals(censorCorpName)) {
			sb.append(" and censorCorpName like '%" + censorCorpName.trim()
					+ "%'");
		}
		if (censorCorpCode != null && !"".equals(censorCorpCode)) {
			sb.append(" and censorCorpCode='" + censorCorpCode.trim() + "'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}

		String sql = "select * from TBPROJECTCENSORINFO " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where appDept = '" + appDept + "'");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (censorCorpName != null && !"".equals(censorCorpName)) {
			sb.append(" and censorCorpName like '%" + censorCorpName.trim()
					+ "%'");
		}
		if (censorCorpCode != null && !"".equals(censorCorpCode)) {
			sb.append(" and censorCorpCode='" + censorCorpCode.trim() + "'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sqlCount = "select count(*) from TBPROJECTCENSORINFO "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getCensorCorpName() {
		return censorCorpName;
	}

	public void setCensorCorpName(String censorCorpName) {
		this.censorCorpName = censorCorpName;
	}

	public String getCensorCorpCode() {
		return censorCorpCode;
	}

	public void setCensorCorpCode(String censorCorpCode) {
		this.censorCorpCode = censorCorpCode;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
