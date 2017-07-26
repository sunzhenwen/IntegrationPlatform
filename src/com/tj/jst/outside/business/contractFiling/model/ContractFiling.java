package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 合同备案
 * @author hhc
 *
 */
public class ContractFiling {

	private String recordId; //主键
	private String recordNum; //合同备案编号
	private String mainRecordNum;//总包合同备案编号(用于分包施工外键)
	private String prjNum; //项目编号
	private String prjName;//项目名称
	private String projectAddress;//项目地址
	private String projectCost;//工程造价
	private String constructorName;//项目经理姓名
	private String constructorIdCard;//项目经理/总监理工程师证件号码
	private String constructorNameKC;//项目经理姓名(勘察)
	private String constructorNameZCB;//项目经理姓名(总承包)
	private String constructorNameFB;//项目经理姓名(分包)
	private String constructorNameLW;//项目经理姓名(劳务)
	private String constructorNameXMFZ;//项目经理姓名(总包项目负责人)
	private String constructorNameZSBH;//项目经理姓名(项目负责人证书编号)
	private String constructorNameKHBH;//项目经理姓名(项目负责人考核编号)
	private String constructorNameSFZ;//项目经理姓名(项目负责人身份证号)
	private String constructorNamezzry;//现场专职人员姓名
	private String constructorNamezzrygw;//现场专职人员岗位号码
	private String constructorNamezzrykh;//现场专职人员安全考核号码
	private String constructorNamezzrysf;//现场专职人员身份证号
	private String constructorNamefbdate;//分包证件有效期
	private String constructorNamelwdate;//劳务证件有效期
	private String titleLeve;//资质等级
	private String phone;//联系电话
	private String phoneJL;//联系电话(监理)
	private String phoneZCB;//联系电话(总承包)
	private String phoneZFB;//联系电话(分包)
	private String phoneZLW;//联系电话(劳务)
	private String area;//建筑面积
	private String tenderNum;//中标通知书编号
	private String sectionName;//标段名称
	private String contractNum; //合同编号
	private String contractTypeNum; //合同类别(TBCONTRACTTYPEDIC)
	private String contractTypeName;//合同类别名称
	private String contractMoney; //合同金额(万元)
	private String prjSize; //建设规模
	private Date contractDate; //合同签订日期
	private String propietorCorpName; //发包单位名称
	private String contractorCorpNameKC; //承包单位名称(勘察)
	private String contractorCorpNameJL; //承包单位名称(监理)
	private String contractorCorpNameZCB; //承包单位名称(总承包)
	private String safetyCerId;//施工单位安全生产许可证编号
	private String contractorCorpNameFB; //承包单位名称(分包)
	private String contractorCorpNameLW; //承包单位名称(劳务)
	private String propietorCorpCode; //发包单位住组织代码
	private String contractorCorpName; //承包单位名称
	private String contractorCorpCode; //承包单位组织代码
	private String unionCorpName; //联合体承包单位名称
	private String unionCorpCode; //联合体承包单位组织代码
	private Date createDate; //记录登记时间
	private String applyCorpCode;//申请企业组织机构代码
	private String applyCorpName;//申请企业名称
	private String appSteffId; //审批人id
	private String appSteffName; //审批人姓名
	private Date appDate; //审批时间
	private String appOpinion; //审批意见
	private List<Upload> list = new ArrayList<Upload>();//附件
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	/**
	 * 审批状态
	 * 项目报建：3、保存  0、申请，1、审批通过，2、审批未通过
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
	private String auCorpCode;//被授权企业组织机构代码
	private String auCorpName;//被授权企业名称
	private String qualificationsType;//资质资格类型
	private String specialtyType;//专业类别
	private String rating;//资质资格等级
	private String qualificationsTypeName;//资质资格类型名称
	private String specialtyTypeName;//专业类别名称
	private String ratingName;//资质资格等级名称
	private String contrType;//1:市建  2:发改法规 3:施工分包 4:施工劳务
	private Date contractStart;//合同开工日期
	private Date contractEnd;//合同竣工日期
	private List<FileWorld> worldList = new ArrayList<FileWorld>();//施工合同word
	
//-------------------------------人员-----------------------------------	
	private String technicalName;//技术负责人姓名
	private String technicalIdCardTypeNum;//技术负责人证件类型
	private String technicalIdCard;//技术负责人证件号码
	private String technicalCertNum;//技术负责人证书号
	private String qualityName;//质量检查员姓名
	private String qualityIdCardTypeNum;//质量检查员证件类型
	private String qualityIdCard;//质量检查员证件号码
	private String qualityCertNum;//质量检查员证书号
	private String securityName;//安全员姓名
	private String securityIdCardTypeNum;//安全员证件类型
	private String securityIdCard;//安全员证件号码
	private String securityCertNum;//安全员证书号
	private String constructionName;//施工员（工长）姓名
	private String constructionIdCardTypeNum;//施工员（工长）证件类型
	private String constructionIdCard;//施工员（工长）证件号码
	private String constructionCertNum;//施工员（工长）证书号
	private String directorName;//（监理人员）总监姓名
	private String directorIdCardTypeNum;//（监理人员）总监证件类型
	private String directorIdCard;//（监理人员）总监证件号码
	private String directorCertNum;//（监理人员）总监证书号
	private String represEntativeName;//总监代表姓名
	private String represEntativeIdCardTypeNum;//总监代表证件类型
	private String represEntativeIdCard;//总监代表证件号码
	private String represEntativeCertNum;//总监代表证书号
	private String safetyName;//安全监理姓名
	private String safetyIdCardTypeNum;//安全监理证件类型
	private String safetyIdCard;//安全监理证件号码
	
	//--------------------------------------质量关联使用---------------------------------
	private String surveyCorpName;//勘察单位名称
	private String surveyTitleLeve;//勘察单位资质等级
	private String surveyConstructorName;//勘察单位项目负责人
	private String surveyPhone;//勘察单位联系电话
	
	private String designCorpName;//设计单位名称
	private String designTitleLeve;//设计单位资质等级
	private String designConstructorName;//设计单位项目负责人
	private String designPhone;//设计单位联系电话
	
	private String supervisorCorpName;//监理单位名称
	private String supervisorTitleLeve;//监理单位资质等级
	private String supervisorConstructorName;//监理单位项目负责人
	private String supervisorPhone;//监理单位联系电话
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getContractTypeNum() {
		return contractTypeNum;
	}
	public void setContractTypeNum(String contractTypeNum) {
		this.contractTypeNum = contractTypeNum;
	}
	public String getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	public String getPropietorCorpName() {
		return propietorCorpName;
	}
	public void setPropietorCorpName(String propietorCorpName) {
		this.propietorCorpName = propietorCorpName;
	}
	public String getPropietorCorpCode() {
		return propietorCorpCode;
	}
	public void setPropietorCorpCode(String propietorCorpCode) {
		this.propietorCorpCode = propietorCorpCode;
	}
	public String getContractorCorpName() {
		return contractorCorpName;
	}
	public void setContractorCorpName(String contractorCorpName) {
		this.contractorCorpName = contractorCorpName;
	}
	public String getContractorCorpCode() {
		return contractorCorpCode;
	}
	public void setContractorCorpCode(String contractorCorpCode) {
		this.contractorCorpCode = contractorCorpCode;
	}
	public String getUnionCorpName() {
		return unionCorpName;
	}
	public void setUnionCorpName(String unionCorpName) {
		this.unionCorpName = unionCorpName;
	}
	public String getUnionCorpCode() {
		return unionCorpCode;
	}
	public void setUnionCorpCode(String unionCorpCode) {
		this.unionCorpCode = unionCorpCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContractTypeName() {
		return contractTypeName;
	}
	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
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
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
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
	public String getAuCorpCode() {
		return auCorpCode;
	}
	public void setAuCorpCode(String auCorpCode) {
		this.auCorpCode = auCorpCode;
	}
	public String getAuCorpName() {
		return auCorpName;
	}
	public void setAuCorpName(String auCorpName) {
		this.auCorpName = auCorpName;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(String projectCost) {
		this.projectCost = projectCost;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getConstructorName() {
		return constructorName;
	}
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}
	public String getTitleLeve() {
		return titleLeve;
	}
	public void setTitleLeve(String titleLeve) {
		this.titleLeve = titleLeve;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQualificationsType() {
		return qualificationsType;
	}
	public void setQualificationsType(String qualificationsType) {
		this.qualificationsType = qualificationsType;
	}
	public String getSpecialtyType() {
		return specialtyType;
	}
	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getQualificationsTypeName() {
		return qualificationsTypeName;
	}
	public void setQualificationsTypeName(String qualificationsTypeName) {
		this.qualificationsTypeName = qualificationsTypeName;
	}
	public String getSpecialtyTypeName() {
		return specialtyTypeName;
	}
	public void setSpecialtyTypeName(String specialtyTypeName) {
		this.specialtyTypeName = specialtyTypeName;
	}
	public String getRatingName() {
		return ratingName;
	}
	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}
	public String getSurveyCorpName() {
		return surveyCorpName;
	}
	public void setSurveyCorpName(String surveyCorpName) {
		this.surveyCorpName = surveyCorpName;
	}
	public String getSurveyTitleLeve() {
		return surveyTitleLeve;
	}
	public void setSurveyTitleLeve(String surveyTitleLeve) {
		this.surveyTitleLeve = surveyTitleLeve;
	}
	public String getSurveyConstructorName() {
		return surveyConstructorName;
	}
	public void setSurveyConstructorName(String surveyConstructorName) {
		this.surveyConstructorName = surveyConstructorName;
	}
	public String getSurveyPhone() {
		return surveyPhone;
	}
	public void setSurveyPhone(String surveyPhone) {
		this.surveyPhone = surveyPhone;
	}
	public String getDesignCorpName() {
		return designCorpName;
	}
	public void setDesignCorpName(String designCorpName) {
		this.designCorpName = designCorpName;
	}
	public String getDesignTitleLeve() {
		return designTitleLeve;
	}
	public void setDesignTitleLeve(String designTitleLeve) {
		this.designTitleLeve = designTitleLeve;
	}
	public String getDesignConstructorName() {
		return designConstructorName;
	}
	public void setDesignConstructorName(String designConstructorName) {
		this.designConstructorName = designConstructorName;
	}
	public String getDesignPhone() {
		return designPhone;
	}
	public void setDesignPhone(String designPhone) {
		this.designPhone = designPhone;
	}
	public String getSupervisorCorpName() {
		return supervisorCorpName;
	}
	public void setSupervisorCorpName(String supervisorCorpName) {
		this.supervisorCorpName = supervisorCorpName;
	}
	public String getSupervisorTitleLeve() {
		return supervisorTitleLeve;
	}
	public void setSupervisorTitleLeve(String supervisorTitleLeve) {
		this.supervisorTitleLeve = supervisorTitleLeve;
	}
	public String getSupervisorConstructorName() {
		return supervisorConstructorName;
	}
	public void setSupervisorConstructorName(String supervisorConstructorName) {
		this.supervisorConstructorName = supervisorConstructorName;
	}
	public String getSupervisorPhone() {
		return supervisorPhone;
	}
	public void setSupervisorPhone(String supervisorPhone) {
		this.supervisorPhone = supervisorPhone;
	}
	public String getContrType() {
		return contrType;
	}
	public void setContrType(String contrType) {
		this.contrType = contrType;
	}
	public String getTechnicalName() {
		return technicalName;
	}
	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}
	public String getTechnicalIdCardTypeNum() {
		return technicalIdCardTypeNum;
	}
	public void setTechnicalIdCardTypeNum(String technicalIdCardTypeNum) {
		this.technicalIdCardTypeNum = technicalIdCardTypeNum;
	}
	public String getTechnicalIdCard() {
		return technicalIdCard;
	}
	public void setTechnicalIdCard(String technicalIdCard) {
		this.technicalIdCard = technicalIdCard;
	}
	public String getTechnicalCertNum() {
		return technicalCertNum;
	}
	public void setTechnicalCertNum(String technicalCertNum) {
		this.technicalCertNum = technicalCertNum;
	}
	public String getQualityName() {
		return qualityName;
	}
	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}
	public String getQualityIdCardTypeNum() {
		return qualityIdCardTypeNum;
	}
	public void setQualityIdCardTypeNum(String qualityIdCardTypeNum) {
		this.qualityIdCardTypeNum = qualityIdCardTypeNum;
	}
	public String getQualityIdCard() {
		return qualityIdCard;
	}
	public void setQualityIdCard(String qualityIdCard) {
		this.qualityIdCard = qualityIdCard;
	}
	public String getQualityCertNum() {
		return qualityCertNum;
	}
	public void setQualityCertNum(String qualityCertNum) {
		this.qualityCertNum = qualityCertNum;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getSecurityIdCardTypeNum() {
		return securityIdCardTypeNum;
	}
	public void setSecurityIdCardTypeNum(String securityIdCardTypeNum) {
		this.securityIdCardTypeNum = securityIdCardTypeNum;
	}
	public String getSecurityIdCard() {
		return securityIdCard;
	}
	public void setSecurityIdCard(String securityIdCard) {
		this.securityIdCard = securityIdCard;
	}
	
	public String getSecurityCertNum() {
		return securityCertNum;
	}
	public void setSecurityCertNum(String securityCertNum) {
		this.securityCertNum = securityCertNum;
	}
	public String getConstructionName() {
		return constructionName;
	}
	public void setConstructionName(String constructionName) {
		this.constructionName = constructionName;
	}
	public String getConstructionIdCardTypeNum() {
		return constructionIdCardTypeNum;
	}
	public void setConstructionIdCardTypeNum(String constructionIdCardTypeNum) {
		this.constructionIdCardTypeNum = constructionIdCardTypeNum;
	}
	public String getConstructionIdCard() {
		return constructionIdCard;
	}
	public void setConstructionIdCard(String constructionIdCard) {
		this.constructionIdCard = constructionIdCard;
	}
	public String getConstructionCertNum() {
		return constructionCertNum;
	}
	public void setConstructionCertNum(String constructionCertNum) {
		this.constructionCertNum = constructionCertNum;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getDirectorIdCardTypeNum() {
		return directorIdCardTypeNum;
	}
	public void setDirectorIdCardTypeNum(String directorIdCardTypeNum) {
		this.directorIdCardTypeNum = directorIdCardTypeNum;
	}
	public String getDirectorIdCard() {
		return directorIdCard;
	}
	public void setDirectorIdCard(String directorIdCard) {
		this.directorIdCard = directorIdCard;
	}
	public String getDirectorCertNum() {
		return directorCertNum;
	}
	public void setDirectorCertNum(String directorCertNum) {
		this.directorCertNum = directorCertNum;
	}
	public String getRepresEntativeName() {
		return represEntativeName;
	}
	public void setRepresEntativeName(String represEntativeName) {
		this.represEntativeName = represEntativeName;
	}
	public String getRepresEntativeIdCardTypeNum() {
		return represEntativeIdCardTypeNum;
	}
	public void setRepresEntativeIdCardTypeNum(String represEntativeIdCardTypeNum) {
		this.represEntativeIdCardTypeNum = represEntativeIdCardTypeNum;
	}
	public String getRepresEntativeIdCard() {
		return represEntativeIdCard;
	}
	public void setRepresEntativeIdCard(String represEntativeIdCard) {
		this.represEntativeIdCard = represEntativeIdCard;
	}
	public String getRepresEntativeCertNum() {
		return represEntativeCertNum;
	}
	public void setRepresEntativeCertNum(String represEntativeCertNum) {
		this.represEntativeCertNum = represEntativeCertNum;
	}
	public String getSafetyName() {
		return safetyName;
	}
	public void setSafetyName(String safetyName) {
		this.safetyName = safetyName;
	}
	public String getSafetyIdCardTypeNum() {
		return safetyIdCardTypeNum;
	}
	public void setSafetyIdCardTypeNum(String safetyIdCardTypeNum) {
		this.safetyIdCardTypeNum = safetyIdCardTypeNum;
	}
	public String getSafetyIdCard() {
		return safetyIdCard;
	}
	public void setSafetyIdCard(String safetyIdCard) {
		this.safetyIdCard = safetyIdCard;
	}
	public String getMainRecordNum() {
		return mainRecordNum;
	}
	public void setMainRecordNum(String mainRecordNum) {
		this.mainRecordNum = mainRecordNum;
	}
	public List<FileWorld> getWorldList() {
		return worldList;
	}
	public void setWorldList(List<FileWorld> worldList) {
		this.worldList = worldList;
	}
	public String getConstructorNameKC() {
		return constructorNameKC;
	}
	public void setConstructorNameKC(String constructorNameKC) {
		this.constructorNameKC = constructorNameKC;
	}
	public String getConstructorNameZCB() {
		return constructorNameZCB;
	}
	public void setConstructorNameZCB(String constructorNameZCB) {
		this.constructorNameZCB = constructorNameZCB;
	}
	public String getConstructorNameFB() {
		return constructorNameFB;
	}
	public void setConstructorNameFB(String constructorNameFB) {
		this.constructorNameFB = constructorNameFB;
	}
	public String getConstructorNameLW() {
		return constructorNameLW;
	}
	public void setConstructorNameLW(String constructorNameLW) {
		this.constructorNameLW = constructorNameLW;
	}
	public String getPhoneJL() {
		return phoneJL;
	}
	public void setPhoneJL(String phoneJL) {
		this.phoneJL = phoneJL;
	}
	public String getPhoneZCB() {
		return phoneZCB;
	}
	public void setPhoneZCB(String phoneZCB) {
		this.phoneZCB = phoneZCB;
	}
	public String getPhoneZFB() {
		return phoneZFB;
	}
	public void setPhoneZFB(String phoneZFB) {
		this.phoneZFB = phoneZFB;
	}
	public String getPhoneZLW() {
		return phoneZLW;
	}
	public void setPhoneZLW(String phoneZLW) {
		this.phoneZLW = phoneZLW;
	}
	public String getContractorCorpNameKC() {
		return contractorCorpNameKC;
	}
	public void setContractorCorpNameKC(String contractorCorpNameKC) {
		this.contractorCorpNameKC = contractorCorpNameKC;
	}
	public String getContractorCorpNameJL() {
		return contractorCorpNameJL;
	}
	public void setContractorCorpNameJL(String contractorCorpNameJL) {
		this.contractorCorpNameJL = contractorCorpNameJL;
	}
	public String getContractorCorpNameZCB() {
		return contractorCorpNameZCB;
	}
	public void setContractorCorpNameZCB(String contractorCorpNameZCB) {
		this.contractorCorpNameZCB = contractorCorpNameZCB;
	}
	public String getContractorCorpNameFB() {
		return contractorCorpNameFB;
	}
	public void setContractorCorpNameFB(String contractorCorpNameFB) {
		this.contractorCorpNameFB = contractorCorpNameFB;
	}
	public String getContractorCorpNameLW() {
		return contractorCorpNameLW;
	}
	public void setContractorCorpNameLW(String contractorCorpNameLW) {
		this.contractorCorpNameLW = contractorCorpNameLW;
	}
	public String getSafetyCerId() {
		return safetyCerId;
	}
	public void setSafetyCerId(String safetyCerId) {
		this.safetyCerId = safetyCerId;
	}
	public String getConstructorIdCard() {
		return constructorIdCard;
	}
	public void setConstructorIdCard(String constructorIdCard) {
		this.constructorIdCard = constructorIdCard;
	}
	public String getConstructorNameXMFZ() {
		return constructorNameXMFZ;
	}
	public void setConstructorNameXMFZ(String constructorNameXMFZ) {
		this.constructorNameXMFZ = constructorNameXMFZ;
	}
	public String getConstructorNameZSBH() {
		return constructorNameZSBH;
	}
	public void setConstructorNameZSBH(String constructorNameZSBH) {
		this.constructorNameZSBH = constructorNameZSBH;
	}
	public String getConstructorNameKHBH() {
		return constructorNameKHBH;
	}
	public void setConstructorNameKHBH(String constructorNameKHBH) {
		this.constructorNameKHBH = constructorNameKHBH;
	}
	public String getConstructorNameSFZ() {
		return constructorNameSFZ;
	}
	public void setConstructorNameSFZ(String constructorNameSFZ) {
		this.constructorNameSFZ = constructorNameSFZ;
	}
	public String getConstructorNamezzry() {
		return constructorNamezzry;
	}
	public void setConstructorNamezzry(String constructorNamezzry) {
		this.constructorNamezzry = constructorNamezzry;
	}
	public String getConstructorNamezzrygw() {
		return constructorNamezzrygw;
	}
	public void setConstructorNamezzrygw(String constructorNamezzrygw) {
		this.constructorNamezzrygw = constructorNamezzrygw;
	}
	public String getConstructorNamezzrykh() {
		return constructorNamezzrykh;
	}
	public void setConstructorNamezzrykh(String constructorNamezzrykh) {
		this.constructorNamezzrykh = constructorNamezzrykh;
	}
	public String getConstructorNamezzrysf() {
		return constructorNamezzrysf;
	}
	public void setConstructorNamezzrysf(String constructorNamezzrysf) {
		this.constructorNamezzrysf = constructorNamezzrysf;
	}
	public String getConstructorNamefbdate() {
		return constructorNamefbdate;
	}
	public void setConstructorNamefbdate(String constructorNamefbdate) {
		this.constructorNamefbdate = constructorNamefbdate;
	}
	public String getConstructorNamelwdate() {
		return constructorNamelwdate;
	}
	public void setConstructorNamelwdate(String constructorNamelwdate) {
		this.constructorNamelwdate = constructorNamelwdate;
	}
	public Date getContractStart() {
		return contractStart;
	}
	public void setContractStart(Date contractStart) {
		this.contractStart = contractStart;
	}
	public Date getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(Date contractEnd) {
		this.contractEnd = contractEnd;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
	
	
}
