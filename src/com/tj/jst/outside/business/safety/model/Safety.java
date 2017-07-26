package com.tj.jst.outside.business.safety.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��ȫ�ල
 * @author hhc
 *
 */
public class Safety {

	private String safetyId; //����
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private String prjId;//��Ŀ��������
	private String safetyNum;//��ȫ�ල����
	private Date createDate; //��¼�Ǽ�����
	private String applyCorpCode; //������ҵ��֯��������
	private String applyCorpName; //������ҵ����
	private String appSteffId; //������id
	private String appSteffName; //����������
	private Date appDate; //����ʱ��
	private String appOpinion; //�������
	private Date contractstart;//��ͬ��������
	private Date contractend;//��ͬ��������
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	private List<Upload> list = new ArrayList<Upload>();//����
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
	
	//---------------------------------��ȫ�ල�Ǽ�-------------------------------
	private String oversightNum;//��ȫ�ල�ǼǱ��
	private String projectName;//��������
	private String projectAddress;//���̵ص�
	private Date proStartDate;//��ͬ��������
	private Date proEndDate;//��ͬ��������
	private String projectType;//��������
	private String safetyTarget;//��ȫ������׼������Ŀ��
	private String newlyBuild;//�½�
	private String extend;//������
	private String other;//����
	private String expankj;//����
	//private String safeType;//�½���������������
	private String policingName;//���쵥λȫ��
	private String policingStaff;//���쵥λ��Ŀ������
	private String designName;//��Ƶ�λȫ��
	private String designStaff;//��Ƶ�λ��Ŀ������
	private String buildingName;//���赥λȫ��
	private String buildingStaff;//���赥λ��Ŀ������
	private String buildingPhone;//���赥λ��ϵ�绰
	private String supervisionName;//����λȫ��
	private String contractorCorpCode;//����λ��֯��������
	private String supervisionStaff;//����λ��Ŀ�ܼ�����
	private String supervisionNum;//����λ��Ŀ�ܼ�ע��֤���
	private String supervisionPhone;//����λ��Ŀ�ܼ���ϵ�绰
	private String probationStaff;//����λ��ȫ�ල����
	private String probationPhone;//����λ��ȫ�ල��ϵ�绰
	private String probationNum;//����λ��ȫ�ලע��֤���
	private String probationSafeNum;//����λ��ȫ�ල��ȫ����֤��
	private String contractName;//ʩ���ܳа���λȫ��
	private String contractAdmin;//ʩ���ܳа���λ��˾��ȫ����
	private String contractPhone;//ʩ���ܳа���λ��ϵ�绰
	private String contractStaff;//ʩ���ܳа���λ������
	private String contractSafeNum;//ʩ���ܳа���λ��ȫ����֤��
	private String contractProStaff;//ʩ���ܳа���λ��Ŀ����������
	private String contractProStaffPhone;//ʩ���ܳа���λ��Ŀ��������ϵ�绰
	private String contractStaffRegNum;//ʩ���ܳа���λ��Ŀ������ע��֤��
	private String contractStaffNum;//ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
	// ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
	private List<ConstructionSafety> csList = new ArrayList<ConstructionSafety>();
	
	//---------------------------------��ȫ�ල�Ǽ�(��λ����)-----------------------
	//private String singleNum;//��λ���̱��
	private String unitProject;//��λ����
	private String scale;//������ģ
	private String cost;//�������
	private String structure;//�ṹ/���
	private String height;//�����߶�
	//רҵ�ְ���λ
	private List<Major> majors = new ArrayList<Major>();
	//����ְ�
	private List<Labour> labours = new ArrayList<Labour>();
	private String auCorpName;
	
