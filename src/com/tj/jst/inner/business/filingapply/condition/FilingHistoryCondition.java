package com.tj.jst.inner.business.filingapply.condition;

import com.tj.jst.base.page.Condition;

public class FilingHistoryCondition extends Condition {

	private String appDept;// 查询条件
	private String prjName;// 项目名称
	private String prjNum;// 项目编号
	private String contractNum;// 合同编号
	private String contractTypeName;// 类型名称
	private String appType;//状态

	public FilingHistoryCondition(String appDept) {
		this.appDept = appDept;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where APPDEPT = '" + appDept + "'");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (contractNum != null && !"".equals(contractNum)) {
			sb.append(" and contractNum ='" + contractNum.trim() + "'");
		}
		if (contractTypeName != null && !"".equals(contractTypeName)) {
			sb.append(" and contractTypeName ='" + contractTypeName.trim()
					+ "'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype = '" + appType.trim() + "'");
		}else
		{
			sb.append(" and apptype != 3");
		}
		String sql = "select * from v_zgbm_tbcontractrecordmanage " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where APPDEPT = '" + appDept + "'");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (contractNum != null && !"".equals(contractNum)) {
			sb.append(" and contractNum ='" + contractNum.trim() + "'");
		}
		if (contractTypeName != null && !"".equals(contractTypeName)) {
			sb.append(" and contractTypeName ='" + contractTypeName.trim()
					+ "'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype = '" + appType.trim() + "'");
		}else
		{
			sb.append(" and apptype != 3");
		}
		String sqlCount = "select count(*) from v_zgbm_tbcontractrecordmanage "
				+ sb.toString();
		return sqlCount;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
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

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
