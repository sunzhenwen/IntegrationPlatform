package com.tj.jst.outside.business.survey.model;


/**
 * 勘察单位资质
 * @author hhc
 *
 */
public class SurveyQualification {

	private String id;//主键
	private String surveyId;//勘察主键
	private String qualifName;//资质名称
	private String certTypeName;//资质类型
	private String titleLevelName;//资质等级
	private String certId;//证书编号
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCertTypeName() {
		return certTypeName;
	}
	public void setCertTypeName(String certTypeName) {
		this.certTypeName = certTypeName;
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
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getQualifName() {
		return qualifName;
	}
	public void setQualifName(String qualifName) {
		this.qualifName = qualifName;
	}

}
