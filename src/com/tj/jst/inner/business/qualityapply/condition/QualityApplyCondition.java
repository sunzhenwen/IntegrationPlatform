package com.tj.jst.inner.business.qualityapply.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��������������ҳ��
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyCondition extends Condition {

	private String appDept;// ��ѯ����
	private String prjNum;
	private String prjName;

	public QualityApplyCondition(String appDept) {
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
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}

		String sql = "select * from TB_QUALITYSUPERVISION " + sb.toString();
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
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_QUALITYSUPERVISION "
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

}
