package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;

public class Certdetail {

	private String id;
	private String corpId;//��ҵ����
	private String corpName;//��ҵ����
	private String corpCode;//��ҵ��֯��������
	private String qualificationsType;// �����ʸ�����(certTypeNum)
	private String qualificationsTypeName;// �����ʸ���������
	private String specialtyType;// רҵ���(tradeBoundNum)
	private String specialtyTypeName;// רҵ�������
	private String rating;// �����ʸ�ȼ�(titleLevelNum)
	private String ratingName;// �����ʸ�ȼ�����
	private String certName;// ��ҵ����
	private String tradeTypeNum;//�����ʸ�����(�ֵ��TBTRADETYPEDIC)
	private String tradeTypeName;//�����ʸ���������
	private String tradeBoundName;//רҵ�������
	private String titleLevel;
	private String titleLevelNum;//�����ʸ�ȼ�
	private String certId;//֤����
	private String organName;//��֤����
	private Date organDate;//��֤����
	private Date endDate;//֤����Ч�ڽ�ֹ����
	private String noteNumber;//�״���׼�����ʸ��ĺ�
	private Date noteDate;//�״���׼�����ʸ�����
	private String addtypenum;//�����ʸ�ȡ�÷�ʽ

	private String certNum;
	private String licenseNum;//����Ӫҵִ��ע���
	private String provinceNum;//ʡ����
	private String cityNum;//�б���
	private String countyNum;//������
	private String address;//��ҵӪҵ��ַ
	private String regPrin;//ע���ʱ�(��Ԫ)
	private String economicNum;//��ҵ�Ǽ�ע������
	private String legalMan;//��������������
	private String legalManDuty;//����������ְ��
	private String legaManProTitle;//����������ְ��
	private String techMan;//��������������
	private String techManDuty;//����������ְ��
	private String techManProTitle;//����������ְ�ƻ�ְҵ�ʸ�
	private String unitMan;//��ҵ����������
	private String unitManDuty;//��ҵ������ְ��
	private String unitManProTitle;//��ҵ������ְ��
	private String isMaster;//�Ƿ���������
	private String dataSource;//������Դ
	
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
