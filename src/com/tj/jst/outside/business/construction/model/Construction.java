package com.tj.jst.outside.business.construction.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;



/**
 * 项目报建
 * @author hhc
 *
 */
public class Construction {

	private String prjId; //主键
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private String corpId;//企业主键
	private String corpName;//企业名称
	private String corpCode;//企业组织机构代码
	private String otherPrjId;//外省备案项目主键
	private String prjTypeNum; //项目分类(字典表：TBPRJTYPEDIC)
	private String prjTypeName;//项目分类名称
	private String buildCorpName; //建设单位名称
	private String buildCorpCode; //建设单位组织机构代码
	private String provinceNum; //项目所在省(字典表：TBXZQDMDIC)
	private String provinceName;//项目所在省名称
	private String cityNum; //项目所在市(字典表：TBXZQDMDIC)
	private String cityName;//项目所在市名称
	private String countyNum; //项目所在区县(字典表：TBXZQDMDIC)
	private String countyName;//项目所在区县名称
	private String prjApprovalNum; //立项文号
	private String prjApprovalLevelNum; //立项级别
	private String prjApprovalLevelName;//立项级别名称
	private String buldPlanNum; //建设用地规划许可证编号
	private String projectPlanNum; //建设工程规划许可证编号
	private String allInvest; //总投资（万元）
	private String allArea; //总面积（平方米）
	private String prjSize; //建设规模
	private String prjPropertyNum; //建设性质(字典表：TBPRJPROPERTYDIC)
	private String prjPropertyName;//建设性质名称
	private String prjFuncitonNum; //工程用途(字典表：TBPRJFUNCTIONDIC)
	private String prjFuncitonName;//工程用途名称
	private Date BDate; //开工日期；竣工备案环节为M
	private Date EDate; //竣工验收日期；竣工备案环节为M
	private Date createDate; //记录登记时间
	private String address;//建设地址
	private String projectManager;//建设单位项目负责人
	private String unitPhone;//建设单位联系电话
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	private List<Accessory> accessoryLists = new ArrayList<Accessory>();//附件提示信息
	private List<Upload> list = new ArrayList<Upload>();//附件
	private List<ProjectPerson> staffList = new ArrayList<ProjectPerson>();//外省项目备案下的人员信息
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
	private String processSteps ;
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	
	
