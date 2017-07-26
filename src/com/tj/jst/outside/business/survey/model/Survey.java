package com.tj.jst.outside.business.survey.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 勘察
 * @author hhc
 *
 */
public class Survey {

	private String surveyId; //主键
	private String prjNum; //项目编号
	private String surveyNum; //勘察编码
	private String corpName;//建设单位名称
	private String surveyCorpName; //勘察单位名称
	private String surveyCorpCode; //勘察单位组织机构代码
	private String appSteffId; //审批人id
	private String appSteffName; //审批人姓名
	private Date appDate; //审批时间
	private String appOpinion; //审批意见
	private String applyCorpCode; //申请企业组织机构代码
	private Date createDate; //申请时间
	private String prjName; //项目名称
	private String prjId; //项目报道见主键
	private List<Upload> list = new ArrayList<Upload>();//附件
	/**
	 * 审批状态
	 * 项目报建：0、申请，1、审批通过，2、审批未通过
	 */
	private String appType;//审批状态
	/**
	 * 流程步骤
	 * 1:项目报建
	 * 2:勘察阶段、设计阶段
	 * 3:合同备案、施工图审查备案
	 * 4:质量监督、安全监督
	 * 5:施工许可
	 * 6:竣工验收
	 */
	private String processSteps ;
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	private String isUnits;//是否填写资质   0：是，1：否
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
