package com.tj.jst.outside.business.quality.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 质量监督
 * 
 * @author hhc
 *
 */
public class Quality {

	private String qualityId; // 主键
	private String prjNum; // 项目编号
	private String prjName; // 项目名称
	private String prjId;// 项目报建主键
	private String tenderNum;//中标通知书编号
	private String sectionName;//标段名称
	private String qualityNum;//质量监督编码
	private Date createDate; // 记录登记日期
	private String applyCorpCode; // 申请企业组织机构代码
	private String applyCorpName; // 申请企业名称
	private String appSteffId; // 审批人id
	private String appSteffName; // 审批人姓名
	private Date appDate; // 审批时间
	private String appOpinion; // 审批意见
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	private List<Upload> list = new ArrayList<Upload>();// 附件
	/**
	 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
	 */
	private String appType;// 审批状态
	/**
	 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可 6:竣工验收
	 */
	private String processSteps;
	private String appDept;// 审批单位id
	private String appDeptName;// 审批单位名称

	// ----------------------------------概况---------------------------------
	private String projectName;// 工程名称
	private String configuration;// 结构/层数
	private String projectAddress;// 工程地点
	private String contact;// 联系人
	private String constructionArea;// 建设面积(平方米)
	private String quantities;// 安装工程量(万元)
	private String expensive;// 工程总造价(万元)
	private String superviseCost;// 监督费(元)
	private String contractMoney;//合同金额
	private Date startDate;// 计划开工日期
	private Date endDate;// 计划竣工日期
	private String developmentOrganization;// 建设单位
	private String developmentQualificationLevel;// 建设单位资质等级
	private String developmentCharge;// 建设单位项目负责人
	private String developmentPhone;// 建设单位联系电话
	private String surveyUnit;// 勘察单位
	private String surveyCode;//勘察单位组织机构代码
	private String surveyUnitQualificationLevel;// 勘察单位资质等级
	private String surveyUnitCharge;// 勘察单位项目负责人
	private String surveyUnitPhone;// 勘察单位联系电话
	private String designUnit;// 设计单位
	private String designCode;//设计单位组织机构代码
	private String designUnitQualificationLevel;// 设计单位资质等级
	private String designUnitCharge;// 设计单位项目负责人
	private String designUnitPhone;// 设计单位联系电话
	private String supervisionUnit;// 监理单位
	private String supervisionUnitQualLevel;// 监理单位资质等级
	private String supervisionUnitEngineer;// 总监理工程师
	private String supervisionUnitPhone;// 监理单位联系电话
	private String constructionUnit;// 施工单位
	private String constructionCode;//施工单位组织机构改代码
	private String constructionUnitQualLevel;// 施工单位资质等级
	private String constructionUnitProjectManager;// 施工单位项目经理
	private String constructionUnitPhone;// 施工单位联系电话
	private String safetyCerId;//施工单位安全生产许可证编号
	private String constructionPlans;// 施工图审查机构
	private String constructionPlansType;// 施工图审查机构类别
	private String constructionPlansCharge;// 施工图审查机构项目负责人
	private String constructionPlansPhone;// 施工图审查机构联系电话
	// ----------------------------------呈报资料---------------------------------
	private String constructionContractFileNum;// 施工合同文件号
	private String constructionOrganFileNum;// 施工组织设计文件号
	private String constructionPlansFileNum;// 施工图审查报告和批准书文件号
	private String supervisionContractFileNum;// 监理合同文件号
	private String supervisionPlanFileNum;// 监理规划文件号
	private String fireControlFileNum;// 消防设计审查合格书面证明文件文件号
	private String developmentOrganFileNum;// 建设单位项目负责人及项目机构组成文件号
	private String onstructionUnitFileNum;// 施工单位项目负责人及项目机构组成文件号
	private String supervisionUnitFileNum;// 监理单位项目负责人及项目机构组成文件号
	private String constructionSiteFileNum;// 施工现场项目负责人、技术人员资格证书文件号
	private String qualityTestingFileNum;// 质量检查员岗位证书文件号
	private String fieldSupervisionFileNum;// 现场监理人员注册执业证书文件号

	private String jianduzhuceNum;// 监督注册号码
	private String wenjianNum;// 文件编号
	private String auCorpName;
	

	private String econCorpCode;//勘察单位组织机构代码
	private String designCorpCode;//设计单位组织机构代码
	private String consCorpCode;//施工单位组织机构代码
	private String superCorpCode;//监理单位组织机构代码
	
	

