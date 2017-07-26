package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

/**
 * �����ල
 * @author DarkFlameMaster
 *
 */
public class QualityShareCondition extends Condition {

	private String appDept;// ��ѯ����
	private String prjNum;
	private String prjName;
	private String appType;
	//�����б���
	private String approvalCityId;
	//�����������
	private String approvalAreaId;
	
	@Override
	public String getInitialSql() {
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
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
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getApprovalCityId() {
		return approvalCityId;
	}

	public void setApprovalCityId(String approvalCityId) {
		this.approvalCityId = approvalCityId;
	}

	public String getApprovalAreaId() {
		return approvalAreaId;
	}

	public void setApprovalAreaId(String approvalAreaId) {
		this.approvalAreaId = approvalAreaId;
	}

}
