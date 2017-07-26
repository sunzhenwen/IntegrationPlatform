package com.tj.jst.inner.integrity.corpGoodIntegrity.model;

import java.sql.Date;


/**
 * 企业良好行为信息数据表
 * @author DarkFlameMaster
 *
 */
public class CorpGoodIntegrity {
	
	private String corpGoodCreditId;						//主键
	private String corpName; 								//企业名称
	private String corpCode; 								//组织机构代码
	private String certTypeNum; 							//企业类型(字典表：TBAPTITUDEKINDDIC)
	private String prjNum;								 	//项目编号
	private String prjName; 								//工程名称
	private String address; 								//工程地址
	private String buildCorpName; 							//建设单位
	private String buildCorpCode; 							//建设单位组织机构代码
	private String provinceNum; 							//良好行为发生所在省(字典表：TBXZQDMDIC)
	private String cityNum; 								//良好行为发生所在地市(字典表：TBXZQDMDIC)
	private String countyNum; 								//良好行为发生所在区县(字典表：TBXZQDMDIC)
	private String awardDepartName;							//奖励部门	0:部级；1：省市；2：地市；3：区县；
	private String awardDepartType;							//奖励部门级别
	private String awardContent;							//奖励决定内容
	private String awardNumber;								//奖励决定文号
	private Date   awardDate;								//奖励日期
	private String departName;								//登记部门
	private String UserName;								//登记人
	private Date   createDate;								//登记日期
	private String isPublic;								//是否发布	0：未发布； 1：已发布；
	private Date   publicBDate;								//发布开始时间（发布时须填写）
	private Date   publicEDate;								//发布结束时间（发布时须填写）
	private String auditUserName;							//审核领导（发布时须填写）
	private Date   auditDate;								//审核时间（发布时须填写）
	private String departId;								//登记部门Id
	
	public String getCorpGoodCreditId() {
		return corpGoodCreditId;
	}
	public void setCorpGoodCreditId(String corpGoodCreditId) {
		this.corpGoodCreditId = corpGoodCreditId;
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
	public String getCertTypeNum() {
		return certTypeNum;
	}
	public void setCertTypeNum(String certTypeNum) {
		this.certTypeNum = certTypeNum;
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
	public String getAwardDepartName() {
		return awardDepartName;
	}
	public void setAwardDepartName(String awardDepartName) {
		this.awardDepartName = awardDepartName;
	}
	public String getAwardDepartType() {
		return awardDepartType;
	}
	public void setAwardDepartType(String awardDepartType) {
		this.awardDepartType = awardDepartType;
	}
	public String getAwardContent() {
		return awardContent;
	}
	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}
	public String getAwardNumber() {
		return awardNumber;
	}
	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}
	public Date getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
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
	
}
