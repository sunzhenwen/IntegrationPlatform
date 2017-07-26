package com.tj.jst.inner.personrecord.constructor.model;

import java.sql.Date;

public class Constructor {

	private String personId; // 主键
	private String personName; // 姓名
	private String sexNum; // 性别(字典表：TBSEXDIC)
	private String sexName; // 性别名称
	private String idCardTypeNum; // 证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCardTypeName; // 证件类型名称
	private String idCard; // 身份证号(必须为18位)
	private Date birthday; // 生日
	private String nationAlityNum; // 民族(字典表：TBNATIONDIC)
	private String nationAlityName; // 民族名称(字典表：TBNATIONDIC)
	private String eduLevelNum; // 学历(字典表：TBEDULEVELDIC)
	private String eduLevelName; // 学历名称(字典表：TBEDULEVELDIC)
	private String degreeNum; // 学位(字典表：TBDEGREEDIC)
	private String degreeName; // 学位名称(字典表：TBDEGREEDIC)
	private String mobile; // 手机号码

	private String sepecialtyTypNum;// 注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	private String sepecialtyTypName;// 注册类型及等级名称
	private String certNum; // 注册证书编号
	private Date awardDate; // 发证日期
	private String awardDepart; // 发证单位
	private String stampNum; // 执业印章号
	private Date effectDate; // 注册有效期
	private String callingTypeNum; // 所在企业行业类型(字典表：TBCALLINGTYPEDIC)
	private String callingTypeName; // 所在企业行业类型名称
	private String corpName; // 所在企业名称
	private String corpCode; // 所在企业组织机构代码
	private String certId; // 所在企业证书编号
	private String regTradeTypeNum; // 注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
	private String regTradeTypeName;// 注册专业编号名称
	private Date tradeTypeAwardDate; // 注册开始日期(1-8)
	private Date tradeTypeEffectDate; // 注册截止日期(1-8)
	private String qState; // 职业资格状态(1-8)(字典表：TBQSTATEDIC)
	private String stateName; // 职业资格状态名称

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getSexNum() {
		return sexNum;
	}

	public void setSexNum(String sexNum) {
		this.sexNum = sexNum;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}

	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}

	public String getIdCardTypeName() {
		return idCardTypeName;
	}

	public void setIdCardTypeName(String idCardTypeName) {
		this.idCardTypeName = idCardTypeName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationAlityNum() {
		return nationAlityNum;
	}

	public void setNationAlityNum(String nationAlityNum) {
		this.nationAlityNum = nationAlityNum;
	}

	public String getNationAlityName() {
		return nationAlityName;
	}

	public void setNationAlityName(String nationAlityName) {
		this.nationAlityName = nationAlityName;
	}

	public String getEduLevelNum() {
		return eduLevelNum;
	}

	public void setEduLevelNum(String eduLevelNum) {
		this.eduLevelNum = eduLevelNum;
	}

	public String getEduLevelName() {
		return eduLevelName;
	}

	public void setEduLevelName(String eduLevelName) {
		this.eduLevelName = eduLevelName;
	}

	public String getDegreeNum() {
		return degreeNum;
	}

	public void setDegreeNum(String degreeNum) {
		this.degreeNum = degreeNum;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSepecialtyTypNum() {
		return sepecialtyTypNum;
	}

	public void setSepecialtyTypNum(String sepecialtyTypNum) {
		this.sepecialtyTypNum = sepecialtyTypNum;
	}

	public String getSepecialtyTypName() {
		return sepecialtyTypName;
	}

	public void setSepecialtyTypName(String sepecialtyTypName) {
		this.sepecialtyTypName = sepecialtyTypName;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public Date getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}

	public String getAwardDepart() {
		return awardDepart;
	}

	public void setAwardDepart(String awardDepart) {
		this.awardDepart = awardDepart;
	}

	public String getStampNum() {
		return stampNum;
	}

	public void setStampNum(String stampNum) {
		this.stampNum = stampNum;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getCallingTypeNum() {
		return callingTypeNum;
	}

	public void setCallingTypeNum(String callingTypeNum) {
		this.callingTypeNum = callingTypeNum;
	}

	public String getCallingTypeName() {
		return callingTypeName;
	}

	public void setCallingTypeName(String callingTypeName) {
		this.callingTypeName = callingTypeName;
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

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getRegTradeTypeNum() {
		return regTradeTypeNum;
	}

	public void setRegTradeTypeNum(String regTradeTypeNum) {
		this.regTradeTypeNum = regTradeTypeNum;
	}

	public String getRegTradeTypeName() {
		return regTradeTypeName;
	}

	public void setRegTradeTypeName(String regTradeTypeName) {
		this.regTradeTypeName = regTradeTypeName;
	}

	public Date getTradeTypeAwardDate() {
		return tradeTypeAwardDate;
	}

	public void setTradeTypeAwardDate(Date tradeTypeAwardDate) {
		this.tradeTypeAwardDate = tradeTypeAwardDate;
	}

	public Date getTradeTypeEffectDate() {
		return tradeTypeEffectDate;
	}

	public void setTradeTypeEffectDate(Date tradeTypeEffectDate) {
		this.tradeTypeEffectDate = tradeTypeEffectDate;
	}

	public String getqState() {
		return qState;
	}

	public void setqState(String qState) {
		this.qState = qState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
