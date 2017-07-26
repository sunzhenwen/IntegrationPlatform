package com.tj.jst.inner.integrity.personBadIntegrity.model;

import java.sql.Date;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public class PersonBadIntegrity {

	private String badPersonId; //主键
	private String personName;//姓名
	private String idCardTypeNum;//证件类型(字典表：TBIDCARDTYPEDIC)
	private String idCard18;//证件号码
	private String specialtyTypNum;//人员类型(字典表：TBSPECIALTYTYPEDIC)
	
	
	private String corpName; //所在企业名称
	private String corpCode; //所在组织机构代码
	private String prjNum; //项目编号
	private String prjName; //工程名称
	private String address; //工程地址
	private String buildCorpName; //建设单位
	private String buildCorpCode; //建设单位组织机构代码
	private String provinceNum; //不良行为发生所在省(字典表：TBXZQDMDIC)
	private String cityNum; //不良行为发生所在地市(字典表：TBXZQDMDIC)
	private String countyNum; //不良行为发生所在区县(字典表：TBXZQDMDIC)
	private String creditClassNum; //不良行为分类(字典表：TBCREDITTYPE)
	private String creditType; //不良行为类别(字典表：TBCORPBADDIC)
	private String creditCode; //不良行为代码(字典表：TBCORPBADDIC)
	private String content; //不良行为内容
	private Date happenDate; //不良行为发生日期
	private String punishDepartName; //处罚部门
	private String punishDepartType; //处罚部门级别；0：部级，1：省市，2：地市，3：区县
	private String punishEvidence; //处罚依据(字典表：TBCORPBADDIC)
	private String punishContent; //处罚决定内容
	private String punishNumber; //处罚决定文号
	private Date punishDate; //处罚日期
	private Date punishEDate; //处罚截止日期
	private String punishMoney; //处罚金额
	private String departName; //登记部门
	private String departId;//登记部门Id
	private String userName; //登记人姓名
	private Date createDate; //登记日期
	private String isPublic; //是否发布；0：未发布，1：已发布
	private Date publicBDate; //发布开始时间（发布时须填写）
	private Date publicEDate; //发布结束时间（发布时须填写）
	private String auditUserName; //审核领导（发布时须填写）
	private Date auditDate; //审核时间（发布时须填写）
	private String delType;//删除状态 0：未删除、1：已删除
	
	public String getBadPersonId() {
		return badPersonId;
	}
	public void setBadPersonId(String badPersonId) {
		this.badPersonId = badPersonId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard18() {
		return idCard18;
	}
	public void setIdCard18(String idCard18) {
		this.idCard18 = idCard18;
	}
	public String getSpecialtyTypNum() {
		return specialtyTypNum;
	}
	public void setSpecialtyTypNum(String specialtyTypNum) {
		this.specialtyTypNum = specialtyTypNum;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildCorpName() {
		return buildCorpName;
	}
	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}
	public String getBuildCorpCode() {
		return buildCorpCode;
	}
	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
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
	public String getCreditClassNum() {
		return creditClassNum;
	}
	public void setCreditClassNum(String creditClassNum) {
		this.creditClassNum = creditClassNum;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getHappenDate() {
		return happenDate;
	}
	public void setHappenDate(Date happenDate) {
		this.happenDate = happenDate;
	}
	public String getPunishDepartName() {
		return punishDepartName;
	}
	public void setPunishDepartName(String punishDepartName) {
		this.punishDepartName = punishDepartName;
	}
	public String getPunishDepartType() {
		return punishDepartType;
	}
	public void setPunishDepartType(String punishDepartType) {
		this.punishDepartType = punishDepartType;
	}
	public String getPunishEvidence() {
		return punishEvidence;
	}
	public void setPunishEvidence(String punishEvidence) {
		this.punishEvidence = punishEvidence;
	}
	public String getPunishContent() {
		return punishContent;
	}
	public void setPunishContent(String punishContent) {
		this.punishContent = punishContent;
	}
	public String getPunishNumber() {
		return punishNumber;
	}
	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}
	public Date getPunishDate() {
		return punishDate;
	}
	public void setPunishDate(Date punishDate) {
		this.punishDate = punishDate;
	}
	public Date getPunishEDate() {
		return punishEDate;
	}
	public void setPunishEDate(Date punishEDate) {
		this.punishEDate = punishEDate;
	}
	public String getPunishMoney() {
		return punishMoney;
	}
	public void setPunishMoney(String punishMoney) {
		this.punishMoney = punishMoney;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public Date getPublicBDate() {
		return publicBDate;
	}
	public void setPublicBDate(Date publicBDate) {
		this.publicBDate = publicBDate;
	}
	public Date getPublicEDate() {
		return publicEDate;
	}
	public void setPublicEDate(Date publicEDate) {
		this.publicEDate = publicEDate;
	}
	public String getAuditUserName() {
		return auditUserName;
	}
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getDelType() {
		return delType;
	}
	public void setDelType(String delType) {
		this.delType = delType;
	}
}
