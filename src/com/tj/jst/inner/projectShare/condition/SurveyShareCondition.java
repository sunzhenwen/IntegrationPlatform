package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

public class SurveyShareCondition extends Condition {

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
	// ״̬
	private String appType;

	@Override
	public String getInitialSql() {
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

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

		String sql = "select * from SURVEY_BUSINESS " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

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

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
