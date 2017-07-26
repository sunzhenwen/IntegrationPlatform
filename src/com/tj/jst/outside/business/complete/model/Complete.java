package com.tj.jst.outside.business.complete.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��������
 * @author hhc
 *
 */
public class Complete {

	private String completeId; //����
	private String prjFinishNum;//�����������
	private String prjNum;//��Ŀ���
	private String prjName;//��Ŀ����
	private String tenderNum;//�б�֪ͨ����
	private String sectionName;//ʩ�����֤����

	private String projectName;//��������
	private String builderLicenceNum;//ʩ�����֤���
	private String qcCorpName;//��������������
	private String qcCorpCode;//������������֯��������
	private String factCost;//ʵ�����(��Ԫ)
	private String factArea;//ʵ�����(ƽ����)
	private String factSize;//ʵ�ʽ����ģ
	private String prjStructureTypeNum;//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
	private Date BDate;//ʵ�ʿ�������
	private Date EDate;//ʵ�ʿ�����������
	private String mark;//��ע
	
	
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
	private String auCorpName;
	
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
	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}
	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
	}
	public String getCompleteId() {
		return completeId;
	}
	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}
	public String getPrjFinishNum() {
		return prjFinishNum;
	}
	public void setPrjFinishNum(String prjFinishNum) {
		this.prjFinishNum = prjFinishNum;
	}
	public String getQcCorpName() {
		return qcCorpName;
	}
	public void setQcCorpName(String qcCorpName) {
		this.qcCorpName = qcCorpName;
	}
	public String getQcCorpCode() {
		return qcCorpCode;
	}
	public void setQcCorpCode(String qcCorpCode) {
		this.qcCorpCode = qcCorpCode;
	}
	public String getFactCost() {
		return factCost;
	}
	public void setFactCost(String factCost) {
		this.factCost = factCost;
	}
	public String getFactArea() {
		return factArea;
	}
	public void setFactArea(String factArea) {
		this.factArea = factArea;
	}
	public String getFactSize() {
		return factSize;
	}
	public void setFactSize(String factSize) {
		this.factSize = factSize;
	}
	public String getPrjStructureTypeNum() {
		return prjStructureTypeNum;
	}
	public void setPrjStructureTypeNum(String prjStructureTypeNum) {
		this.prjStructureTypeNum = prjStructureTypeNum;
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
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
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
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
}
