package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * 专业分包单位
 * @author Administrator
 *
 */
public class Major {

	private String majorId;
	private String prjId;//项目报建主键
	private String safetyId;
	private String majorName;//专业分包单位名称
	private String majorProject;//专业分包分包分部分项工程名称
	private Date majorLicenseDate;//专业分包安全生产许可证有效期
	private String majorStaff;//专业分包项目负责人
	private String majorCardNum;//专业分包安全考核证号
	private String majorPhone;//专业分包联系电话
	private Date createDate; //记录登记日期
	
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorProject() {
		return majorProject;
	}
	public void setMajorProject(String majorProject) {
		this.majorProject = majorProject;
	}
	public Date getMajorLicenseDate() {
		return majorLicenseDate;
	}
	public void setMajorLicenseDate(Date majorLicenseDate) {
		this.majorLicenseDate = majorLicenseDate;
	}
	public String getMajorStaff() {
		return majorStaff;
	}
	public void setMajorStaff(String majorStaff) {
		this.majorStaff = majorStaff;
	}
	public String getMajorCardNum() {
		return majorCardNum;
	}
	public void setMajorCardNum(String majorCardNum) {
		this.majorCardNum = majorCardNum;
	}
	public String getMajorPhone() {
		return majorPhone;
	}
	public void setMajorPhone(String majorPhone) {
		this.majorPhone = majorPhone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getSafetyId() {
		return safetyId;
	}
	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}
}
