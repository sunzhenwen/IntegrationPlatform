package com.tj.jst.outside.business.tenderInfo.model;

import java.sql.Date;

/**
 * 招投标
 * @author hhc
 *
 */
public class TenderInfo {

	private String tenderId;
	private String tenderNum;//中标通知书编号
	private String prjNum;//项目编号
	private String projectAddress;//项目地址
	private String projectCost;//工程造价
	private String tenderClassNum;//招标类型(TBTENDERCLASSDIC)
	private String tenderClassName;
	private String tenderTypeNum;//招标方式(TBTENDERTYPEDIC)
	private String tenderTypeName;
	private Date tenderResultDate;//中标日期
	private String tenderMoney;//中标金额
	private String prjSize;//建设规模
	private String area;//面积(平方米)
	private String agencyCorpName;//招标代理单位名称
	private String agencyCorpCode;//招标代理单位组织机构代码
	private String tenderCorpName;//中标单位名称
	private String tenderCorpCode;//中标单位组织机构代码
	private String constructorName;//项目经理/总监理工程师姓名
	private String idCardTypeNum;//项目经理/总监理工程师证件类型
	private String idCardTypeName;
	private String constructorIdCard;//项目经理/总监理工程师证件号码
	private Date createDate;
	
	public String getTenderNum() {
		return tenderNum;
	}
	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getTenderClassNum() {
		return tenderClassNum;
	}
	public void setTenderClassNum(String tenderClassNum) {
		this.tenderClassNum = tenderClassNum;
	}
	public String getTenderTypeNum() {
		return tenderTypeNum;
	}
	public void setTenderTypeNum(String tenderTypeNum) {
		this.tenderTypeNum = tenderTypeNum;
	}
	public Date getTenderResultDate() {
		return tenderResultDate;
	}
	public void setTenderResultDate(Date tenderResultDate) {
		this.tenderResultDate = tenderResultDate;
	}
	public String getTenderMoney() {
		return tenderMoney;
	}
	public void setTenderMoney(String tenderMoney) {
		this.tenderMoney = tenderMoney;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAgencyCorpName() {
		return agencyCorpName;
	}
	public void setAgencyCorpName(String agencyCorpName) {
		this.agencyCorpName = agencyCorpName;
	}
	public String getAgencyCorpCode() {
		return agencyCorpCode;
	}
	public void setAgencyCorpCode(String agencyCorpCode) {
		this.agencyCorpCode = agencyCorpCode;
	}
	public String getTenderCorpName() {
		return tenderCorpName;
	}
	public void setTenderCorpName(String tenderCorpName) {
		this.tenderCorpName = tenderCorpName;
	}
	public String getTenderCorpCode() {
		return tenderCorpCode;
	}
	public void setTenderCorpCode(String tenderCorpCode) {
		this.tenderCorpCode = tenderCorpCode;
	}
	public String getConstructorName() {
		return constructorName;
	}
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getConstructorIdCard() {
		return constructorIdCard;
	}
	public void setConstructorIdCard(String constructorIdCard) {
		this.constructorIdCard = constructorIdCard;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTenderClassName() {
		return tenderClassName;
	}
	public void setTenderClassName(String tenderClassName) {
		this.tenderClassName = tenderClassName;
	}
	public String getTenderTypeName() {
		return tenderTypeName;
	}
	public void setTenderTypeName(String tenderTypeName) {
		this.tenderTypeName = tenderTypeName;
	}
	public String getIdCardTypeName() {
		return idCardTypeName;
	}
	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}
	public String getTenderId() {
		return tenderId;
	}
	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(String projectCost) {
		this.projectCost = projectCost;
	}			

}
