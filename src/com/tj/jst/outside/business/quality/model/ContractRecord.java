package com.tj.jst.outside.business.quality.model;

public class ContractRecord {
	private String	RECORDNUM;//合同备案编号
	private String	CONTRACTTYPENUM;//合同类别
	private String	CONTRACTTYPENAME;//合同类别名称
	private String	TENDERNUM;//中标通知书编号
	private String	SECTIONNAME;//标段名称
	private String  CONTRACTMONEY;//合同金额
	private String	PROJECTADDRESS;//工程地址
	private String	PROJECTCOST;//工程造价
	private String	AREA;//建筑面积
	private String	PRJNUM;//项目编号
	private String	PRJNAME;//项目名称
	private String	BUILDCORPNAME;//建设单位名称
	private String  CONTRACTORCORPNAME;//承包单位名称
	private String	BDATE;//计划开工日期
	private String	EDATE;//计划竣工验收日期
	private String QUALITYCERTNUM;//
	private String REPRESENTATIVECERTNUM;//（监理人员）总监证书号
	private String CONTRACTORCORPCODE;
	

	private String TITLELEVE;//等级
	private String CONSTRUCTORNAME;//项目经理姓名
	private String PHONE;//电话
	
	private String PROJECTMANAGER;//建设单位项目负责人
	private String UNITPHONE;//建设单位联系电话
	public String getRECORDNUM() {
		return RECORDNUM;
	}
	public void setRECORDNUM(String rECORDNUM) {
		RECORDNUM = rECORDNUM;
	}
	public String getCONTRACTTYPENUM() {
		return CONTRACTTYPENUM;
	}
	public void setCONTRACTTYPENUM(String cONTRACTTYPENUM) {
		CONTRACTTYPENUM = cONTRACTTYPENUM;
	}
	public String getCONTRACTTYPENAME() {
		return CONTRACTTYPENAME;
	}
	public void setCONTRACTTYPENAME(String cONTRACTTYPENAME) {
		CONTRACTTYPENAME = cONTRACTTYPENAME;
	}
	public String getTENDERNUM() {
		return TENDERNUM;
	}
	public void setTENDERNUM(String tENDERNUM) {
		TENDERNUM = tENDERNUM;
	}
	public String getSECTIONNAME() {
		return SECTIONNAME;
	}
	public void setSECTIONNAME(String sECTIONNAME) {
		SECTIONNAME = sECTIONNAME;
	}
	public String getPROJECTADDRESS() {
		return PROJECTADDRESS;
	}
	public void setPROJECTADDRESS(String pROJECTADDRESS) {
		PROJECTADDRESS = pROJECTADDRESS;
	}
	public String getPROJECTCOST() {
		return PROJECTCOST;
	}
	public void setPROJECTCOST(String pROJECTCOST) {
		PROJECTCOST = pROJECTCOST;
	}
	public String getAREA() {
		return AREA;
	}
	public void setAREA(String aREA) {
		AREA = aREA;
	}
	public String getPRJNUM() {
		return PRJNUM;
	}
	public void setPRJNUM(String pRJNUM) {
		PRJNUM = pRJNUM;
	}
	public String getPRJNAME() {
		return PRJNAME;
	}
	public void setPRJNAME(String pRJNAME) {
		PRJNAME = pRJNAME;
	}
	public String getBUILDCORPNAME() {
		return BUILDCORPNAME;
	}
	public void setBUILDCORPNAME(String bUILDCORPNAME) {
		BUILDCORPNAME = bUILDCORPNAME;
	}
	public String getBDATE() {
		return BDATE;
	}
	public void setBDATE(String bDATE) {
		BDATE = bDATE;
	}
	public String getEDATE() {
		return EDATE;
	}
	public void setEDATE(String eDATE) {
		EDATE = eDATE;
	}
	public String getCONTRACTORCORPNAME() {
		return CONTRACTORCORPNAME;
	}
	public void setCONTRACTORCORPNAME(String cONTRACTORCORPNAME) {
		CONTRACTORCORPNAME = cONTRACTORCORPNAME;
	}
	public String getQUALITYCERTNUM() {
		return QUALITYCERTNUM;
	}
	public void setQUALITYCERTNUM(String qUALITYCERTNUM) {
		QUALITYCERTNUM = qUALITYCERTNUM;
	}
	public String getREPRESENTATIVECERTNUM() {
		return REPRESENTATIVECERTNUM;
	}
	public void setREPRESENTATIVECERTNUM(String rEPRESENTATIVECERTNUM) {
		REPRESENTATIVECERTNUM = rEPRESENTATIVECERTNUM;
	}
	public String getCONTRACTORCORPCODE() {
		return CONTRACTORCORPCODE;
	}
	public void setCONTRACTORCORPCODE(String cONTRACTORCORPCODE) {
		CONTRACTORCORPCODE = cONTRACTORCORPCODE;
	}
	public String getCONTRACTMONEY() {
		return CONTRACTMONEY;
	}
	public void setCONTRACTMONEY(String cONTRACTMONEY) {
		CONTRACTMONEY = cONTRACTMONEY;
	}
	public String getTITLELEVE() {
		return TITLELEVE;
	}
	public void setTITLELEVE(String tITLELEVE) {
		TITLELEVE = tITLELEVE;
	}
	public String getCONSTRUCTORNAME() {
		return CONSTRUCTORNAME;
	}
	public void setCONSTRUCTORNAME(String cONSTRUCTORNAME) {
		CONSTRUCTORNAME = cONSTRUCTORNAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getPROJECTMANAGER() {
		return PROJECTMANAGER;
	}
	public void setPROJECTMANAGER(String pROJECTMANAGER) {
		PROJECTMANAGER = pROJECTMANAGER;
	}
	public String getUNITPHONE() {
		return UNITPHONE;
	}
	public void setUNITPHONE(String uNITPHONE) {
		UNITPHONE = uNITPHONE;
	}

}
