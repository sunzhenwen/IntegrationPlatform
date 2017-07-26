package com.tj.jst.outside.business.tenderInfo.model;

import java.sql.Date;

/**
 * 招投标(临时添加招投标使用)
 * @author hhc
 *
 */
public class TenderInfoAdd {

	private String tenderNum;//中标通知书编号
	private String prjName;//项目名称
	private String prjNum;//项目编号
	private String tenderClassNum;//招标类型(TBTENDERCLASSDIC)
	private String tenderTypeNum;//招标方式(TBTENDERTYPEDIC)
	private Date tenderResultDate;//中标日期
	private String tenderMoney;//中标金额
	private String prjSize;//建设规模(施工许可)
	private String area;//建筑面积(平方米)
	private String agencyCorpName;//招标代理单位名称
	private String agencyCorpCode;//招标代理单位组织机构代码
	private String tenderCorpName;//中标单位名称
	private String tenderCorpCode;//中标单位组织机构代码
	private String constructorName;//项目经理姓名
	private String idCardTypeNum;//安全生产管理证件类型(TBIDCARDTYPEDIC)
	private String constructorIdCard;//项目经理证件号码
	private Date createDate;//记录登记时间
	private String sectionName;//标段名称
	private String unionCorpName;//联合体承包单位名称
	private String unionCorpCode;//联合体承包单位组织代码
	private String projectAddress;//项目地址
	private String projectCost;//工程造价
	private String propietorCorpName;//发包单位名称
	private String propietorCorpCode;//发包单位住组织代码
	//ISDELETE	NUMBER(2)	Y			删除状态 0正常在用 1已删除
	//private String STATE	NUMBER(2)	Y			传输状态 0未传输 1已传输 2测试
	
	public String getTenderNum() {
		return tenderNum;
	}
	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
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
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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

}
