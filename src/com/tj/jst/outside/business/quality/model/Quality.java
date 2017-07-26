package com.tj.jst.outside.business.quality.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * �����ල
 * 
 * @author hhc
 *
 */
public class Quality {

	private String qualityId; // ����
	private String prjNum; // ��Ŀ���
	private String prjName; // ��Ŀ����
	private String prjId;// ��Ŀ��������
	private String tenderNum;//�б�֪ͨ����
	private String sectionName;//�������
	private String qualityNum;//�����ල����
	private Date createDate; // ��¼�Ǽ�����
	private String applyCorpCode; // ������ҵ��֯��������
	private String applyCorpName; // ������ҵ����
	private String appSteffId; // ������id
	private String appSteffName; // ����������
	private Date appDate; // ����ʱ��
	private String appOpinion; // �������
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	private List<Upload> list = new ArrayList<Upload>();// ����
	/**
	 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
	 */
	private String appType;// ����״̬
	/**
	 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ����� 6:��������
	 */
	private String processSteps;
	private String appDept;// ������λid
	private String appDeptName;// ������λ����

	// ----------------------------------�ſ�---------------------------------
	private String projectName;// ��������
	private String configuration;// �ṹ/����
	private String projectAddress;// ���̵ص�
	private String contact;// ��ϵ��
	private String constructionArea;// �������(ƽ����)
	private String quantities;// ��װ������(��Ԫ)
	private String expensive;// ���������(��Ԫ)
	private String superviseCost;// �ල��(Ԫ)
	private String contractMoney;//��ͬ���
	private Date startDate;// �ƻ���������
	private Date endDate;// �ƻ���������
	private String developmentOrganization;// ���赥λ
	private String developmentQualificationLevel;// ���赥λ���ʵȼ�
	private String developmentCharge;// ���赥λ��Ŀ������
	private String developmentPhone;// ���赥λ��ϵ�绰
	private String surveyUnit;// ���쵥λ
	private String surveyCode;//���쵥λ��֯��������
	private String surveyUnitQualificationLevel;// ���쵥λ���ʵȼ�
	private String surveyUnitCharge;// ���쵥λ��Ŀ������
	private String surveyUnitPhone;// ���쵥λ��ϵ�绰
	private String designUnit;// ��Ƶ�λ
	private String designCode;//��Ƶ�λ��֯��������
	private String designUnitQualificationLevel;// ��Ƶ�λ���ʵȼ�
	private String designUnitCharge;// ��Ƶ�λ��Ŀ������
	private String designUnitPhone;// ��Ƶ�λ��ϵ�绰
	private String supervisionUnit;// ����λ
	private String supervisionUnitQualLevel;// ����λ���ʵȼ�
	private String supervisionUnitEngineer;// �ܼ�����ʦ
	private String supervisionUnitPhone;// ����λ��ϵ�绰
	private String constructionUnit;// ʩ����λ
	private String constructionCode;//ʩ����λ��֯�����Ĵ���
	private String constructionUnitQualLevel;// ʩ����λ���ʵȼ�
	private String constructionUnitProjectManager;// ʩ����λ��Ŀ����
	private String constructionUnitPhone;// ʩ����λ��ϵ�绰
	private String safetyCerId;//ʩ����λ��ȫ�������֤���
	private String constructionPlans;// ʩ��ͼ������
	private String constructionPlansType;// ʩ��ͼ���������
	private String constructionPlansCharge;// ʩ��ͼ��������Ŀ������
	private String constructionPlansPhone;// ʩ��ͼ��������ϵ�绰
	// ----------------------------------�ʱ�����---------------------------------
	private String constructionContractFileNum;// ʩ����ͬ�ļ���
	private String constructionOrganFileNum;// ʩ����֯����ļ���
	private String constructionPlansFileNum;// ʩ��ͼ��鱨�����׼���ļ���
	private String supervisionContractFileNum;// �����ͬ�ļ���
	private String supervisionPlanFileNum;// ����滮�ļ���
	private String fireControlFileNum;// ����������ϸ�����֤���ļ��ļ���
	private String developmentOrganFileNum;// ���赥λ��Ŀ�����˼���Ŀ��������ļ���
	private String onstructionUnitFileNum;// ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
	private String supervisionUnitFileNum;// ����λ��Ŀ�����˼���Ŀ��������ļ���
	private String constructionSiteFileNum;// ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
	private String qualityTestingFileNum;// �������Ա��λ֤���ļ���
	private String fieldSupervisionFileNum;// �ֳ�������Աע��ִҵ֤���ļ���

	private String jianduzhuceNum;// �ලע�����
	private String wenjianNum;// �ļ����
	private String auCorpName;
	

	private String econCorpCode;//���쵥λ��֯��������
	private String designCorpCode;//��Ƶ�λ��֯��������
	private String consCorpCode;//ʩ����λ��֯��������
	private String superCorpCode;//����λ��֯��������
	
	

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
