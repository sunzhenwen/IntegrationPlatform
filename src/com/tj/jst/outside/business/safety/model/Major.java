package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * רҵ�ְ���λ
 * @author Administrator
 *
 */
public class Major {

	private String majorId;
	private String prjId;//��Ŀ��������
	private String safetyId;
	private String majorName;//רҵ�ְ���λ����
	private String majorProject;//רҵ�ְ��ְ��ֲ����������
	private Date majorLicenseDate;//רҵ�ְ���ȫ�������֤��Ч��
	private String majorStaff;//רҵ�ְ���Ŀ������
	private String majorCardNum;//רҵ�ְ���ȫ����֤��
	private String majorPhone;//רҵ�ְ���ϵ�绰
	private Date createDate; //��¼�Ǽ�����
	
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
