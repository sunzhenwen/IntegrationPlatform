package com.tj.jst.outside.business.contractFiling.model;

import java.sql.Date;

public class CertdetailInfo {

	private String certdetailid;
	private String certID;
	private String corpCode;
	private String corpname;
	private String certTypeNum;
	private String tradeTypeNum;
	private String tradeBoundNum;
	private String titleLevelNum;
	private String mark;
	private String isMaster;
	private String noteNumber;
	private Date noteDate;
	private String addTypeNum;
	private String oldOrNew;
	private String dataSource;
	
	public String getCertID() {
		return certID;
	}
	public void setCertID(String certID) {
		this.certID = certID;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpname() {
		return corpname;
	}
	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	public String getCertTypeNum() {
		return certTypeNum;
	}
	public void setCertTypeNum(String certTypeNum) {
		this.certTypeNum = certTypeNum;
	}
	public String getTradeTypeNum() {
		return tradeTypeNum;
	}
	public void setTradeTypeNum(String tradeTypeNum) {
		this.tradeTypeNum = tradeTypeNum;
	}
	public String getTradeBoundNum() {
		return tradeBoundNum;
	}
	public void setTradeBoundNum(String tradeBoundNum) {
		this.tradeBoundNum = tradeBoundNum;
	}
	public String getTitleLevelNum() {
		return titleLevelNum;
	}
	public void setTitleLevelNum(String titleLevelNum) {
		this.titleLevelNum = titleLevelNum;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getIsMaster() {
		return isMaster;
	}
	public void setIsMaster(String isMaster) {
		this.isMaster = isMaster;
	}
	public String getNoteNumber() {
		return noteNumber;
	}
	public void setNoteNumber(String noteNumber) {
		this.noteNumber = noteNumber;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	public String getAddTypeNum() {
		return addTypeNum;
	}
	public void setAddTypeNum(String addTypeNum) {
		this.addTypeNum = addTypeNum;
	}
	public String getOldOrNew() {
		return oldOrNew;
	}
	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getCertdetailid() {
		return certdetailid;
	}
	public void setCertdetailid(String certdetailid) {
		this.certdetailid = certdetailid;
	}

}
