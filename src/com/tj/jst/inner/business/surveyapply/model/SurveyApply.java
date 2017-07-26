package com.tj.jst.inner.business.surveyapply.model;

import java.sql.Date;

/**
 * 勘察model类
 * 
 * @author DarkFlameMaster
 *
 */
public class SurveyApply {
	private String surveyId;// 主键
	private String prjNum;// 项目编号
	private String prjName;// 项目名称
	private String surveyNum;// 勘察编码
	private String surveyCorpName;// 勘察单位名称
	private String surveyCorpCode;// 勘察单位组织机构代码证
	private String appSteffId;// 审批人Id
	private String appSteffName;// 审批人姓名
	private Date appDate;// 审批时间
	private String appOpinion;// 审批意见
	private String appType;// 审批状态
	private String processSteps;// 流程
	private String applyCorpCode;// 申请企业组织机构代码证
	private Date createDate;// 撞见日期
	private String appDept;// 审批单位Id
	private String appDeptName;// 审批单位名称
	private String unitMark;// 判断是否为单位工程

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

	public String getUnitMark() {
		return unitMark;
	}

	public void setUnitMark(String unitMark) {
		this.unitMark = unitMark;
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

}
