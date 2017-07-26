package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

/**
 * 施工图审查查询
 * @author DarkFlameMaster
 *
 */
public class PlanShareCondition extends Condition {

	private String prjName; // 项目名称
	private String censorCorpName; // 施工图审查机构名称
	private String censorCorpCode; // 施工图审查机构组织机构代码
	private String appDept;// 审批单位id
	private String appType;// 状态

	@Override
	public String getInitialSql() {
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

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

		String sql = "select * from TBPROJECTCENSORINFO " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

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
