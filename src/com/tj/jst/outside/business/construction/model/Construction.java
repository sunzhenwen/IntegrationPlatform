package com.tj.jst.outside.business.construction.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;



/**
 * ��Ŀ����
 * @author hhc
 *
 */
public class Construction {

	private String prjId; //����
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private String corpId;//��ҵ����
	private String corpName;//��ҵ����
	private String corpCode;//��ҵ��֯��������
	private String otherPrjId;//��ʡ������Ŀ����
	private String prjTypeNum; //��Ŀ����(�ֵ��TBPRJTYPEDIC)
	private String prjTypeName;//��Ŀ��������
	private String buildCorpName; //���赥λ����
	private String buildCorpCode; //���赥λ��֯��������
	private String provinceNum; //��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
	private String provinceName;//��Ŀ����ʡ����
	private String cityNum; //��Ŀ������(�ֵ��TBXZQDMDIC)
	private String cityName;//��Ŀ����������
	private String countyNum; //��Ŀ��������(�ֵ��TBXZQDMDIC)
	private String countyName;//��Ŀ������������
	private String prjApprovalNum; //�����ĺ�
	private String prjApprovalLevelNum; //�����
	private String prjApprovalLevelName;//���������
	private String buldPlanNum; //�����õع滮���֤���
	private String projectPlanNum; //���蹤�̹滮���֤���
	private String allInvest; //��Ͷ�ʣ���Ԫ��
	private String allArea; //�������ƽ���ף�
	private String prjSize; //�����ģ
	private String prjPropertyNum; //��������(�ֵ��TBPRJPROPERTYDIC)
	private String prjPropertyName;//������������
	private String prjFuncitonNum; //������;(�ֵ��TBPRJFUNCTIONDIC)
	private String prjFuncitonName;//������;����
	private Date BDate; //�������ڣ�������������ΪM
	private Date EDate; //�����������ڣ�������������ΪM
	private Date createDate; //��¼�Ǽ�ʱ��
	private String address;//�����ַ
	private String projectManager;//���赥λ��Ŀ������
	private String unitPhone;//���赥λ��ϵ�绰
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//������ʾ��Ϣ
	private List<Accessory> accessoryLists = new ArrayList<Accessory>();//������ʾ��Ϣ
	private List<Upload> list = new ArrayList<Upload>();//����
	private List<ProjectPerson> staffList = new ArrayList<ProjectPerson>();//��ʡ��Ŀ�����µ���Ա��Ϣ
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
	private String processSteps ;
	private String appDept;//������λid
	private String appDeptName;//������λ����
	
	
	//------------------------------------------���-------------------------------------------
	private String designId;//�������
	private String designNum;//��Ʊ���
	private String designCorpName;//��Ƶ�λ����
	private String designCorpCode;//��Ƶ�λ��֯��������
	private String designApptype;//�������״̬
	private String designProcessSteps;//������̲���
	private Date designCreateDate;//�������ʱ��
	private String designAppDept;//���������������
	private String designAppDeptName;//�������������������
	private String designIsUnits;//��Ƶ�λ�Ƿ���д���� 0:�� 1:��
	private String designApplyCorpCode;//������ҵ��֯��������

	
	//------------------------------------------����-------------------------------------------
	private String surveyId;//��������
	private String surveyNum;//�������
	private String surveyCorpName;//���쵥λ����
	private String surveyCorpCode;//���쵥λ��֯��������
	private String surveyApptype;//��������״̬
	private String surveyProcessSteps;//�������̲���
	private Date surveyCreateDate;//��������ʱ��
	private String surveyAppDept;//����������������
	private String surveyAppDeptName;//��������������������
	private String surveyIsUnits;//���쵥λ�Ƿ���д���� 0:�� 1:��
	private String surveyApplyCorpCode;//������ҵ��֯��������
	
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
