package com.tj.jst.outside.business.permit.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可
 * @author hhc
 *
 */
public class Permit {

	private String permitId; //主键
	private String tenderNum;//中标通知书编号
	private String sectionName;//标段名称
	private String qualityNum;//质量编码
	private String safetyNum;//安全编码
	private String builderLicenceNum;//施工许可证编号
	private String projectName;//工程名称
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private String buldPlanNum;//建设用地规划许可证编号
	private String projectPlanNum;//建设工程规划许可证编号
	private String censorNum;//施工图审查合格书编号
	private String contractMoney;//合同金额(万元)
	private String area;//面积(平方米)
	private String prjSize;//建设规模
	private Date issueCertDate;//发证日期
	private String econCorpName;//勘察单位名称
	private String econCorpCode;//勘察单位组织机构代码
	private String designCorpName;//设计单位名称
	private String designCorpCode;//设计单位组织机构代码
	private String consCorpname;//施工单位名称
	private String consCorpCode;//施工单位组织机构代码
	private String safetyCerId;//施工单位安全生产许可证编号
	private String superCorpName;//监理单位名称     
	private String superCorpCode;//监理单位组织机构代码
	private String constructorName;//项目经理姓名
	private String cidCardTypeNum;//项目经理证件类型(TBIDCARDTYPEDIC)
	private String constructorIdCard;//项目经理证件号码
	private String supervisionName;//总监理工程师姓名
	private String sidCardTypeNum;//总监理工程师证件类型(TBIDCARDTYPEDIC)
	private String supervisionIdCard;//总监理工程师号码
	private String userName;//安全生产管理人员姓名
	private String idCardTypeNum;//安全生产管理证件类型(TBIDCARDTYPEDIC)
	private String idCard;//安全生产管理人员证件号
	private String certId;//安全生产考核合格证书编号
	private String userType;//安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
	private String auCorpName;
	private Date starDate;//合同开工日期
	private Date endDate;//合同竣工日期
	private String timeLimit;//合同工期(天)
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
	public String getPermitId() {
		return permitId;
	}
	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}
	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}
	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
	}
	public String getBuldPlanNum() {
		return buldPlanNum;
	}
	public void setBuldPlanNum(String buldPlanNum) {
		this.buldPlanNum = buldPlanNum;
	}
	public String getProjectPlanNum() {
		return projectPlanNum;
	}
	public void setProjectPlanNum(String projectPlanNum) {
		this.projectPlanNum = projectPlanNum;
	}
	public String getCensorNum() {
		return censorNum;
	}
	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
	}
	public String getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public Date getIssueCertDate() {
		return issueCertDate;
	}
	public void setIssueCertDate(Date issueCertDate) {
		this.issueCertDate = issueCertDate;
	}
	public String getEconCorpName() {
		return econCorpName;
	}
	public void setEconCorpName(String econCorpName) {
		this.econCorpName = econCorpName;
	}
	public String getEconCorpCode() {
		return econCorpCode;
	}
	public void setEconCorpCode(String econCorpCode) {
		this.econCorpCode = econCorpCode;
	}
	public String getDesignCorpName() {
		return designCorpName;
	}
	public void setDesignCorpName(String designCorpName) {
		this.designCorpName = designCorpName;
	}
	public String getDesignCorpCode() {
		return designCorpCode;
	}
	public void setDesignCorpCode(String designCorpCode) {
		this.designCorpCode = designCorpCode;
	}
	public String getConsCorpname() {
		return consCorpname;
	}
	public void setConsCorpname(String consCorpname) {
		this.consCorpname = consCorpname;
	}
	public String getConsCorpCode() {
		return consCorpCode;
	}
	public void setConsCorpCode(String consCorpCode) {
		this.consCorpCode = consCorpCode;
	}
	public String getSafetyCerId() {
		return safetyCerId;
	}
	public void setSafetyCerId(String safetyCerId) {
		this.safetyCerId = safetyCerId;
	}
	public String getSuperCorpName() {
		return superCorpName;
	}
	public void setSuperCorpName(String superCorpName) {
		this.superCorpName = superCorpName;
	}
	public String getSuperCorpCode() {
		return superCorpCode;
	}
	public void setSuperCorpCode(String superCorpCode) {
		this.superCorpCode = superCorpCode;
	}
	public String getConstructorName() {
		return constructorName;
	}
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}
	public String getCidCardTypeNum() {
		return cidCardTypeNum;
	}
	public void setCidCardTypeNum(String cidCardTypeNum) {
		this.cidCardTypeNum = cidCardTypeNum;
	}
	public String getConstructorIdCard() {
		return constructorIdCard;
	}
	public void setConstructorIdCard(String constructorIdCard) {
		this.constructorIdCard = constructorIdCard;
	}
	public String getSupervisionName() {
		return supervisionName;
	}
	public void setSupervisionName(String supervisionName) {
		this.supervisionName = supervisionName;
	}
	public String getSidCardTypeNum() {
		return sidCardTypeNum;
	}
	public void setSidCardTypeNum(String sidCardTypeNum) {
		this.sidCardTypeNum = sidCardTypeNum;
	}
	public String getSupervisionIdCard() {
		return supervisionIdCard;
	}
	public void setSupervisionIdCard(String supervisionIdCard) {
		this.supervisionIdCard = supervisionIdCard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public Date getStarDate() {
		return starDate;
	}
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getQualityNum() {
		return qualityNum;
	}
	public void setQualityNum(String qualityNum) {
		this.qualityNum = qualityNum;
	}
	public String getSafetyNum() {
		return safetyNum;
	}
	public void setSafetyNum(String safetyNum) {
		this.safetyNum = safetyNum;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
	
}
