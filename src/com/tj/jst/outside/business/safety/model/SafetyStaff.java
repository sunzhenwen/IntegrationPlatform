package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

public class SafetyStaff {

	private String builderUserId;//主键
	private String prjNum;//项目编号
	private String prjName;//项目名称
	private String builderLicenceNum;//施工许可证编号
	private String corpName;//所属单位名称
	private String corpCode;//所属单位组织机构代码
	private String safetyCerId;//安全生产许可证编号
	private String userName;//人员姓名
	private String idCardTypeNum;//证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCard;//人员证件号码；身份证须18为
	private String certId;//安全生产考核合格证书编号
	private String userType;//安全生产管理员类型；1：主要负责人，2：项目负责人，3：安全员
	private Date createDate;//创建日期
	
	public String getBuilderUserId() {
		return builderUserId;
	}
	public void setBuilderUserId(String builderUserId) {
		this.builderUserId = builderUserId;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}
	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
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
	public String getSafetyCerId() {
		return safetyCerId;
	}
	public void setSafetyCerId(String safetyCerId) {
		this.safetyCerId = safetyCerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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

}
