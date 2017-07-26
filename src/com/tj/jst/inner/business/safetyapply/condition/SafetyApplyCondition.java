package com.tj.jst.inner.business.safetyapply.condition;

import com.tj.jst.base.page.Condition;

/**
 * 安全勘察分页类
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyCondition extends Condition {
	private String appDept;// 查询主键
	private String prjNum;
	private String prjName;
	private String contractName;//施工总承包单位名称
	private String applyCorpName;//申请单位名称

	public SafetyApplyCondition(String appDept) {
		this.appDept = appDept;
	}

	@Override
	public String getInitialSql() {
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(
				" where trim(processSteps)=4 and trim(appType)=0 and appDept = '"
						+ appDept + "'");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (applyCorpName != null && !"".equals(applyCorpName)) {
			sb.append(" and applyCorpName like '%" + applyCorpName.trim() + "%'");
		}
		if (contractName != null && !"".equals(contractName)) {
			sb.append(" and contractName like '%" + contractName.trim() + "%'");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum='" + prjNum.trim() + "'");
		}

		String sql = "select * from TB_SAFETYSUPERVISION " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(
				" where trim(processSteps)=4 and trim(appType)=0 and appDept = '"
						+ appDept + "'");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (applyCorpName != null && !"".equals(applyCorpName)) {
			sb.append(" and applyCorpName like '%" + applyCorpName.trim() + "%'");
		}
		if (contractName != null && !"".equals(contractName)) {
			sb.append(" and contractName like '%" + contractName.trim() + "%'");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum='" + prjNum.trim() + "'");
		}
		String sqlCount = "select count(*) from TB_SAFETYSUPERVISION "
				+ sb.toString();
		return sqlCount;

	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getApplyCorpName() {
		return applyCorpName;
	}

	public void setApplyCorpName(String applyCorpName) {
		this.applyCorpName = applyCorpName;
	}

}
