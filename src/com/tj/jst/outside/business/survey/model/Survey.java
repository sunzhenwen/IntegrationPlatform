package com.tj.jst.outside.business.survey.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ����
 * @author hhc
 *
 */
public class Survey {

	private String surveyId; //����
	private String prjNum; //��Ŀ���
	private String surveyNum; //�������
	private String corpName;//���赥λ����
	private String surveyCorpName; //���쵥λ����
	private String surveyCorpCode; //���쵥λ��֯��������
	private String appSteffId; //������id
	private String appSteffName; //����������
	private Date appDate; //����ʱ��
	private String appOpinion; //�������
	private String applyCorpCode; //������ҵ��֯��������
	private Date createDate; //����ʱ��
	private String prjName; //��Ŀ����
	private String prjId; //��Ŀ����������
	private List<Upload> list = new ArrayList<Upload>();//����
	/**
	 * ����״̬
	 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
	 */
	private String appType;//����״̬
	/**
	 * ���̲���
	 * 1:��Ŀ����
	 * 2:����׶Ρ���ƽ׶�
	 * 3:��ͬ������ʩ��ͼ��鱸��
	 * 4:�����ල����ȫ�ල
	 * 5:ʩ�����
	 * 6:��������
	 */
	private String processSteps ;
	private String appDept;//������λid
	private String appDeptName;//������λ����
	private String isUnits;//�Ƿ���д����   0���ǣ�1����
	private List<SurveyQualification> surveyQualis = new ArrayList<SurveyQualification>();
	
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
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
	public String getAppSteffId() {
		return appSteffId;
	}
	public void setAppSteffId(String appSteffId) {
		this.appSteffId = appSteffId;
	}
	public String getAppSteffName() {
		return appSteffName;
	}
	public void setAppSteffName(String appSteffName) {
		this.appSteffName = appSteffName;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getAppOpinion() {
		return appOpinion;
	}
	public void setAppOpinion(String appOpinion) {
		this.appOpinion = appOpinion;
	}
	public String getApplyCorpCode() {
		return applyCorpCode;
	}
	public void setApplyCorpCode(String applyCorpCode) {
		this.applyCorpCode = applyCorpCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getProcessSteps() {
		return processSteps;
	}
	public void setProcessSteps(String processSteps) {
		this.processSteps = processSteps;
	}
	public String getAppDept() {
		return appDept;
	}
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	public String getAppDeptName() {
		return appDeptName;
	}
	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
	}
	public String getIsUnits() {
		return isUnits;
	}
	public void setIsUnits(String isUnits) {
		this.isUnits = isUnits;
	}
	public List<SurveyQualification> getSurveyQualis() {
		return surveyQualis;
	}
	public void setSurveyQualis(List<SurveyQualification> surveyQualis) {
		this.surveyQualis = surveyQualis;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
}
