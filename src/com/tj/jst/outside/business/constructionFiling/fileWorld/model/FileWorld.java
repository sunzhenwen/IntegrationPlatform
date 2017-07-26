package com.tj.jst.outside.business.constructionFiling.fileWorld.model;

import java.sql.Date;

/**
 * 施工合同word模板
 * @author hhc
 *
 */
public class FileWorld {

	private String conId;//主键
	private String conName;//合同名称
	private String zhConName;//中文名称
	private String conType;//合同类别
	private String isLocking;//是否锁定 0：未锁定 1：锁定
	private String checkType;//监测是否已经提交，如果未提交查询模板，如果提交查询业务表 0：未提交 1：已提交
	private String recordId;//合同备案主键
	private String reason;
	private int pnumber;//排序
	private String inCommon;//是否通用 0：通用 1：非通用
	private String linkAddress;//模板保存地址
	private String templateId;//模板表主键id
	private String saveLink;//企业提交后合同保存地址
	private String newConName;//提交后保存的新名称
	private Date createDate;
	
	public String getConId() {
		return conId;
	}
	public void setConId(String conId) {
		this.conId = conId;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getIsLocking() {
		return isLocking;
	}
	public void setIsLocking(String isLocking) {
		this.isLocking = isLocking;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getInCommon() {
		return inCommon;
	}
	public void setInCommon(String inCommon) {
		this.inCommon = inCommon;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getSaveLink() {
		return saveLink;
	}
	public void setSaveLink(String saveLink) {
		this.saveLink = saveLink;
	}
	public String getNewConName() {
		return newConName;
	}
	public void setNewConName(String newConName) {
		this.newConName = newConName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getZhConName() {
		return zhConName;
	}
	public void setZhConName(String zhConName) {
		this.zhConName = zhConName;
	}

}
