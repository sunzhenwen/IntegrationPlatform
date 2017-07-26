package com.tj.jst.outside.business.credibility.model;
import java.sql.Date;

/**
 * 企业诚信不良行为信息
 * @author Administrator
 *
 */
public class CrediBillity{
private	String	corpbadcreditid	;//	主键
private	String	corpname;	//	企业名称
private	String	corpcode;	//	组织机构代码
private	String	credittype;	//	不良行为类别(字典表：tbcorpbaddic)
private	String	creditcode;	//	不良行为代码(字典表：tbcorpbaddic)
private	Date	happendate;	//	不良行为发生日期
private	String	prjnum;	    //	项目编号
private	String	departname;	//	登记部门
private	String	punishevidence;	//	处罚依据(字典表：tbcorpbaddic)
private	String	punishcontent;	//	处罚决定内容
private	String	punishnumber;	//	处罚决定文号
private	Date	punishdate;	   //	处罚日期
private	Date	punishedate;	//	处罚截止日期
private	String	certtypenum;	//	企业类型(字典表：tbaptitudekinddic)
private	String	prjname	;	//	工程名称
private	String	address	;	//	工程地址
private	String	buildcorpname;	//	建设单位
private	String	buildcorpcode;	//	建设单位组织机构代码
private	String	provincenum	;	//	不良行为发生所在省(字典表：tbxzqdmdic)
private	String	citynum;	//	不良行为发生所在地市(字典表：tbxzqdmdic)
private	String	countynum;	//	不良行为发生所在区县(字典表：tbxzqdmdic)
private	String	creditclassnum;	//	不良行为分类(字典表：tbcredittype)
private	String	content;	//	不良行为内容
private	String	punishdepartname;	//	处罚部门
private	Date	auditdate;	//	审核时间（发布时须填写）
private	String	auditusername;	//	审核领导（发布时须填写）
private	Date	publicedate	;	//	发布结束时间（发布时须填写）
private	Date	publicbdate	;	//	发布开始时间（发布时须填写）
private	String	ispublic;	//	是否发布；0：未发布，1：已发布
private	Date	CREATEDATE;	//	登记日期
private	String	username;	//	登记人姓名
private	String	punishmoney;	//	处罚金额
private	String	punishdeparttype;	//	处罚部门级别；0：部级，1：省市，2：地市，3：区县
private	String	departid;	//	登记部门id
private	String	deltype	;	//	//删除状态 0：未删除、1：已删除
public String getCorpbadcreditid() {
	return corpbadcreditid;
}
public void setCorpbadcreditid(String corpbadcreditid) {
	this.corpbadcreditid = corpbadcreditid;
}
public String getCorpname() {
	return corpname;
}
public void setCorpname(String corpname) {
	this.corpname = corpname;
}
public String getCorpcode() {
	return corpcode;
}
public void setCorpcode(String corpcode) {
	this.corpcode = corpcode;
}
public String getCredittype() {
	return credittype;
}
public void setCredittype(String credittype) {
	this.credittype = credittype;
}
public String getCreditcode() {
	return creditcode;
}
public void setCreditcode(String creditcode) {
	this.creditcode = creditcode;
}

public String getPrjnum() {
	return prjnum;
}
public void setPrjnum(String prjnum) {
	this.prjnum = prjnum;
}
 
 
 
public String getDepartname() {
	return departname;
}
public void setDepartname(String departname) {
	this.departname = departname;
}
public String getPunishevidence() {
	return punishevidence;
}
public void setPunishevidence(String punishevidence) {
	this.punishevidence = punishevidence;
}
public String getPunishcontent() {
	return punishcontent;
}
public void setPunishcontent(String punishcontent) {
	this.punishcontent = punishcontent;
}
public String getPunishnumber() {
	return punishnumber;
}
public void setPunishnumber(String punishnumber) {
	this.punishnumber = punishnumber;
}

public String getCerttypenum() {
	return certtypenum;
}
public void setCerttypenum(String certtypenum) {
	this.certtypenum = certtypenum;
}
public String getPrjname() {
	return prjname;
}
public void setPrjname(String prjname) {
	this.prjname = prjname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getBuildcorpname() {
	return buildcorpname;
}
public void setBuildcorpname(String buildcorpname) {
	this.buildcorpname = buildcorpname;
}
public String getBuildcorpcode() {
	return buildcorpcode;
}
public void setBuildcorpcode(String buildcorpcode) {
	this.buildcorpcode = buildcorpcode;
}
public String getProvincenum() {
	return provincenum;
}
public void setProvincenum(String provincenum) {
	this.provincenum = provincenum;
}
public String getCitynum() {
	return citynum;
}
public void setCitynum(String citynum) {
	this.citynum = citynum;
}
public String getCountynum() {
	return countynum;
}
public void setCountynum(String countynum) {
	this.countynum = countynum;
}
public String getCreditclassnum() {
	return creditclassnum;
}
public void setCreditclassnum(String creditclassnum) {
	this.creditclassnum = creditclassnum;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPunishdepartname() {
	return punishdepartname;
}
public void setPunishdepartname(String punishdepartname) {
	this.punishdepartname = punishdepartname;
}
 

public Date getPunishdate() {
	return punishdate;
}
public void setPunishdate(Date punishdate) {
	this.punishdate = punishdate;
}
 
public Date getPunishedate() {
	return punishedate;
}
public void setPunishedate(Date punishedate) {
	this.punishedate = punishedate;
}
 
public Date getAuditdate() {
	return auditdate;
}
public void setAuditdate(Date auditdate) {
	this.auditdate = auditdate;
}
public String getAuditusername() {
	return auditusername;
}
public void setAuditusername(String auditusername) {
	this.auditusername = auditusername;
}
 
public String getIspublic() {
	return ispublic;
}
public void setIspublic(String ispublic) {
	this.ispublic = ispublic;
}

 
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPunishmoney() {
	return punishmoney;
}
public void setPunishmoney(String punishmoney) {
	this.punishmoney = punishmoney;
}
public String getPunishdeparttype() {
	return punishdeparttype;
}
public void setPunishdeparttype(String punishdeparttype) {
	this.punishdeparttype = punishdeparttype;
}
public String getDepartid() {
	return departid;
}
public void setDepartid(String departid) {
	this.departid = departid;
}
public String getDeltype() {
	return deltype;
}
public void setDeltype(String deltype) {
	this.deltype = deltype;
}
public Date getHappendate() {
	return happendate;
}
public void setHappendate(Date happendate) {
	this.happendate = happendate;
}
public Date getPublicedate() {
	return publicedate;
}
public void setPublicedate(Date publicedate) {
	this.publicedate = publicedate;
}
public Date getPublicbdate() {
	return publicbdate;
}
public void setPublicbdate(Date publicbdate) {
	this.publicbdate = publicbdate;
}
public Date getCREATEDATE() {
	return CREATEDATE;
}
public void setCREATEDATE(Date cREATEDATE) {
	CREATEDATE = cREATEDATE;
}


}