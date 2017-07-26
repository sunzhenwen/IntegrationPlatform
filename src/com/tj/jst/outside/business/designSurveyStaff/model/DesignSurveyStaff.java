package com.tj.jst.outside.business.designSurveyStaff.model;

import java.sql.Date;


/**
 * 勘察设计审图人员
 * @author hhc
 *
 */
public class DesignSurveyStaff {

	private String dsId;//主键
	private String prjNum;//项目编号
	private String prjName;//项目名称
	private String censorNum;//施工图审查合格证书编号
	private String corpName;//所属单位名称
	private String corpCode;//所属单位组织机构代码
	private String userName;//人员姓名
	private String idCardTypeNum;//证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCard;//人员证件号码；身份证须18为
	private String specialtyTypNum;//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	private String prjDuty;//承担角色(字典表：TBWORKDUTYDIC)
	private Date createDate;//创建日期
	private String conCorpCode;//报建单位组织机构代码
	private String conCorpName;//报检单位名称

	
	public String getDsId() {
		return dsId;
	}
	public void setDsId(String dsId) {
		this.dsId = dsId;
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
	public String getCensorNum() {
		return censorNum;
	}
	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
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
	public String getSpecialtyTypNum() {
		return specialtyTypNum;
	}
	public void setSpecialtyTypNum(String specialtyTypNum) {
		this.specialtyTypNum = specialtyTypNum;
	}
	public String getPrjDuty() {
		return prjDuty;
	}
	public void setPrjDuty(String prjDuty) {
		this.prjDuty = prjDuty;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getConCorpCode() {
		return conCorpCode;
	}
	public void setConCorpCode(String conCorpCode) {
		this.conCorpCode = conCorpCode;
	}
	public String getConCorpName() {
		return conCorpName;
	}
	public void setConCorpName(String conCorpName) {
		this.conCorpName = conCorpName;
	}
	
}
