package com.tj.jst.outside.business.survey.model;


/**
 * ���쵥λ����
 * @author hhc
 *
 */
public class SurveyQualification {

	private String id;//����
	private String surveyId;//��������
	private String qualifName;//��������
	private String certTypeName;//��������
	private String titleLevelName;//���ʵȼ�
	private String certId;//֤����
	
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
