package com.tj.jst.inner.personrecord.skill.model;

import java.sql.Date;

/**
 * 技术人员model类
 * 
 * @author DarkFlameMaster
 *
 */
public class Skill {

	private String personId; // 主键
	private String personName; // 技术人员姓名
	private String sexNum; // 技术人员性别(字典表：TBSEXDIC)
	private String sexName; // 性别
	private String idCardTypeNum; // 证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCardTypeName; // 证件类型名称
	private Date birthday; // 生日
	private String nationAlityNum; // 民族(字典表：TBNATIONDIC)
	private String nationAlityName; // 民族名称(字典表：TBNATIONDIC)
	private String eduLevelNum; // 学历(字典表：TBEDULEVELDIC)
	private String eduLevelName; // 学历名称(字典表：TBEDULEVELDIC)
	private String degreeNum; // 学位(字典表：TBDEGREEDIC)
	private String degreeName; // 学位名称(字典表：TBDEGREEDIC)
	private String identityCard; // 技术人员身份证（必须18位）
	private String skilledType; // 技术工种类别（字典表：TBSKILLEDWORkERTYPE）
	private String skilledTypeNum; // 技术工种类别code
	private String skilledLevel; // 技术工种级别（字典表：TBSKILLEDWORKERLEVEL）
	private String skilledLevelNum;
	private String mobile; // 手机号码
	private String userId; // 企业编码ID
	private String corpCode; // 企业编码
	private String corpName; // 企业名称
	private String certificateNum;// 证书编号

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

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getSkilledType() {
		return skilledType;
	}

	public void setSkilledType(String skilledType) {
		this.skilledType = skilledType;
	}

	public String getSkilledTypeNum() {
		return skilledTypeNum;
	}

	public void setSkilledTypeNum(String skilledTypeNum) {
		this.skilledTypeNum = skilledTypeNum;
	}

	public String getSkilledLevel() {
		return skilledLevel;
	}

	public void setSkilledLevel(String skilledLevel) {
		this.skilledLevel = skilledLevel;
	}

	public String getSkilledLevelNum() {
		return skilledLevelNum;
	}

	public void setSkilledLevelNum(String skilledLevelNum) {
		this.skilledLevelNum = skilledLevelNum;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

}
