package com.tj.jst.outside.business.complete.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 竣工验收
 * @author hhc
 *
 */
public class Complete {

	private String completeId; //主键
	private String prjFinishNum;//竣工备案编号
	private String prjNum;//项目编号
	private String prjName;//项目名称
	private String tenderNum;//中标通知书编号
	private String sectionName;//施工许可证名称

	private String projectName;//工程名称
	private String builderLicenceNum;//施工许可证编号
	private String qcCorpName;//质量检测机构名称
	private String qcCorpCode;//质量检测机构组织机构代码
	private String factCost;//实际造价(万元)
	private String factArea;//实际面积(平方米)
	private String factSize;//实际建设规模
	private String prjStructureTypeNum;//结构体系(TBPRJSTRUCTURETYPEDIC)
	private Date BDate;//实际开工日期
	private Date EDate;//实际竣工验收日期
	private String mark;//备注
	
	
	private String prjId;//项目报建主键
	private Date createDate; //记录登记日期
	private String applyCorpCode; //申请企业组织机构代码
	private String applyCorpName; //申请企业名称
	private String appSteffId; //审批人id
	private String appSteffName; //审批人姓名
	private Date appDate; //审批时间
	private String appOpinion; //审批意见
	private List<Upload> list = new ArrayList<Upload>();//附件
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
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
	private String processSteps;
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	private String auCorpName;
	
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getApplyCorpCode() {
		return applyCorpCode;
	}
	public void setApplyCorpCode(String applyCorpCode) {
		this.applyCorpCode = applyCorpCode;
	}
	public String getApplyCorpName() {
		return applyCorpName;
	}
	public void setApplyCorpName(String applyCorpName) {
		this.applyCorpName = applyCorpName;
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
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}
	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
	}
	public String getCompleteId() {
		return completeId;
	}
	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}
	public String getPrjFinishNum() {
		return prjFinishNum;
	}
	public void setPrjFinishNum(String prjFinishNum) {
		this.prjFinishNum = prjFinishNum;
	}
	public String getQcCorpName() {
		return qcCorpName;
	}
	public void setQcCorpName(String qcCorpName) {
		this.qcCorpName = qcCorpName;
	}
	public String getQcCorpCode() {
		return qcCorpCode;
	}
	public void setQcCorpCode(String qcCorpCode) {
		this.qcCorpCode = qcCorpCode;
	}
	public String getFactCost() {
		return factCost;
	}
	public void setFactCost(String factCost) {
		this.factCost = factCost;
	}
	public String getFactArea() {
		return factArea;
	}
	public void setFactArea(String factArea) {
		this.factArea = factArea;
	}
	public String getFactSize() {
		return factSize;
	}
	public void setFactSize(String factSize) {
		this.factSize = factSize;
	}
	public String getPrjStructureTypeNum() {
		return prjStructureTypeNum;
	}
	public void setPrjStructureTypeNum(String prjStructureTypeNum) {
		this.prjStructureTypeNum = prjStructureTypeNum;
	}
	public Date getBDate() {
		return BDate;
	}
	public void setBDate(Date bDate) {
		BDate = bDate;
	}
	public Date getEDate() {
		return EDate;
	}
	public void setEDate(Date eDate) {
		EDate = eDate;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAuCorpName() {
		return auCorpName;
	}
	public void setAuCorpName(String auCorpName) {
		this.auCorpName = auCorpName;
	}
	public String getTenderNum() {
		return tenderNum;
	}
	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
}
