package com.tj.jst.inner.business.surveyapply.model;

public class SurveyQualification {

	private String id;// 主键
	private String surveyId;// 设计主键
	private String cretTypeName;// 资质类型名称
	private String titleLevelName;// 资质等级名称
	private String certId;// 证书编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getCretTypeName() {
		return cretTypeName;
	}

	public void setCretTypeName(String cretTypeName) {
		this.cretTypeName = cretTypeName;
	}

	public String getTitleLevelName() {
		return titleLevelName;
	}

	public void setTitleLevelName(String titleLevelName) {
		this.titleLevelName = titleLevelName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

}
