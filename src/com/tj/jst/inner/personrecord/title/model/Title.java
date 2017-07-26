package com.tj.jst.inner.personrecord.title.model;

import java.sql.Date;

/**
 * 职称人员备案model类
 * 
 * @author DarkFlameMaster
 *
 */
public class Title {

	private String personId; // 主键
	private String personName; // 姓名
	private String sexNum; // 性别(字典表：TBSEXDIC)
	private String sexName; // 性别名称
	private String idCardTypeNum; // 证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCardTypeName; // 证件类型名称
	private String idCard; // 身份证号(必须为18位)
	private String mobile; // 手机号码
	private String corpName; // 企业名称

	// 职称
	private String titleName;
	// 职称专业
	private String titleMajor;
	// 职称级别
	private String titleLevel;
	// 毕业学校
	private String graduatedSchool;
	// 所学专业
	private String studyMajor;
	// 毕业时间
	private Date graduatedDate;
	// 所在企业id
	private String corpId;
	// 所在企业组织机构代码证号
	private String corpCode;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleMajor() {
		return titleMajor;
	}

	public void setTitleMajor(String titleMajor) {
		this.titleMajor = titleMajor;
	}

	public String getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}

	public String getGraduatedSchool() {
		return graduatedSchool;
	}

	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}

	public String getStudyMajor() {
		return studyMajor;
	}

	public void setStudyMajor(String studyMajor) {
		this.studyMajor = studyMajor;
	}

	public Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
