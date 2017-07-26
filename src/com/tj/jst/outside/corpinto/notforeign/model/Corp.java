package com.tj.jst.outside.corpinto.notforeign.model;

import java.sql.Date;

/**
 * 企业基本信息
 * 
 * @author hhc
 *
 */
public class Corp {

	private String corpId; // 主键
	private String corpName; // 企业名称
	private String corpCode; // 组织机构代码
	private String licenseNum; // 工商营业执照注册号
	private String provinceNum; // 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
	private String cityNum; // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
	private String countyNum; // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
	private String address; // 企业营业地址
	private String postalCode; // 企业营业地址邮政编码
	private String legalMan; // 法定代表人姓名
	private String idCardTypeNum; // 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
	private String legalManIdCard; // 法定代表人证件号码
	private String legalManDuty; // 法定代表人职务
	private String legaManProtitle; // 法定代表人职称
	private String economicNum; // 企业登记注册类型(字典表：TBECONTYPEDIC)
	private String economicName;
	private String regPrin; // 注册资本(万元)
	private String factRegPrin; // 实收资本(万元)
	private String principalUnitNum; // 注册资本币种(字典表：TBPRINCIPALUNITDIC)
	private Date corpBirthDate; // 成立日期
	private String officePhone; // 办公电话
	private String fax; // 传真号码
	private String linkMan; // 联系人姓名
	private String linkTel; // 联系人办公电话
	private String linkPhone; // 联系人手机号码
	private String email; // 联系邮箱
	private String url; // 企业网址
	private String description; // 备注
	private String oldOrNew; // 0：老数据 1：新数据
	private Date createDate; // 添加日期
	private String modifyDate; // 修改日期
	private int checkType; // 0：基础数据库存在，不允许添加、修改;
							// 1：基础数据库里不存在，资质系统库存在语序修改;
							// 2：所有数据库中都不存在，允许添加
	private String message; // 返回消息
	private String assets; // 净资产
	private String machinery; // 机械设备
	private String appType; // 审批状态 0:外网提交未经审批、1:审批通过、2:审批退回
	private String lockNumber1 ; //UKey号
	private String lockNumber1_Date ;//发UKey日期
	private String spare1; // 企业归属地
	private String checkForeign; // 是否外商投资 0:是；1：否

	// ----------------------------------外商投资-------------------------------------
	private String foreignCorpName; // 外商投资者名称
	private String nationNume; // 国籍或地区(字典表：TBNATIONALDIC)
	private String percentTage; // 外商投资所占比例(%)
	private String foreignIvestor; // 外商投资这类型 0:境外企业；1：境外自然人

	// ----------------------------------审批申请-------------------------------------
	private String applyOpinion; // 审批意见
	private String applyStaffId; // 审批人员
	private String applyStaffName; // 审批人员名称
	private String applyDept; // 审批部门
	private String applyDeptName; // 审批部门名称
	private String enterpriseType;//企业类型

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLegalMan() {
		return legalMan;
	}

	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}

	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}

	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}

	public String getLegalManIdCard() {
		return legalManIdCard;
	}

	public void setLegalManIdCard(String legalManIdCard) {
		this.legalManIdCard = legalManIdCard;
	}

	public String getLegalManDuty() {
		return legalManDuty;
	}

	public void setLegalManDuty(String legalManDuty) {
		this.legalManDuty = legalManDuty;
	}

	public String getLegaManProtitle() {
		return legaManProtitle;
	}

	public void setLegaManProtitle(String legaManProtitle) {
		this.legaManProtitle = legaManProtitle;
	}

	public String getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(String economicNum) {
		this.economicNum = economicNum;
	}

	public String getRegPrin() {
		return regPrin;
	}

	public void setRegPrin(String regPrin) {
		this.regPrin = regPrin;
	}

	public String getFactRegPrin() {
		return factRegPrin;
	}

	public void setFactRegPrin(String factRegPrin) {
		this.factRegPrin = factRegPrin;
	}

	public String getPrincipalUnitNum() {
		return principalUnitNum;
	}

	public void setPrincipalUnitNum(String principalUnitNum) {
		this.principalUnitNum = principalUnitNum;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOldOrNew() {
		return oldOrNew;
	}

	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getCheckType() {
		return checkType;
	}

	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCorpBirthDate() {
		return corpBirthDate;
	}

	public void setCorpBirthDate(Date corpBirthDate) {
		this.corpBirthDate = corpBirthDate;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public String getMachinery() {
		return machinery;
	}

	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getSpare1() {
		return spare1;
	}

	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	public String getForeignCorpName() {
		return foreignCorpName;
	}

	public void setForeignCorpName(String foreignCorpName) {
		this.foreignCorpName = foreignCorpName;
	}

	public String getNationNume() {
		return nationNume;
	}

	public void setNationNume(String nationNume) {
		this.nationNume = nationNume;
	}

	public String getPercentTage() {
		return percentTage;
	}

	public void setPercentTage(String percentTage) {
		this.percentTage = percentTage;
	}

	public String getForeignIvestor() {
		return foreignIvestor;
	}

	public void setForeignIvestor(String foreignIvestor) {
		this.foreignIvestor = foreignIvestor;
	}

	public String getCheckForeign() {
		return checkForeign;
	}

	public void setCheckForeign(String checkForeign) {
		this.checkForeign = checkForeign;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getApplyOpinion() {
		return applyOpinion;
	}

	public void setApplyOpinion(String applyOpinion) {
		this.applyOpinion = applyOpinion;
	}

	public String getApplyStaffId() {
		return applyStaffId;
	}

	public void setApplyStaffId(String applyStaffId) {
		this.applyStaffId = applyStaffId;
	}

	public String getApplyStaffName() {
		return applyStaffName;
	}

	public void setApplyStaffName(String applyStaffName) {
		this.applyStaffName = applyStaffName;
	}

	public String getApplyDept() {
		return applyDept;
	}

	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}

	public String getApplyDeptName() {
		return applyDeptName;
	}

	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}

	public String getEconomicName() {
		return economicName;
	}

	public void setEconomicName(String economicName) {
		this.economicName = economicName;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getLockNumber1() {
		return lockNumber1;
	}

	public void setLockNumber1(String lockNumber1) {
		this.lockNumber1 = lockNumber1;
	}

	public String getLockNumber1_Date() {
		return lockNumber1_Date;
	}

	public void setLockNumber1_Date(String lockNumber1_Date) {
		this.lockNumber1_Date = lockNumber1_Date;
	}

}
