package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;

public class Certdetail {

	private String id;
	private String corpId;//企业主键
	private String corpName;//企业名称
	private String corpCode;//企业组织机构代码
	private String qualificationsType;// 资质资格类型(certTypeNum)
	private String qualificationsTypeName;// 资质资格类型名称
	private String specialtyType;// 专业类别(tradeBoundNum)
	private String specialtyTypeName;// 专业类别名称
	private String rating;// 资质资格等级(titleLevelNum)
	private String ratingName;// 资质资格等级名称
	private String certName;// 行业类型
	private String tradeTypeNum;//资质资格序列(字典表：TBTRADETYPEDIC)
	private String tradeTypeName;//资质资格序列名称
	private String tradeBoundName;//专业类别名称
	private String titleLevel;
	private String titleLevelNum;//资质资格等级
	private String certId;//证书编号
	private String organName;//发证机关
	private Date organDate;//发证日期
	private Date endDate;//证书有效期截止日期
	private String noteNumber;//首次批准资质资格文号
	private Date noteDate;//首次批准资质资格日期
	private String addtypenum;//资质资格取得方式

	private String certNum;
	private String licenseNum;//工商营业执照注册号
	private String provinceNum;//省编码
	private String cityNum;//市编码
	private String countyNum;//区编码
	private String address;//企业营业地址
	private String regPrin;//注册资本(万元)
	private String economicNum;//企业登记注册类型
	private String legalMan;//法定代表人姓名
	private String legalManDuty;//法定代表人职务
	private String legaManProTitle;//法定代表人职称
	private String techMan;//技术负责人姓名
	private String techManDuty;//技术负责人职务
	private String techManProTitle;//技术负责人职称或职业资格
	private String unitMan;//企业负责人姓名
	private String unitManDuty;//企业负责人职务
	private String unitManProTitle;//企业负责人职称
	private String isMaster;//是否主项资质
	private String dataSource;//数据来源
	
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

	public String getQualificationsType() {
		return qualificationsType;
	}

	public void setQualificationsType(String qualificationsType) {
		this.qualificationsType = qualificationsType;
	}

	public String getSpecialtyType() {
		return specialtyType;
	}

	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getQualificationsTypeName() {
		return qualificationsTypeName;
	}

	public void setQualificationsTypeName(String qualificationsTypeName) {
		this.qualificationsTypeName = qualificationsTypeName;
	}

	public String getSpecialtyTypeName() {
		return specialtyTypeName;
	}

	public void setSpecialtyTypeName(String specialtyTypeName) {
		this.specialtyTypeName = specialtyTypeName;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getTradeTypeName() {
		return tradeTypeName;
	}

	public void setTradeTypeName(String tradeTypeName) {
		this.tradeTypeName = tradeTypeName;
	}

	public String getTradeBoundName() {
		return tradeBoundName;
	}

	public void setTradeBoundName(String tradeBoundName) {
		this.tradeBoundName = tradeBoundName;
	}

	public String getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getTradeTypeNum() {
		return tradeTypeNum;
	}

	public void setTradeTypeNum(String tradeTypeNum) {
		this.tradeTypeNum = tradeTypeNum;
	}

	public String getTitleLevelNum() {
		return titleLevelNum;
	}

	public void setTitleLevelNum(String titleLevelNum) {
		this.titleLevelNum = titleLevelNum;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public Date getOrganDate() {
		return organDate;
	}

	public void setOrganDate(Date organDate) {
		this.organDate = organDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNoteNumber() {
		return noteNumber;
	}

	public void setNoteNumber(String noteNumber) {
		this.noteNumber = noteNumber;
	}

	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	public String getAddtypenum() {
		return addtypenum;
	}

	public void setAddtypenum(String addtypenum) {
		this.addtypenum = addtypenum;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getProvinceNum() {
		return provinceNum;
	}

	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCountyNum() {
		return countyNum;
	}

	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegPrin() {
		return regPrin;
	}

	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}

	public String getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(String economicNum) {
		this.economicNum = economicNum;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}

	public String getLegalManDuty() {
		return legalManDuty;
	}

	public void setLegalManDuty(String legalManDuty) {
		this.legalManDuty = legalManDuty;
	}

	public String getLegaManProTitle() {
		return legaManProTitle;
	}

	public void setLegaManProTitle(String legaManProTitle) {
		this.legaManProTitle = legaManProTitle;
	}

	public String getTechMan() {
		return techMan;
	}

	public void setTechMan(String techMan) {
		this.techMan = techMan;
	}

	public String getTechManDuty() {
		return techManDuty;
	}

	public void setTechManDuty(String techManDuty) {
		this.techManDuty = techManDuty;
	}

	public String getTechManProTitle() {
		return techManProTitle;
	}

	public void setTechManProTitle(String techManProTitle) {
		this.techManProTitle = techManProTitle;
	}

	public String getUnitMan() {
		return unitMan;
	}

	public void setUnitMan(String unitMan) {
		this.unitMan = unitMan;
	}

	public String getUnitManDuty() {
		return unitManDuty;
	}

	public void setUnitManDuty(String unitManDuty) {
		this.unitManDuty = unitManDuty;
	}

	public String getUnitManProTitle() {
		return unitManProTitle;
	}

	public void setUnitManProTitle(String unitManProTitle) {
		this.unitManProTitle = unitManProTitle;
	}

	public String getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(String isMaster) {
		this.isMaster = isMaster;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
