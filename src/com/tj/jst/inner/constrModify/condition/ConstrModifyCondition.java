package com.tj.jst.inner.constrModify.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目报建修改,主管部门修改
 * 
 * @author hhc
 *
 */
public class ConstrModifyCondition extends Condition {

	// 项目名称
	private String prjName;
	// 立项文号
	private String prjApprovalNum;
	// 建设单位名称
	private String buildCorpName;
	// 建设单位组织机构代码证
	private String buildCorpCode;
	// 审批部门Id
	private String deptId;
	// 审批状态
	private String appType;

	public ConstrModifyCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where  appDept = '" + deptId
				+ "' ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (prjApprovalNum != null && !"".equals(prjApprovalNum)) {
			sb.append(" and prjApprovalNum like '%" + prjApprovalNum.trim()
					+ "%'");
		}
		if (buildCorpName != null && !"".equals(buildCorpName)) {
			sb.append(" and buildCorpName like '%" + buildCorpName.trim()
					+ "%'");
		}
		if (buildCorpCode != null && !"".equals(buildCorpCode)) {
			sb.append(" and buildCorpCode like '%" + buildCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}

		String sql = "select * from TBProjectInfo_S " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 查询当前可用单位；
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where  appDept = '" + deptId
				+ "' ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (prjApprovalNum != null && !"".equals(prjApprovalNum)) {
			sb.append(" and prjApprovalNum like '%" + prjApprovalNum.trim()
					+ "%'");
		}
		if (buildCorpName != null && !"".equals(buildCorpName)) {
			sb.append(" and buildCorpName like '%" + buildCorpName.trim()
					+ "%'");
		}
		if (buildCorpCode != null && !"".equals(buildCorpCode)) {
			sb.append(" and buildCorpCode like '%" + buildCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sqlCount = "select count(*) from TBProjectInfo_S "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
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
