package com.tj.jst.inner.personrecord.threeTypesPersonnel.model;

import java.util.Date;

public class ThreeTypesPersonnel {

	private String threeTypePersonId ; //����
	private String FName ;            //����
	private String FIdCertNo ;        //���֤��
	private String FEntName ;         //���ڵ�λ
	private String FCertType ;        //֤�����
	private String FEntName1 ;        //��λ 
	private String FCertNumber ;      //֤����
	private Date FRegDate ;         //��֤����
	private Date FRegEndDate ;      //��������
	private String FState ;           //״̬ 0:��Ч 1:��Ч
	private String corpId ;           //��ҵ����
	
	public String getThreeTypePersonId() {
		return threeTypePersonId;
	}
	public void setThreeTypePersonId(String threeTypePersonId) {
		this.threeTypePersonId = threeTypePersonId;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getFIdCertNo() {
		return FIdCertNo;
	}
	public void setFIdCertNo(String fIdCertNo) {
		FIdCertNo = fIdCertNo;
	}
	public String getFEntName() {
		return FEntName;
	}
	public void setFEntName(String fEntName) {
		FEntName = fEntName;
	}
	public String getFCertType() {
		return FCertType;
	}
	public void setFCertType(String fCertType) {
		FCertType = fCertType;
	}
	public String getFEntName1() {
		return FEntName1;
	}
	public void setFEntName1(String fEntName1) {
		FEntName1 = fEntName1;
	}
	public String getFCertNumber() {
		return FCertNumber;
	}
	public void setFCertNumber(String fCertNumber) {
		FCertNumber = fCertNumber;
	}
	public Date getFRegDate() {
		return FRegDate;
	}
	public void setFRegDate(Date fRegDate) {
		FRegDate = fRegDate;
	}
	public Date getFRegEndDate() {
		return FRegEndDate;
	}
	public void setFRegEndDate(Date fRegEndDate) {
		FRegEndDate = fRegEndDate;
	}
	public String getFState() {
		return FState;
	}
	public void setFState(String fState) {
		FState = fState;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
}
