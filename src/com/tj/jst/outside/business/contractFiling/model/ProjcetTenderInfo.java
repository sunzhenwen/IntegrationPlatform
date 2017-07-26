package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;

/**
 * 合同备案查询招投标信息
 * @author hhc
 *
 */
public class ProjcetTenderInfo {

	private String prjId;
	private String prjName;//项目名称
	private String prjNum;//项目编号
	private String tenderNum;//中标通知书编号
	private String sectionName;//标段名称
	private String projectName;//项目名称
	private String propietorCorpName; //发包单位名称
	private String propietorCorpCode; //发包单位住组织代码
	private String projectAddress;//工程地址
	private String projectCost;//工程造价
	private String tenderMoney;//中标金额
	private String prjSize;//建设规模
	private String area;//面积(平方米)
	private String tenderCorpName;//中标单位名称
	private String tenderCorpCode;//中标单位组织机构代码
	private String unionCorpName; //联合体承包单位名称
	private String unionCorpCode; //联合体承包单位组织代码
	private String constructorName;//项目经理/总监理工程师姓名
	private String idCardTypeNum;//项目经理/总监理工程师证件类型
	private String idCardTypeName;//项目经理/总监理工程师证件类型名称
	private String constructorIdCard;//项目经理/总监理工程师证件号码
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	private String rating;//资质等级
	private String certName;//资质名称
	private String tenderClassName;//招标类型
	private Date createdate;
	
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
	
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
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
	public String getTenderMoney() {
		return tenderMoney;
	}
	public void setTenderMoney(String tenderMoney) {
		this.tenderMoney = tenderMoney;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public String getTenderCorpName() {
		return tenderCorpName;
	}
	public void setTenderCorpName(String tenderCorpName) {
		this.tenderCorpName = tenderCorpName;
	}
	public String getTenderCorpCode() {
		return tenderCorpCode;
	}
	public void setTenderCorpCode(String tenderCorpCode) {
		this.tenderCorpCode = tenderCorpCode;
	}
	public String getConstructorName() {
		return constructorName;
	}
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCardTypeName() {
		return idCardTypeName;
	}
	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}
	public String getConstructorIdCard() {
		return constructorIdCard;
	}
	public void setConstructorIdCard(String constructorIdCard) {
		this.constructorIdCard = constructorIdCard;
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
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getTenderClassName() {
		return tenderClassName;
	}
	public void setTenderClassName(String tenderClassName) {
		this.tenderClassName = tenderClassName;
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
	
}