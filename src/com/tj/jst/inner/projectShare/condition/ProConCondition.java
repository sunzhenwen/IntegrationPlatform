package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʷ��ѯ��ҳ����
 * 
 * @author DarkFlameMaster
 *
 */
public class ProConCondition extends Condition {

	// ��Ŀ����
	private String prjName;
	// �����ĺ�
	private String prjApprovalNum;
	// ���赥λ����
	private String buildCorpName;
	// ���赥λ��֯��������֤
	private String buildCorpCode;
	// ����״̬
	private String appType;
	//�����б���
	private String approvalCityId;
	//�����������
	private String approvalAreaId;
	
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
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


		String sql = "select * from TBProjectInfo_S " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��ѯ��ǰ���õ�λ��
		this.setOrderByItem(" CREATEDATE desc ");
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
