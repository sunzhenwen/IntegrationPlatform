package com.tj.jst.outside.business.safety.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 安全监督
 * @author hhc
 *
 */
public class Safety {

	private String safetyId; //主键
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private String prjId;//项目报建主键
	private String safetyNum;//安全监督编码
	private Date createDate; //记录登记日期
	private String applyCorpCode; //申请企业组织机构代码
	private String applyCorpName; //申请企业名称
	private String appSteffId; //审批人id
	private String appSteffName; //审批人姓名
	private Date appDate; //审批时间
	private String appOpinion; //审批意见
	private Date contractstart;//合同开工日期
	private Date contractend;//合同竣工日期
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	private List<Upload> list = new ArrayList<Upload>();//附件
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
	
	//---------------------------------安全监督登记-------------------------------
	private String oversightNum;//安全监督登记编号
	private String projectName;//工程名称
	private String projectAddress;//工程地点
	private Date proStartDate;//合同开工日期
	private Date proEndDate;//合同竣工日期
	private String projectType;//工程类型
	private String safetyTarget;//安全生产标准化创建目标
	private String newlyBuild;//新建
	private String extend;//改扩建
	private String other;//其它
	private String expankj;//扩建
	//private String safeType;//新建、改扩建、其它
	private String policingName;//勘察单位全称
	private String policingStaff;//勘察单位项目负责人
	private String designName;//设计单位全称
	private String designStaff;//设计单位项目负责人
	private String buildingName;//建设单位全称
	private String buildingStaff;//建设单位项目负责人
	private String buildingPhone;//建设单位联系电话
	private String supervisionName;//监理单位全称
	private String contractorCorpCode;//监理单位组织机构代码
	private String supervisionStaff;//监理单位项目总监姓名
	private String supervisionNum;//监理单位项目总监注册证书号
	private String supervisionPhone;//监理单位项目总监联系电话
	private String probationStaff;//监理单位安全监督姓名
	private String probationPhone;//监理单位安全监督联系电话
	private String probationNum;//监理单位安全监督注册证书号
	private String probationSafeNum;//监理单位安全监督安全监理证号
	private String contractName;//施工总承包单位全称
	private String contractAdmin;//施工总承包单位公司安全管理
	private String contractPhone;//施工总承包单位联系电话
	private String contractStaff;//施工总承包单位负责人
	private String contractSafeNum;//施工总承包单位安全考核证号
	private String contractProStaff;//施工总承包单位项目负责人姓名
	private String contractProStaffPhone;//施工总承包单位项目负责人联系电话
	private String contractStaffRegNum;//施工总承包单位项目负责人注册证号
	private String contractStaffNum;//施工总承包单位项目负责人安全考核证号
	// 施工总承包单位现场专职安全管理人员
	private List<ConstructionSafety> csList = new ArrayList<ConstructionSafety>();
	
	//---------------------------------安全监督登记(单位工程)-----------------------
	//private String singleNum;//单位工程编号
	private String unitProject;//单位工程
	private String scale;//建筑规模
	private String cost;//工程造价
	private String structure;//结构/层次
	private String height;//建筑高度
	//专业分包单位
	private List<Major> majors = new ArrayList<Major>();
	//劳务分包
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
