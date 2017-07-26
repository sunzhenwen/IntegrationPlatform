package com.tj.jst.outside.business.credibility.model;

import java.sql.Date;

import com.tj.jst.base.page.Condition;


public class CrediBillityGood{

	private	String	goodcreditid	;//	主键
	private	String	corpname	;//	企业名称
	private	String	corpcode	;//	企业机构代码
	private	String	departname	;//	登记部门
	private	String	username	;//	登记人
	private	Date	createdate	;//	登记日期
	private	String	provincenum	;//	良好行为发生所在省(字典表：tbxzqdmdic)
	private	String	prjnum	;//	项目编号
	private	String	awarddepartname	;//	奖励部门
	private	String	awarddeparttype	;//	奖励部门级别；0：部级，1：省市，2：地市，3：区县
	private	String	awardcontent	;//	奖励决定内容
	private	String	awardnumber	;//	奖励决定文号
	private	Date	awarddate	;//	奖励日期
	private	String	citynum	;//	良好行为发生所在地市(字典表：tbxzqdmdic)
	private	String	countynum	;//	良好行为发生所在区县(字典表：tbxzqdmdic)
	private	String	certtypenum	;//	企业类型
	private	String	prjname	;//	工程名称
	private	String	address	;//	工程地址
	private	String	buildcorpname	;//	建设单位
	private	String	buildcorpcode	;//	建设单位组织机构代码
	private	String	ispublic	;//	是否发布；0：未发布，1：已发布
	private	Date	publicbdate	;//	发布开始时间（发布时须填写）
	private	Date	publicedate	;//	发布结束时间（发布时须填写）
	private	String	auditusername	;//	审核领导（发布时须填写）
	private	Date	auditdate	;//	审核时间（发布时须填写）
	private	String	departid	;//	登记部门id
	private	String	status	;//	状态 0：可用 1：删除
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