	public String getSafetyId() {
		return safetyId;
	}
	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
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
//	public String getOversightNum() {
//		return oversightNum;
//	}
//	public void setOversightNum(String oversightNum) {
//		this.oversightNum = oversightNum;
//	}
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
	public Date getProStartDate() {
		return proStartDate;
	}
	public void setProStartDate(Date proStartDate) {
		this.proStartDate = proStartDate;
	}
	public Date getProEndDate() {
		return proEndDate;
	}
	public void setProEndDate(Date proEndDate) {
		this.proEndDate = proEndDate;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getSafetyTarget() {
		return safetyTarget;
	}
	public void setSafetyTarget(String safetyTarget) {
		this.safetyTarget = safetyTarget;
	}
//	public String getSafeType() {
//		return safeType;
//	}
//	public void setSafeType(String safeType) {
//		this.safeType = safeType;
//	}
	public String getPolicingName() {
		return policingName;
	}
	public void setPolicingName(String policingName) {
		this.policingName = policingName;
	}
	public String getPolicingStaff() {
		return policingStaff;
	}
	public void setPolicingStaff(String policingStaff) {
		this.policingStaff = policingStaff;
	}
	public String getDesignName() {
		return designName;
	}
	public void setDesignName(String designName) {
		this.designName = designName;
	}
	public String getDesignStaff() {
		return designStaff;
	}
	public void setDesignStaff(String designStaff) {
		this.designStaff = designStaff;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingStaff() {
		return buildingStaff;
	}
	public void setBuildingStaff(String buildingStaff) {
		this.buildingStaff = buildingStaff;
	}
	public String getBuildingPhone() {
		return buildingPhone;
	}
	public void setBuildingPhone(String buildingPhone) {
		this.buildingPhone = buildingPhone;
	}
	public String getSupervisionName() {
		return supervisionName;
	}
	public void setSupervisionName(String supervisionName) {
		this.supervisionName = supervisionName;
	}
	public String getSupervisionStaff() {
		return supervisionStaff;
	}
	public void setSupervisionStaff(String supervisionStaff) {
		this.supervisionStaff = supervisionStaff;
	}
	public String getSupervisionNum() {
		return supervisionNum;
	}
	public void setSupervisionNum(String supervisionNum) {
		this.supervisionNum = supervisionNum;
	}
	public String getSupervisionPhone() {
		return supervisionPhone;
	}
	public void setSupervisionPhone(String supervisionPhone) {
		this.supervisionPhone = supervisionPhone;
	}
	public String getProbationStaff() {
		return probationStaff;
	}
	public void setProbationStaff(String probationStaff) {
		this.probationStaff = probationStaff;
	}
	public String getProbationPhone() {
		return probationPhone;
	}
	public void setProbationPhone(String probationPhone) {
		this.probationPhone = probationPhone;
	}
	public String getProbationNum() {
		return probationNum;
	}
	public void setProbationNum(String probationNum) {
		this.probationNum = probationNum;
	}
	public String getProbationSafeNum() {
		return probationSafeNum;
	}
	public void setProbationSafeNum(String probationSafeNum) {
		this.probationSafeNum = probationSafeNum;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractAdmin() {
		return contractAdmin;
	}
	public void setContractAdmin(String contractAdmin) {
		this.contractAdmin = contractAdmin;
	}
	public String getContractPhone() {
		return contractPhone;
	}
	public void setContractPhone(String contractPhone) {
		this.contractPhone = contractPhone;
	}
	public String getContractStaff() {
		return contractStaff;
	}
	public void setContractStaff(String contractStaff) {
		this.contractStaff = contractStaff;
	}
	public String getContractSafeNum() {
		return contractSafeNum;
	}
	public void setContractSafeNum(String contractSafeNum) {
		this.contractSafeNum = contractSafeNum;
	}
	public String getContractProStaff() {
		return contractProStaff;
	}
	public void setContractProStaff(String contractProStaff) {
		this.contractProStaff = contractProStaff;
	}
	public String getContractProStaffPhone() {
		return contractProStaffPhone;
	}
	public void setContractProStaffPhone(String contractProStaffPhone) {
		this.contractProStaffPhone = contractProStaffPhone;
	}
	
	public String getContractStaffRegNum() {
		return contractStaffRegNum;
	}
	public void setContractStaffRegNum(String contractStaffRegNum) {
		this.contractStaffRegNum = contractStaffRegNum;
	}
	public String getContractStaffNum() {
		return contractStaffNum;
	}
	public void setContractStaffNum(String contractStaffNum) {
		this.contractStaffNum = contractStaffNum;
	}
	public List<ConstructionSafety> getCsList() {
		return csList;
	}
	public void setCsList(List<ConstructionSafety> csList) {
		this.csList = csList;
	}
//	public String getSingleNum() {
//		return singleNum;
//	}
//	public void setSingleNum(String singleNum) {
//		this.singleNum = singleNum;
//	}
	public String getUnitProject() {
		return unitProject;
	}
	public void setUnitProject(String unitProject) {
		this.unitProject = unitProject;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	public List<Labour> getLabours() {
		return labours;
	}
	public void setLabours(List<Labour> labours) {
		this.labours = labours;
	}
	public String getNewlyBuild() {
		return newlyBuild;
	}
	public void setNewlyBuild(String newlyBuild) {
		this.newlyBuild = newlyBuild;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getOversightNum() {
		return oversightNum;
	}
	public void setOversightNum(String oversightNum) {
		this.oversightNum = oversightNum;
	}

	public String getSafetyNum() {
		return safetyNum;
	}
	public void setSafetyNum(String safetyNum) {
		this.safetyNum = safetyNum;
	}
	public String getAuCorpName() {
		return auCorpName;
	}
	public void setAuCorpName(String auCorpName) {
		this.auCorpName = auCorpName;
	}
	public String getContractorCorpCode() {
		return contractorCorpCode;
	}
	public void setContractorCorpCode(String contractorCorpCode) {
		this.contractorCorpCode = contractorCorpCode;
	}
	public String getExpankj() {
		return expankj;
	}
	public void setExpankj(String expankj) {
		this.expankj = expankj;
	}
	public Date getContractstart() {
		return contractstart;
	}
	public void setContractstart(Date contractstart) {
		this.contractstart = contractstart;
	}
	public Date getContractend() {
		return contractend;
	}
	public void setContractend(Date contractend) {
		this.contractend = contractend;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
 
	
}
