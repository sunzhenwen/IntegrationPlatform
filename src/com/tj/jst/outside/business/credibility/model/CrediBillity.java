package com.tj.jst.outside.business.credibility.model;
import java.sql.Date;

/**
 * ��ҵ���Ų�����Ϊ��Ϣ
 * @author Administrator
 *
 */
public class CrediBillity{
private	String	corpbadcreditid	;//	����
private	String	corpname;	//	��ҵ����
private	String	corpcode;	//	��֯��������
private	String	credittype;	//	������Ϊ���(�ֵ��tbcorpbaddic)
private	String	creditcode;	//	������Ϊ����(�ֵ��tbcorpbaddic)
private	Date	happendate;	//	������Ϊ��������
private	String	prjnum;	    //	��Ŀ���
private	String	departname;	//	�Ǽǲ���
private	String	punishevidence;	//	��������(�ֵ��tbcorpbaddic)
private	String	punishcontent;	//	������������
private	String	punishnumber;	//	���������ĺ�
private	Date	punishdate;	   //	��������
private	Date	punishedate;	//	������ֹ����
private	String	certtypenum;	//	��ҵ����(�ֵ��tbaptitudekinddic)
private	String	prjname	;	//	��������
private	String	address	;	//	���̵�ַ
private	String	buildcorpname;	//	���赥λ
private	String	buildcorpcode;	//	���赥λ��֯��������
private	String	provincenum	;	//	������Ϊ��������ʡ(�ֵ��tbxzqdmdic)
private	String	citynum;	//	������Ϊ�������ڵ���(�ֵ��tbxzqdmdic)
private	String	countynum;	//	������Ϊ������������(�ֵ��tbxzqdmdic)
private	String	creditclassnum;	//	������Ϊ����(�ֵ��tbcredittype)
private	String	content;	//	������Ϊ����
private	String	punishdepartname;	//	��������
private	Date	auditdate;	//	���ʱ�䣨����ʱ����д��
private	String	auditusername;	//	����쵼������ʱ����д��
private	Date	publicedate	;	//	��������ʱ�䣨����ʱ����д��
private	Date	publicbdate	;	//	������ʼʱ�䣨����ʱ����д��
private	String	ispublic;	//	�Ƿ񷢲���0��δ������1���ѷ���
private	Date	CREATEDATE;	//	�Ǽ�����
private	String	username;	//	�Ǽ�������
private	String	punishmoney;	//	�������
private	String	punishdeparttype;	//	�������ż���0��������1��ʡ�У�2�����У�3������
private	String	departid;	//	�Ǽǲ���id
private	String	deltype	;	//	//ɾ��״̬ 0��δɾ����1����ɾ��
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