package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

public class SafetyStaff {

	private String builderUserId;//����
	private String prjNum;//��Ŀ���
	private String prjName;//��Ŀ����
	private String builderLicenceNum;//ʩ�����֤���
	private String corpName;//������λ����
	private String corpCode;//������λ��֯��������
	private String safetyCerId;//��ȫ�������֤���
	private String userName;//��Ա����
	private String idCardTypeNum;//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCard;//��Ա֤�����룻���֤��18Ϊ
	private String certId;//��ȫ�������˺ϸ�֤����
	private String userType;//��ȫ��������Ա���ͣ�1����Ҫ�����ˣ�2����Ŀ�����ˣ�3����ȫԱ
	private Date createDate;//��������
	
	public String getBuilderUserId() {
		return builderUserId;
	}
	public void setBuilderUserId(String builderUserId) {
		this.builderUserId = builderUserId;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getBuilderLicenceNum() {
		return builderLicenceNum;
	}
	public void setBuilderLicenceNum(String builderLicenceNum) {
		this.builderLicenceNum = builderLicenceNum;
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
	public String getSafetyCerId() {
		return safetyCerId;
	}
	public void setSafetyCerId(String safetyCerId) {
		this.safetyCerId = safetyCerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
