package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * ����ְ���λ
 * @author Administrator
 *
 */
public class Labour {

	private String labourId;
	private String prjId;//��Ŀ��������
	private String safetyId;//��ȫ����
	private String labourName;//����ְ���λ����
	private Date labourLicenseDate;//����ְ���ȫ�������֤��Ч��
	private String labourStaff;//����ְ��ֳ�������
	private String labourPhone;//����ְ���ϵ�绰
	private Date createDate; //��¼�Ǽ�����
	
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
