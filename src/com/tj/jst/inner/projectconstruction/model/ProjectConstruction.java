package com.tj.jst.inner.projectconstruction.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

public class ProjectConstruction {

	private String prjId;// 项目主键
	private String prjNum;// 项目编号
	private String prjName;// 项目名称
	private String prjTypeNum;// 项目分类
	private String prjTypeName;// 项目分类名称
	private String buildCorpName;// 建设单位名称
	private String buildCorpCode;// 建设单位组织机构代码证
	private String provinceNum;// 项目所在省
	private String provinceName;// 省名称
	private String cityNum;// 项目所在地
	private String cityName;// 地名称
	private String countyNum;// 项目所在区
	private String countyName;// 区名称
	private String prjApprovalNum;// 立项文号
	private String prjApprovalName;//
	private String prjApprovalLevelNum;// 立项级别
	private String prjApprovalLevelName;// 立项级别名称
	private String buldPlanNum;// 建设用地规划许可证标号
	private String projectPlanNum;// 建设工程规划西克正编号
	private String allInvest;// 总投资（万元）
	private String allArea;// 总面积（平方米）
	private String prjSize;// 建设规模
	private String prjPropertyNum;// 建设性质
	private String prjPropertyName;// 建设性质名称
	private String prjFunctionNum;// 工程用途
	private String prjFunctionName;// 工程用途名称
	private Date beginDate;// 实际开工日期
	private Date endDate;// 实际竣工日期
	private Date createDate;// 记录登记时间
	private String appDept;// 用于计算PrjNum
	private String appDeptName;// 审批名称
	private String projectManager;// 建设单位项目负责人
	private String unitPhone;// 建设单位联系电话
	private String unitMark;// 用于判断是否含有单位工程
	/**
	 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
	 */
	private String appType;// 审批状态
	/**
	 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可 6:竣工验收
	 */
	private String processSteps;

	private String opinion;

	private String address;

	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	private List<Upload> list = new ArrayList<Upload>();//附件
	
	
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

	public String getPrjTypeName() {
		return prjTypeName;
	}

	public void setPrjTypeName(String prjTypeName) {
		this.prjTypeName = prjTypeName;
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

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getPrjApprovalName() {
		return prjApprovalName;
	}

	public void setPrjApprovalName(String prjApprovalName) {
		this.prjApprovalName = prjApprovalName;
	}

	public String getPrjApprovalLevelNum() {
		return prjApprovalLevelNum;
	}

	public void setPrjApprovalLevelNum(String prjApprovalLevelNum) {
		this.prjApprovalLevelNum = prjApprovalLevelNum;
	}

	public String getPrjApprovalLevelName() {
		return prjApprovalLevelName;
	}

	public void setPrjApprovalLevelName(String prjApprovalLevelName) {
		this.prjApprovalLevelName = prjApprovalLevelName;
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

	public String getPrjPropertyName() {
		return prjPropertyName;
	}

	public void setPrjPropertyName(String prjPropertyName) {
		this.prjPropertyName = prjPropertyName;
	}

	public String getPrjFunctionNum() {
		return prjFunctionNum;
	}

	public void setPrjFunctionNum(String prjFunctionNum) {
		this.prjFunctionNum = prjFunctionNum;
	}

	public String getPrjFunctionName() {
		return prjFunctionName;
	}

	public void setPrjFunctionName(String prjFunctionName) {
		this.prjFunctionName = prjFunctionName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	public String getUnitMark() {
		return unitMark;
	}

	public void setUnitMark(String unitMark) {
		this.unitMark = unitMark;
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAppDeptName() {
		return appDeptName;
	}

	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
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

	public List<Upload> getList() {
		return list;
	}

	public void setList(List<Upload> list) {
		this.list = list;
	}

}