	public String getQualityId() {
		return qualityId;
	}

	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}

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

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
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

	public List<Upload> getList() {
		return list;
	}

	public void setList(List<Upload> list) {
		this.list = list;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getConstructionArea() {
		return constructionArea;
	}

	public void setConstructionArea(String constructionArea) {
		this.constructionArea = constructionArea;
	}

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	public String getExpensive() {
		return expensive;
	}

	public void setExpensive(String expensive) {
		this.expensive = expensive;
	}

	public String getSuperviseCost() {
		return superviseCost;
	}

	public void setSuperviseCost(String superviseCost) {
		this.superviseCost = superviseCost;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDevelopmentOrganization() {
		return developmentOrganization;
	}

	public void setDevelopmentOrganization(String developmentOrganization) {
		this.developmentOrganization = developmentOrganization;
	}

	public String getDevelopmentQualificationLevel() {
		return developmentQualificationLevel;
	}

	public void setDevelopmentQualificationLevel(
			String developmentQualificationLevel) {
		this.developmentQualificationLevel = developmentQualificationLevel;
	}

	public String getDevelopmentCharge() {
		return developmentCharge;
	}

	public void setDevelopmentCharge(String developmentCharge) {
		this.developmentCharge = developmentCharge;
	}

	public String getDevelopmentPhone() {
		return developmentPhone;
	}

	public void setDevelopmentPhone(String developmentPhone) {
		this.developmentPhone = developmentPhone;
	}

	public String getSurveyUnit() {
		return surveyUnit;
	}

	public void setSurveyUnit(String surveyUnit) {
		this.surveyUnit = surveyUnit;
	}

	public String getSurveyUnitQualificationLevel() {
		return surveyUnitQualificationLevel;
	}

	public void setSurveyUnitQualificationLevel(
			String surveyUnitQualificationLevel) {
		this.surveyUnitQualificationLevel = surveyUnitQualificationLevel;
	}

	public String getSurveyUnitCharge() {
		return surveyUnitCharge;
	}

	public void setSurveyUnitCharge(String surveyUnitCharge) {
		this.surveyUnitCharge = surveyUnitCharge;
	}

	public String getSurveyUnitPhone() {
		return surveyUnitPhone;
	}

	public void setSurveyUnitPhone(String surveyUnitPhone) {
		this.surveyUnitPhone = surveyUnitPhone;
	}

	public String getDesignUnit() {
		return designUnit;
	}

	public void setDesignUnit(String designUnit) {
		this.designUnit = designUnit;
	}

	public String getDesignUnitQualificationLevel() {
		return designUnitQualificationLevel;
	}

	public void setDesignUnitQualificationLevel(
			String designUnitQualificationLevel) {
		this.designUnitQualificationLevel = designUnitQualificationLevel;
	}

	public String getDesignUnitCharge() {
		return designUnitCharge;
	}

	public void setDesignUnitCharge(String designUnitCharge) {
		this.designUnitCharge = designUnitCharge;
	}

	public String getDesignUnitPhone() {
		return designUnitPhone;
	}

	public void setDesignUnitPhone(String designUnitPhone) {
		this.designUnitPhone = designUnitPhone;
	}

	public String getSupervisionUnit() {
		return supervisionUnit;
	}

	public void setSupervisionUnit(String supervisionUnit) {
		this.supervisionUnit = supervisionUnit;
	}

	public String getSupervisionUnitQualLevel() {
		return supervisionUnitQualLevel;
	}

	public void setSupervisionUnitQualLevel(String supervisionUnitQualLevel) {
		this.supervisionUnitQualLevel = supervisionUnitQualLevel;
	}

	public String getSupervisionUnitEngineer() {
		return supervisionUnitEngineer;
	}

	public void setSupervisionUnitEngineer(String supervisionUnitEngineer) {
		this.supervisionUnitEngineer = supervisionUnitEngineer;
	}

	public String getSupervisionUnitPhone() {
		return supervisionUnitPhone;
	}

	public void setSupervisionUnitPhone(String supervisionUnitPhone) {
		this.supervisionUnitPhone = supervisionUnitPhone;
	}

	public String getConstructionUnit() {
		return constructionUnit;
	}

	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}

	public String getConstructionUnitQualLevel() {
		return constructionUnitQualLevel;
	}

	public void setConstructionUnitQualLevel(String constructionUnitQualLevel) {
		this.constructionUnitQualLevel = constructionUnitQualLevel;
	}

	public String getConstructionUnitProjectManager() {
		return constructionUnitProjectManager;
	}

	public void setConstructionUnitProjectManager(
			String constructionUnitProjectManager) {
		this.constructionUnitProjectManager = constructionUnitProjectManager;
	}

	public String getConstructionUnitPhone() {
		return constructionUnitPhone;
	}

	public void setConstructionUnitPhone(String constructionUnitPhone) {
		this.constructionUnitPhone = constructionUnitPhone;
	}

	public String getConstructionPlans() {
		return constructionPlans;
	}

	public void setConstructionPlans(String constructionPlans) {
		this.constructionPlans = constructionPlans;
	}

	public String getConstructionPlansType() {
		return constructionPlansType;
	}

	public void setConstructionPlansType(String constructionPlansType) {
		this.constructionPlansType = constructionPlansType;
	}

	public String getConstructionPlansCharge() {
		return constructionPlansCharge;
	}

	public void setConstructionPlansCharge(String constructionPlansCharge) {
		this.constructionPlansCharge = constructionPlansCharge;
	}

	public String getConstructionPlansPhone() {
		return constructionPlansPhone;
	}

	public void setConstructionPlansPhone(String constructionPlansPhone) {
		this.constructionPlansPhone = constructionPlansPhone;
	}

	public String getConstructionContractFileNum() {
		return constructionContractFileNum;
	}

	public void setConstructionContractFileNum(
			String constructionContractFileNum) {
		this.constructionContractFileNum = constructionContractFileNum;
	}

	public String getConstructionOrganFileNum() {
		return constructionOrganFileNum;
	}

	public void setConstructionOrganFileNum(String constructionOrganFileNum) {
		this.constructionOrganFileNum = constructionOrganFileNum;
	}

	public String getConstructionPlansFileNum() {
		return constructionPlansFileNum;
	}

	public void setConstructionPlansFileNum(String constructionPlansFileNum) {
		this.constructionPlansFileNum = constructionPlansFileNum;
	}

	public String getSupervisionContractFileNum() {
		return supervisionContractFileNum;
	}

	public void setSupervisionContractFileNum(String supervisionContractFileNum) {
		this.supervisionContractFileNum = supervisionContractFileNum;
	}

	public String getSupervisionPlanFileNum() {
		return supervisionPlanFileNum;
	}

	public void setSupervisionPlanFileNum(String supervisionPlanFileNum) {
		this.supervisionPlanFileNum = supervisionPlanFileNum;
	}

	public String getFireControlFileNum() {
		return fireControlFileNum;
	}

	public void setFireControlFileNum(String fireControlFileNum) {
		this.fireControlFileNum = fireControlFileNum;
	}

	public String getDevelopmentOrganFileNum() {
		return developmentOrganFileNum;
	}

	public void setDevelopmentOrganFileNum(String developmentOrganFileNum) {
		this.developmentOrganFileNum = developmentOrganFileNum;
	}

	public String getOnstructionUnitFileNum() {
		return onstructionUnitFileNum;
	}

	public void setOnstructionUnitFileNum(String onstructionUnitFileNum) {
		this.onstructionUnitFileNum = onstructionUnitFileNum;
	}

	public String getSupervisionUnitFileNum() {
		return supervisionUnitFileNum;
	}

	public void setSupervisionUnitFileNum(String supervisionUnitFileNum) {
		this.supervisionUnitFileNum = supervisionUnitFileNum;
	}

	public String getConstructionSiteFileNum() {
		return constructionSiteFileNum;
	}

	public void setConstructionSiteFileNum(String constructionSiteFileNum) {
		this.constructionSiteFileNum = constructionSiteFileNum;
	}

	public String getQualityTestingFileNum() {
		return qualityTestingFileNum;
	}

	public void setQualityTestingFileNum(String qualityTestingFileNum) {
		this.qualityTestingFileNum = qualityTestingFileNum;
	}

	public String getFieldSupervisionFileNum() {
		return fieldSupervisionFileNum;
	}

	public void setFieldSupervisionFileNum(String fieldSupervisionFileNum) {
		this.fieldSupervisionFileNum = fieldSupervisionFileNum;
	}

	public String getJianduzhuceNum() {
		return jianduzhuceNum;
	}

	public void setJianduzhuceNum(String jianduzhuceNum) {
		this.jianduzhuceNum = jianduzhuceNum;
	}

	public String getWenjianNum() {
		return wenjianNum;
	}

	public void setWenjianNum(String wenjianNum) {
		this.wenjianNum = wenjianNum;
	}

	public String getQualityNum() {
		return qualityNum;
	}

	public void setQualityNum(String qualityNum) {
		this.qualityNum = qualityNum;
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

	public String getSurveyCode() {
		return surveyCode;
	}

	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public String getConstructionCode() {
		return constructionCode;
	}

	public void setConstructionCode(String constructionCode) {
		this.constructionCode = constructionCode;
	}

	public String getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}

	public String getSafetyCerId() {
		return safetyCerId;
	}

	public void setSafetyCerId(String safetyCerId) {
		this.safetyCerId = safetyCerId;
	}

	public String getEconCorpCode() {
		return econCorpCode;
	}

	public void setEconCorpCode(String econCorpCode) {
		this.econCorpCode = econCorpCode;
	}

	public String getDesignCorpCode() {
		return designCorpCode;
	}

	public void setDesignCorpCode(String designCorpCode) {
		this.designCorpCode = designCorpCode;
	}

	public String getConsCorpCode() {
		return consCorpCode;
	}

	public void setConsCorpCode(String consCorpCode) {
		this.consCorpCode = consCorpCode;
	}

	public String getSuperCorpCode() {
		return superCorpCode;
	}

	public void setSuperCorpCode(String superCorpCode) {
		this.superCorpCode = superCorpCode;
	}

	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}

	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}

}
