package com.tj.jst.inner.projectconstruction.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

public class ProjectConstruction {

	private String prjId;// ��Ŀ����
	private String prjNum;// ��Ŀ���
	private String prjName;// ��Ŀ����
	private String prjTypeNum;// ��Ŀ����
	private String prjTypeName;// ��Ŀ��������
	private String buildCorpName;// ���赥λ����
	private String buildCorpCode;// ���赥λ��֯��������֤
	private String provinceNum;// ��Ŀ����ʡ
	private String provinceName;// ʡ����
	private String cityNum;// ��Ŀ���ڵ�
	private String cityName;// ������
	private String countyNum;// ��Ŀ������
	private String countyName;// ������
	private String prjApprovalNum;// �����ĺ�
	private String prjApprovalName;//
	private String prjApprovalLevelNum;// �����
	private String prjApprovalLevelName;// ���������
	private String buldPlanNum;// �����õع滮���֤���
	private String projectPlanNum;// ���蹤�̹滮���������
	private String allInvest;// ��Ͷ�ʣ���Ԫ��
	private String allArea;// �������ƽ���ף�
	private String prjSize;// �����ģ
	private String prjPropertyNum;// ��������
	private String prjPropertyName;// ������������
	private String prjFunctionNum;// ������;
	private String prjFunctionName;// ������;����
	private Date beginDate;// ʵ�ʿ�������
	private Date endDate;// ʵ�ʿ�������
	private Date createDate;// ��¼�Ǽ�ʱ��
	private String appDept;// ���ڼ���PrjNum
	private String appDeptName;// ��������
	private String projectManager;// ���赥λ��Ŀ������
	private String unitPhone;// ���赥λ��ϵ�绰
	private String unitMark;// �����ж��Ƿ��е�λ����
	/**
	 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
	 */
	private String appType;// ����״̬
	/**
	 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ����� 6:��������
	 */
	private String processSteps;

	private String opinion;

	private String address;

	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	private List<Upload> list = new ArrayList<Upload>();//����
	
	
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
