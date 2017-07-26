package com.tj.jst.inner.personrecord.threeTypesPersonnel.model;

import java.util.Date;

public class ThreeTypesPersonnel {

	private String threeTypePersonId ; //主键
	private String FName ;            //姓名
	private String FIdCertNo ;        //身份证号
	private String FEntName ;         //所在单位
	private String FCertType ;        //证书类别
	private String FEntName1 ;        //单位 
	private String FCertNumber ;      //证书编号
	private Date FRegDate ;         //发证日期
	private Date FRegEndDate ;      //结束日期
	private String FState ;           //状态 0:有效 1:无效
	private String corpId ;           //企业主键
	
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
