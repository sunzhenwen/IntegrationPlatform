package com.tj.jst.outside.business.queryprojection.model;

import java.sql.Date;

/**
 * 合同备案Model类
 * 
 * @author DarkFlameMaster
 *
 */
public class Filing {

	private String recordId; // 主键
	private String recordNum; // 合同备案编号
	private String prjNum; // 项目编号
	private String prjName;// 项目名称
	private String contractNum; // 合同编号
	private String contractTypeNum; // 合同类别(TBCONTRACTTYPEDIC)
	private String contractTypeName;// 合同类别名称
	private String contractMoney; // 合同金额(万元)
	private String prjSize; // 建设规模
	private Date contractDate; // 合同签订日期
	private String propietorCorpName; // 发包单位名称
	private String propietorCorpCode; // 发包单位住组织代码
	private String contractorCorpName; // 承包单位名称
	private String contractorCorpCode; // 承包单位组织代码
	private String unionCorpName; // 联合体承包单位名称
	private String unionCorpCode; // 联合体承包单位组织代码
	private Date createDate; // 记录登记时间
	private String applyCorpCode;// 申请企业组织机构代码
	private String applyCorpName;// 申请企业名称
	private String appSteffId; // 审批人id
	private String appSteffName; // 审批人姓名
	private Date appDate; // 审批时间
	private String appOpinion; // 审批意见

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
