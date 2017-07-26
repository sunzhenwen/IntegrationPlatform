package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;

/**
 * ��ͬ������ѯ��Ͷ����Ϣ
 * @author hhc
 *
 */
public class ProjcetTenderInfo {

	private String prjId;
	private String prjName;//��Ŀ����
	private String prjNum;//��Ŀ���
	private String tenderNum;//�б�֪ͨ����
	private String sectionName;//�������
	private String projectName;//��Ŀ����
	private String propietorCorpName; //������λ����
	private String propietorCorpCode; //������λס��֯����
	private String projectAddress;//���̵�ַ
	private String projectCost;//�������
	private String tenderMoney;//�б���
	private String prjSize;//�����ģ
	private String area;//���(ƽ����)
	private String tenderCorpName;//�б굥λ����
	private String tenderCorpCode;//�б굥λ��֯��������
	private String unionCorpName; //������а���λ����
	private String unionCorpCode; //������а���λ��֯����
	private String constructorName;//��Ŀ����/�ܼ�����ʦ����
	private String idCardTypeNum;//��Ŀ����/�ܼ�����ʦ֤������
	private String idCardTypeName;//��Ŀ����/�ܼ�����ʦ֤����������
	private String constructorIdCard;//��Ŀ����/�ܼ�����ʦ֤������
	private String appDept;//������λid
	private String appDeptName;//������λ����
	private String rating;//���ʵȼ�
	private String certName;//��������
	private String tenderClassName;//�б�����
	private Date createdate;
	
	//-------------------------------��Ա-----------------------------------	
	private String technicalName;//��������������
	private String technicalIdCardTypeNum;//����������֤������
	private String technicalIdCard;//����������֤������
	private String technicalCertNum;//����������֤���
	private String qualityName;//�������Ա����
	private String qualityIdCardTypeNum;//�������Ա֤������
	private String qualityIdCard;//�������Ա֤������
	private String qualityCertNum;//�������Ա֤���
	private String securityName;//��ȫԱ����
	private String securityIdCardTypeNum;//��ȫԱ֤������
	private String securityIdCard;//��ȫԱ֤������
	private String securityCertNum;//��ȫԱ֤���
	private String constructionName;//ʩ��Ա������������
	private String constructionIdCardTypeNum;//ʩ��Ա��������֤������
	private String constructionIdCard;//ʩ��Ա��������֤������
	private String constructionCertNum;//ʩ��Ա��������֤���
	private String directorName;//��������Ա���ܼ�����
	private String directorIdCardTypeNum;//��������Ա���ܼ�֤������
	private String directorIdCard;//��������Ա���ܼ�֤������
	private String directorCertNum;//��������Ա���ܼ�֤���
	private String represEntativeName;//�ܼ��������
	private String represEntativeIdCardTypeNum;//�ܼ����֤������
	private String represEntativeIdCard;//�ܼ����֤������
	private String represEntativeCertNum;//�ܼ����֤���
	private String safetyName;//��ȫ��������
	private String safetyIdCardTypeNum;//��ȫ����֤������
	private String safetyIdCard;//��ȫ����֤������
	
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