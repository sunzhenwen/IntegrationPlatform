package com.tj.jst.outside.business.design.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ���
 * @author hhc
 *
 */
public class Design {

	private String designId; //����
	private String prjId;//��Ŀ����������
	private String prjNum; //��Ŀ���
	private String prjName;//��Ŀ����
	private String corpName;//���赥λ����
	private String designNum; //��Ʊ���
	private String designCorpName; //��Ƶ�λ����
	private String designCorpCode; //��Ƶ�λ��֯��������
	private String appSteffId; //������id
	private String appSteffName; //����������
	private String appDate; //����ʱ��
	private String appOpinion; //�������
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
	private String processSteps ;
	private String applyCorpCode; //������ҵ��֯��������
	private Date createDate; //����ʱ��
	private String appDept;//������λid
	private String appDeptName;//������λ����
	private String isUnits;//�Ƿ���д����   0���ǣ�1����
	private List<DesignQualification> designQualifications = new ArrayList<DesignQualification>();
	
	public String getDesignId() {
		return designId;
	}
	public void setDesignId(String designId) {
		this.designId = designId;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
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
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
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
	public String getApplyCorpCode() {
		return applyCorpCode;
	}
	public void setApplyCorpCode(String applyCorpCode) {
		this.applyCorpCode = applyCorpCode;
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
	public String getAppDeptName() {
		return appDeptName;
	}
	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getIsUnits() {
		return isUnits;
	}
	public void setIsUnits(String isUnits) {
		this.isUnits = isUnits;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public List<DesignQualification> getDesignQualifications() {
		return designQualifications;
	}
	public void setDesignQualifications(
			List<DesignQualification> designQualifications) {
		this.designQualifications = designQualifications;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
