package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * 劳务分包单位
 * @author Administrator
 *
 */
public class Labour {

	private String labourId;
	private String prjId;//项目报建主键
	private String safetyId;//安全主键
	private String labourName;//劳务分包单位名称
	private Date labourLicenseDate;//劳务分包安全生产许可证有效期
	private String labourStaff;//劳务分包现场负责人
	private String labourPhone;//劳务分包联系电话
	private Date createDate; //记录登记日期
	
	public String getLabourId() {
		return labourId;
	}
	public void setLabourId(String labourId) {
		this.labourId = labourId;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getLabourName() {
		return labourName;
	}
	public void setLabourName(String labourName) {
		this.labourName = labourName;
	}
	public Date getLabourLicenseDate() {
		return labourLicenseDate;
	}
	public void setLabourLicenseDate(Date labourLicenseDate) {
		this.labourLicenseDate = labourLicenseDate;
	}
	public String getLabourStaff() {
		return labourStaff;
	}
	public void setLabourStaff(String labourStaff) {
		this.labourStaff = labourStaff;
	}
	public String getLabourPhone() {
		return labourPhone;
	}
	public void setLabourPhone(String labourPhone) {
		this.labourPhone = labourPhone;
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
