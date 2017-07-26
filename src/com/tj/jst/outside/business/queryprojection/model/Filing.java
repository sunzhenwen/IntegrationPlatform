package com.tj.jst.outside.business.queryprojection.model;

import java.sql.Date;

/**
 * ��ͬ����Model��
 * 
 * @author DarkFlameMaster
 *
 */
public class Filing {

	private String recordId; // ����
	private String recordNum; // ��ͬ�������
	private String prjNum; // ��Ŀ���
	private String prjName;// ��Ŀ����
	private String contractNum; // ��ͬ���
	private String contractTypeNum; // ��ͬ���(TBCONTRACTTYPEDIC)
	private String contractTypeName;// ��ͬ�������
	private String contractMoney; // ��ͬ���(��Ԫ)
	private String prjSize; // �����ģ
	private Date contractDate; // ��ͬǩ������
	private String propietorCorpName; // ������λ����
	private String propietorCorpCode; // ������λס��֯����
	private String contractorCorpName; // �а���λ����
	private String contractorCorpCode; // �а���λ��֯����
	private String unionCorpName; // ������а���λ����
	private String unionCorpCode; // ������а���λ��֯����
	private Date createDate; // ��¼�Ǽ�ʱ��
	private String applyCorpCode;// ������ҵ��֯��������
	private String applyCorpName;// ������ҵ����
	private String appSteffId; // ������id
	private String appSteffName; // ����������
	private Date appDate; // ����ʱ��
	private String appOpinion; // �������

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
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

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getContractTypeNum() {
		return contractTypeNum;
	}

	public void setContractTypeNum(String contractTypeNum) {
		this.contractTypeNum = contractTypeNum;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public String getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}

	public String getPrjSize() {
		return prjSize;
	}

	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getPropietorCorpName() {
		return propietorCorpName;
	}

	public void setPropietorCorpName(String propietorCorpName) {
		this.propietorCorpName = propietorCorpName;
	}

	public String getPropietorCorpCode() {
		return propietorCorpCode;
	}

	public void setPropietorCorpCode(String propietorCorpCode) {
		this.propietorCorpCode = propietorCorpCode;
	}

	public String getContractorCorpName() {
		return contractorCorpName;
	}

	public void setContractorCorpName(String contractorCorpName) {
		this.contractorCorpName = contractorCorpName;
	}

	public String getContractorCorpCode() {
		return contractorCorpCode;
	}

	public void setContractorCorpCode(String contractorCorpCode) {
		this.contractorCorpCode = contractorCorpCode;
	}

	public String getUnionCorpName() {
		return unionCorpName;
	}

	public void setUnionCorpName(String unionCorpName) {
		this.unionCorpName = unionCorpName;
	}

	public String getUnionCorpCode() {
		return unionCorpCode;
	}

	public void setUnionCorpCode(String unionCorpCode) {
		this.unionCorpCode = unionCorpCode;
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

}
