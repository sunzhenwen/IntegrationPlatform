package com.tj.jst.inner.business.surveyapply.condition;

import com.tj.jst.base.page.Condition;

public class SurveyHistoryCondition extends Condition {

	// ��Ŀ����
	private String prjName;
	// ��Ŀ���
	private String prjNum;
	// �������
	private String surveyNum;
	// ���칫˾����
	private String surveyCorpName;
	// ���칫˾��֯��������֤
	private String surveyCorpCode;
	// ��������Id
	private String deptId;
	// ״̬
	private String appType;

	public SurveyHistoryCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where  appDept = '" + deptId
				+ "' ");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (surveyNum != null && !"".equals(surveyNum)) {
			sb.append(" and surveyNum like '%" + surveyNum.trim() + "%'");
		}
		if (surveyCorpName != null && !"".equals(surveyCorpName)) {
			sb.append(" and surveyCorpName like '%" + surveyCorpName.trim()
					+ "%'");
		}
		if (surveyCorpCode != null && !"".equals(surveyCorpCode)) {
			sb.append(" and surveyCorpCode like '%" + surveyCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}

		String sql = "select * from SURVEY_BUSINESS " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where appDept = '" + deptId + "' ");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (surveyNum != null && !"".equals(surveyNum)) {
			sb.append(" and surveyNum like '%" + surveyNum.trim() + "%'");
		}
		if (surveyCorpName != null && !"".equals(surveyCorpName)) {
			sb.append(" and surveyCorpName like '%" + surveyCorpName.trim()
					+ "%'");
		}
		if (surveyCorpCode != null && !"".equals(surveyCorpCode)) {
			sb.append(" and surveyCorpCode like '%" + surveyCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sqlCount = "select count(*) from SURVEY_BUSINESS "
				+ sb.toString();
		return sqlCount;
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

	public String getSurveyNum() {
		return surveyNum;
	}

	public void setSurveyNum(String surveyNum) {
		this.surveyNum = surveyNum;
	}

	public String getSurveyCorpName() {
		return surveyCorpName;
	}

	public void setSurveyCorpName(String surveyCorpName) {
		this.surveyCorpName = surveyCorpName;
	}

	public String getSurveyCorpCode() {
		return surveyCorpCode;
	}

	public void setSurveyCorpCode(String surveyCorpCode) {
		this.surveyCorpCode = surveyCorpCode;
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
