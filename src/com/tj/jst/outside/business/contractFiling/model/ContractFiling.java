package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��ͬ����
 * @author hhc
 *
 */
public class ContractFiling {

	private String recordId; //����
	private String recordNum; //��ͬ�������
	private String mainRecordNum;//�ܰ���ͬ�������(���ڷְ�ʩ�����)
	private String prjNum; //��Ŀ���
	private String prjName;//��Ŀ����
	private String projectAddress;//��Ŀ��ַ
	private String projectCost;//�������
	private String constructorName;//��Ŀ��������
	private String constructorIdCard;//��Ŀ����/�ܼ�����ʦ֤������
	private String constructorNameKC;//��Ŀ��������(����)
	private String constructorNameZCB;//��Ŀ��������(�ܳа�)
	private String constructorNameFB;//��Ŀ��������(�ְ�)
	private String constructorNameLW;//��Ŀ��������(����)
	private String constructorNameXMFZ;//��Ŀ��������(�ܰ���Ŀ������)
	private String constructorNameZSBH;//��Ŀ��������(��Ŀ������֤����)
	private String constructorNameKHBH;//��Ŀ��������(��Ŀ�����˿��˱��)
	private String constructorNameSFZ;//��Ŀ��������(��Ŀ���������֤��)
	private String constructorNamezzry;//�ֳ�רְ��Ա����
	private String constructorNamezzrygw;//�ֳ�רְ��Ա��λ����
	private String constructorNamezzrykh;//�ֳ�רְ��Ա��ȫ���˺���
	private String constructorNamezzrysf;//�ֳ�רְ��Ա���֤��
	private String constructorNamefbdate;//�ְ�֤����Ч��
	private String constructorNamelwdate;//����֤����Ч��
	private String titleLeve;//���ʵȼ�
	private String phone;//��ϵ�绰
	private String phoneJL;//��ϵ�绰(����)
	private String phoneZCB;//��ϵ�绰(�ܳа�)
	private String phoneZFB;//��ϵ�绰(�ְ�)
	private String phoneZLW;//��ϵ�绰(����)
	private String area;//�������
	private String tenderNum;//�б�֪ͨ����
	private String sectionName;//�������
	private String contractNum; //��ͬ���
	private String contractTypeNum; //��ͬ���(TBCONTRACTTYPEDIC)
	private String contractTypeName;//��ͬ�������
	private String contractMoney; //��ͬ���(��Ԫ)
	private String prjSize; //�����ģ
	private Date contractDate; //��ͬǩ������
	private String propietorCorpName; //������λ����
	private String contractorCorpNameKC; //�а���λ����(����)
	private String contractorCorpNameJL; //�а���λ����(����)
	private String contractorCorpNameZCB; //�а���λ����(�ܳа�)
	private String safetyCerId;//ʩ����λ��ȫ�������֤���
	private String contractorCorpNameFB; //�а���λ����(�ְ�)
	private String contractorCorpNameLW; //�а���λ����(����)
	private String propietorCorpCode; //������λס��֯����
	private String contractorCorpName; //�а���λ����
	private String contractorCorpCode; //�а���λ��֯����
	private String unionCorpName; //������а���λ����
	private String unionCorpCode; //������а���λ��֯����
	private Date createDate; //��¼�Ǽ�ʱ��
	private String applyCorpCode;//������ҵ��֯��������
	private String applyCorpName;//������ҵ����
	private String appSteffId; //������id
	private String appSteffName; //����������
	private Date appDate; //����ʱ��
	private String appOpinion; //�������
	private List<Upload> list = new ArrayList<Upload>();//����
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	/**
	 * ����״̬
	 * ��Ŀ������3������  0�����룬1������ͨ����2������δͨ��
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
	private String processSteps;
	private String appDept;//������λid
	private String appDeptName;//������λ����
	private String auCorpCode;//����Ȩ��ҵ��֯��������
	private String auCorpName;//����Ȩ��ҵ����
	private String qualificationsType;//�����ʸ�����
	private String specialtyType;//רҵ���
	private String rating;//�����ʸ�ȼ�
	private String qualificationsTypeName;//�����ʸ���������
	private String specialtyTypeName;//רҵ�������
	private String ratingName;//�����ʸ�ȼ�����
	private String contrType;//1:�н�  2:���ķ��� 3:ʩ���ְ� 4:ʩ������
	private Date contractStart;//��ͬ��������
	private Date contractEnd;//��ͬ��������
	private List<FileWorld> worldList = new ArrayList<FileWorld>();//ʩ����ͬword
	
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
	
	//--------------------------------------��������ʹ��---------------------------------
	private String surveyCorpName;//���쵥λ����
	private String surveyTitleLeve;//���쵥λ���ʵȼ�
	private String surveyConstructorName;//���쵥λ��Ŀ������
	private String surveyPhone;//���쵥λ��ϵ�绰
	
	private String designCorpName;//��Ƶ�λ����
	private String designTitleLeve;//��Ƶ�λ���ʵȼ�
	private String designConstructorName;//��Ƶ�λ��Ŀ������
	private String designPhone;//��Ƶ�λ��ϵ�绰
	
	private String supervisorCorpName;//����λ����
	private String supervisorTitleLeve;//����λ���ʵȼ�
	private String supervisorConstructorName;//����λ��Ŀ������
	private String supervisorPhone;//����λ��ϵ�绰
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
