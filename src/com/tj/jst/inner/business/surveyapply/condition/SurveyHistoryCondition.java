package com.tj.jst.inner.business.surveyapply.condition;

import com.tj.jst.base.page.Condition;

public class SurveyHistoryCondition extends Condition {

	// 项目名称
	private String prjName;
	// 项目编号
	private String prjNum;
	// 勘察编码
	private String surveyNum;
	// 勘察公司名称
	private String surveyCorpName;
	// 勘察公司组织机构代码证
	private String surveyCorpCode;
	// 审批部门Id
	private String deptId;
	// 状态
	private String appType;

	public SurveyHistoryCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
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