	//------------------------------------------设计-------------------------------------------
	private String designId;//设计主键
	private String designNum;//设计编码
	private String designCorpName;//设计单位名称
	private String designCorpCode;//设计单位组织机构代码
	private String designApptype;//设计审批状态
	private String designProcessSteps;//设计流程步骤
	private Date designCreateDate;//设计申请时间
	private String designAppDept;//设计申请审批部门
	private String designAppDeptName;//设计申请审批部门名称
	private String designIsUnits;//设计单位是否填写资质 0:是 1:否
	private String designApplyCorpCode;//申请企业组织机构代码

	
	//------------------------------------------勘察-------------------------------------------
	private String surveyId;//勘察主键
	private String surveyNum;//勘察编码
	private String surveyCorpName;//勘察单位名称
	private String surveyCorpCode;//勘察单位组织机构代码
	private String surveyApptype;//勘察审批状态
	private String surveyProcessSteps;//勘察流程步骤
	private Date surveyCreateDate;//勘察申请时间
	private String surveyAppDept;//勘察申请审批部门
	private String surveyAppDeptName;//勘察申请审批部门名称
	private String surveyIsUnits;//勘察单位是否填写资质 0:是 1:否
	private String surveyApplyCorpCode;//申请企业组织机构代码
	
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
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
	public String getPrjTypeNum() {
		return prjTypeNum;
	}
	public void setPrjTypeNum(String prjTypeNum) {
		this.prjTypeNum = prjTypeNum;
	}
	public String getBuildCorpName() {
		return buildCorpName;
	}
	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}
	public String getBuildCorpCode() {
		return buildCorpCode;
	}
	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}
	public String getProvinceNum() {
		return provinceNum;
	}
	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}
	public String getCityNum() {
		return cityNum;
	}
	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
	public String getCountyNum() {
		return countyNum;
	}
	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}
	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}
	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}
	public String getPrjApprovalLevelNum() {
		return prjApprovalLevelNum;
	}
	public void setPrjApprovalLevelNum(String prjApprovalLevelNum) {
		this.prjApprovalLevelNum = prjApprovalLevelNum;
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
	public String getAllInvest() {
		return allInvest;
	}
	public void setAllInvest(String allInvest) {
		this.allInvest = allInvest;
	}
	public String getAllArea() {
		return allArea;
	}
	public void setAllArea(String allArea) {
		this.allArea = allArea;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public String getPrjPropertyNum() {
		return prjPropertyNum;
	}
	public void setPrjPropertyNum(String prjPropertyNum) {
		this.prjPropertyNum = prjPropertyNum;
	}
	public String getPrjFuncitonNum() {
		return prjFuncitonNum;
	}
	public void setPrjFuncitonNum(String prjFuncitonNum) {
		this.prjFuncitonNum = prjFuncitonNum;
	}
	public Date getBDate() {
		return BDate;
	}
	public void setBDate(Date bDate) {
		BDate = bDate;
	}
	public Date getEDate() {
		return EDate;
	}
	public void setEDate(Date eDate) {
		EDate = eDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public String getPrjTypeName() {
		return prjTypeName;
	}
	public void setPrjTypeName(String prjTypeName) {
		this.prjTypeName = prjTypeName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	public String getDesignId() {
		return designId;
	}
	public void setDesignId(String designId) {
		this.designId = designId;
	}
	public String getDesignNum() {
		return designNum;
	}
	public void setDesignNum(String designNum) {
		this.designNum = designNum;
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
	public String getDesignApptype() {
		return designApptype;
	}
	public void setDesignApptype(String designApptype) {
		this.designApptype = designApptype;
	}
	public String getDesignProcessSteps() {
		return designProcessSteps;
	}
	public void setDesignProcessSteps(String designProcessSteps) {
		this.designProcessSteps = designProcessSteps;
	}
	public Date getDesignCreateDate() {
		return designCreateDate;
	}
	public void setDesignCreateDate(Date designCreateDate) {
		this.designCreateDate = designCreateDate;
	}
	public String getDesignAppDept() {
		return designAppDept;
	}
	public void setDesignAppDept(String designAppDept) {
		this.designAppDept = designAppDept;
	}
	public String getDesignAppDeptName() {
		return designAppDeptName;
	}
	public void setDesignAppDeptName(String designAppDeptName) {
		this.designAppDeptName = designAppDeptName;
	}
	public String getDesignIsUnits() {
		return designIsUnits;
	}
	public void setDesignIsUnits(String designIsUnits) {
		this.designIsUnits = designIsUnits;
	}
	public String getDesignApplyCorpCode() {
		return designApplyCorpCode;
	}
	public void setDesignApplyCorpCode(String designApplyCorpCode) {
		this.designApplyCorpCode = designApplyCorpCode;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyNum() {
		return surveyNum;
	}
	public void setSurveyNum(String surveyNum) {
		this.surveyNum = surveyNum;
	}
	public String getSurveyCorpName() {
		return surveyCorpName;
	}
	public void setSurveyCorpName(String surveyCorpName) {
		this.surveyCorpName = surveyCorpName;
	}
	public String getSurveyCorpCode() {
		return surveyCorpCode;
	}
	public void setSurveyCorpCode(String surveyCorpCode) {
		this.surveyCorpCode = surveyCorpCode;
	}
	public String getSurveyApptype() {
		return surveyApptype;
	}
	public void setSurveyApptype(String surveyApptype) {
		this.surveyApptype = surveyApptype;
	}
	public String getSurveyProcessSteps() {
		return surveyProcessSteps;
	}
	public void setSurveyProcessSteps(String surveyProcessSteps) {
		this.surveyProcessSteps = surveyProcessSteps;
	}
	public Date getSurveyCreateDate() {
		return surveyCreateDate;
	}
	public void setSurveyCreateDate(Date surveyCreateDate) {
		this.surveyCreateDate = surveyCreateDate;
	}
	public String getSurveyAppDept() {
		return surveyAppDept;
	}
	public void setSurveyAppDept(String surveyAppDept) {
		this.surveyAppDept = surveyAppDept;
	}
	public String getSurveyAppDeptName() {
		return surveyAppDeptName;
	}
	public void setSurveyAppDeptName(String surveyAppDeptName) {
		this.surveyAppDeptName = surveyAppDeptName;
	}
	public String getSurveyIsUnits() {
		return surveyIsUnits;
	}
	public void setSurveyIsUnits(String surveyIsUnits) {
		this.surveyIsUnits = surveyIsUnits;
	}
	public String getSurveyApplyCorpCode() {
		return surveyApplyCorpCode;
	}
	public void setSurveyApplyCorpCode(String surveyApplyCorpCode) {
		this.surveyApplyCorpCode = surveyApplyCorpCode;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrjApprovalLevelName() {
		return prjApprovalLevelName;
	}
	public void setPrjApprovalLevelName(String prjApprovalLevelName) {
		this.prjApprovalLevelName = prjApprovalLevelName;
	}
	public String getPrjPropertyName() {
		return prjPropertyName;
	}
	public void setPrjPropertyName(String prjPropertyName) {
		this.prjPropertyName = prjPropertyName;
	}
	public String getPrjFuncitonName() {
		return prjFuncitonName;
	}
	public void setPrjFuncitonName(String prjFuncitonName) {
		this.prjFuncitonName = prjFuncitonName;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getUnitPhone() {
		return unitPhone;
	}
	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public List<Accessory> getAccessoryLists() {
		return accessoryLists;
	}
	public void setAccessoryLists(List<Accessory> accessoryLists) {
		this.accessoryLists = accessoryLists;
	}
	public String getOtherPrjId() {
		return otherPrjId;
	}
	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}
	public List<ProjectPerson> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<ProjectPerson> staffList) {
		this.staffList = staffList;
	}

}
