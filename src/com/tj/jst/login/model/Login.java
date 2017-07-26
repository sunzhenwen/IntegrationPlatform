package com.tj.jst.login.model;

/**
 * 登陆
 * 
 * @author hhc
 *
 */
public class Login {

	// 登陆的uKey
	private String uKey;
	// 用户主键
	private String userId;
	// 用户名称
	private String userName;
	// 组织机构代码证
	private String corpCode;
	// 工商营业执照号
	private String licenseNum;
	// 企业所在的省编码
	private String provincenum;
	// 企业所在的省名称
	private String provinceName;
	// 企业所在市编码
	private String citynum;
	// 企业所在市名称
	private String cityName;
	// 企业所在区编码
	private String countynum;
	// 企业所在区名称
	private String countyName;
	// 企业登记注册类型
	private int economicNum;
	// 注册资本
	private String regPrin;
	// 办公电话
	private String officePhone;
	// 企业归属地
	private String spare1;
	// 企业归属地名称
	private String spareName;
	private String legalMan; // 法定代表人姓名
	private String idCardTypeNum;// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
	private String legalManIdCard;// 法定代表人证件号码
	private String legaLManDuty;// 法定代表人职务
	private String legaManProtitle;// 法定代表人职称
	private String address; // 企业营业地址
	private String assets; // 净资产
	private String machinery; // 机械设备

	// 新老数据 0：老数据，1：新数据
	private String oldOrNew;
	// ------------------------------------------------------部门登陆信息------------------------------------------------
	private String Loginuserid; // 用户Id
	private String name; // 用户名
	private String roleID; // 角色ID
	private String departmentID; // 部门ID
	private String popedomid; // 权限集合
	private String department; // 部门名称
	private String personalID; // 人员id
	private String rolename; // 角色名称
	private String ROLESYSTMID; // 系统ID
	private String rolesystemname; // 系统名称
	private String enterPriseType; // 企业类型
	private String loginType;//key登陆类型,1：输入公司名称超级key登陆

	public String getuKey() {
		return uKey;
	}

	public void setuKey(String uKey) {
		this.uKey = uKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProvincenum() {
		return provincenum;
	}

	public void setProvincenum(String provincenum) {
		this.provincenum = provincenum;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCitynum() {
		return citynum;
	}

	public void setCitynum(String citynum) {
		this.citynum = citynum;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountynum() {
		return countynum;
	}

	public void setCountynum(String countynum) {
		this.countynum = countynum;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getLoginuserid() {
		return Loginuserid;
	}

	public void setLoginuserid(String loginuserid) {
		Loginuserid = loginuserid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getPopedomid() {
		return popedomid;
	}

	public void setPopedomid(String popedomid) {
		this.popedomid = popedomid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getROLESYSTMID() {
		return ROLESYSTMID;
	}

	public void setROLESYSTMID(String rOLESYSTMID) {
		ROLESYSTMID = rOLESYSTMID;
	}

	public String getRolesystemname() {
		return rolesystemname;
	}

	public void setRolesystemname(String rolesystemname) {
		this.rolesystemname = rolesystemname;
	}

	public String getSpare1() {
		return spare1;
	}

	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	public int getEconomicNum() {
		return economicNum;
	}

	public void setEconomicNum(int economicNum) {
		this.economicNum = economicNum;
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

	public String getLegaLManDuty() {
		return legaLManDuty;
	}

	public void setLegaLManDuty(String legaLManDuty) {
		this.legaLManDuty = legaLManDuty;
	}

	public String getLegaManProtitle() {
		return legaManProtitle;
	}

	public void setLegaManProtitle(String legaManProtitle) {
		this.legaManProtitle = legaManProtitle;
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

	public String getOldOrNew() {
		return oldOrNew;
	}

	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
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

	public String getSpareName() {
		return spareName;
	}

	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getEnterPriseType() {
		return enterPriseType;
	}

	public void setEnterPriseType(String enterPriseType) {
		this.enterPriseType = enterPriseType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
