package com.tj.jst.inner.business.safetyapply.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ȫ�����ҳ��
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyCondition extends Condition {
	private String appDept;// ��ѯ����
	private String prjNum;
	private String prjName;
	private String contractName;//ʩ���ܳа���λ����
	private String applyCorpName;//���뵥λ����

	public SafetyApplyCondition(String appDept) {
		this.appDept = appDept;
	}

	@Override
	public String getInitialSql() {
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
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
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
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
