package com.tj.jst.outside.business.permit.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class Permit {

	private String permitId; //����
	private String tenderNum;//�б�֪ͨ����
	private String sectionName;//�������
	private String qualityNum;//��������
	private String safetyNum;//��ȫ����
	private String builderLicenceNum;//ʩ�����֤���
	private String projectName;//��������
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private String buldPlanNum;//�����õع滮���֤���
	private String projectPlanNum;//���蹤�̹滮���֤���
	private String censorNum;//ʩ��ͼ���ϸ�����
	private String contractMoney;//��ͬ���(��Ԫ)
	private String area;//���(ƽ����)
	private String prjSize;//�����ģ
	private Date issueCertDate;//��֤����
	private String econCorpName;//���쵥λ����
	private String econCorpCode;//���쵥λ��֯��������
	private String designCorpName;//��Ƶ�λ����
	private String designCorpCode;//��Ƶ�λ��֯��������
	private String consCorpname;//ʩ����λ����
	private String consCorpCode;//ʩ����λ��֯��������
	private String safetyCerId;//ʩ����λ��ȫ�������֤���
	private String superCorpName;//����λ����     
	private String superCorpCode;//����λ��֯��������
	private String constructorName;//��Ŀ��������
	private String cidCardTypeNum;//��Ŀ����֤������(TBIDCARDTYPEDIC)
	private String constructorIdCard;//��Ŀ����֤������
	private String supervisionName;//�ܼ�����ʦ����
	private String sidCardTypeNum;//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
	private String supervisionIdCard;//�ܼ�����ʦ����
	private String userName;//��ȫ����������Ա����
	private String idCardTypeNum;//��ȫ��������֤������(TBIDCARDTYPEDIC)
	private String idCard;//��ȫ����������Ա֤����
	private String certId;//��ȫ�������˺ϸ�֤����
	private String userType;//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
	private String auCorpName;
	private Date starDate;//��ͬ��������
	private Date endDate;//��ͬ��������
	private String timeLimit;//��ͬ����(��)
	private String prjId;//��Ŀ��������
	private Date createDate; //��¼�Ǽ�����
	private String applyCorpCode; //������ҵ��֯��������
	private String applyCorpName; //������ҵ����
	private String appSteffId; //������id
	private String appSteffName; //����������
	private Date appDate; //����ʱ��
	private String appOpinion; //�������
	private List<Upload> list = new ArrayList<Upload>();//����
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	/**
	 * ����״̬
	 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
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
