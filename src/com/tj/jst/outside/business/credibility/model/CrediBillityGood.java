package com.tj.jst.outside.business.credibility.model;

import java.sql.Date;

import com.tj.jst.base.page.Condition;


public class CrediBillityGood{

	private	String	goodcreditid	;//	����
	private	String	corpname	;//	��ҵ����
	private	String	corpcode	;//	��ҵ��������
	private	String	departname	;//	�Ǽǲ���
	private	String	username	;//	�Ǽ���
	private	Date	createdate	;//	�Ǽ�����
	private	String	provincenum	;//	������Ϊ��������ʡ(�ֵ��tbxzqdmdic)
	private	String	prjnum	;//	��Ŀ���
	private	String	awarddepartname	;//	��������
	private	String	awarddeparttype	;//	�������ż���0��������1��ʡ�У�2�����У�3������
	private	String	awardcontent	;//	������������
	private	String	awardnumber	;//	���������ĺ�
	private	Date	awarddate	;//	��������
	private	String	citynum	;//	������Ϊ�������ڵ���(�ֵ��tbxzqdmdic)
	private	String	countynum	;//	������Ϊ������������(�ֵ��tbxzqdmdic)
	private	String	certtypenum	;//	��ҵ����
	private	String	prjname	;//	��������
	private	String	address	;//	���̵�ַ
	private	String	buildcorpname	;//	���赥λ
	private	String	buildcorpcode	;//	���赥λ��֯��������
	private	String	ispublic	;//	�Ƿ񷢲���0��δ������1���ѷ���
	private	Date	publicbdate	;//	������ʼʱ�䣨����ʱ����д��
	private	Date	publicedate	;//	��������ʱ�䣨����ʱ����д��
	private	String	auditusername	;//	����쵼������ʱ����д��
	private	Date	auditdate	;//	���ʱ�䣨����ʱ����д��
	private	String	departid	;//	�Ǽǲ���id
	private	String	status	;//	״̬ 0������ 1��ɾ��
	public String getGoodcreditid() {
		return goodcreditid;
	}
	public void setGoodcreditid(String goodcreditid) {
		this.goodcreditid = goodcreditid;
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
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	 
	public String getProvincenum() {
		return provincenum;
	}
	public void setProvincenum(String provincenum) {
		this.provincenum = provincenum;
	}
	public String getPrjnum() {
		return prjnum;
	}
	public void setPrjnum(String prjnum) {
		this.prjnum = prjnum;
	}
	public String getAwarddepartname() {
		return awarddepartname;
	}
	public void setAwarddepartname(String awarddepartname) {
		this.awarddepartname = awarddepartname;
	}
	public String getAwarddeparttype() {
		return awarddeparttype;
	}
	public void setAwarddeparttype(String awarddeparttype) {
		this.awarddeparttype = awarddeparttype;
	}
	public String getAwardcontent() {
		return awardcontent;
	}
	public void setAwardcontent(String awardcontent) {
		this.awardcontent = awardcontent;
	}
	public String getAwardnumber() {
		return awardnumber;
	}
	public void setAwardnumber(String awardnumber) {
		this.awardnumber = awardnumber;
	}
	
	 
	public Date getAwarddate() {
		return awarddate;
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
	public String getIspublic() {
		return ispublic;
	}
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}
	 
	public String getAuditusername() {
		return auditusername;
	}
	public void setAuditusername(String auditusername) {
		this.auditusername = auditusername;
	}
	 
	public Date getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getPublicbdate() {
		return publicbdate;
	}
	public void setPublicbdate(Date publicbdate) {
		this.publicbdate = publicbdate;
	}
	public Date getPublicedate() {
		return publicedate;
	}
	public void setPublicedate(Date publicedate) {
		this.publicedate = publicedate;
	}
	public void setAwarddate(Date awarddate) {
		this.awarddate = awarddate;
	}

}
