package com.tj.jst.inner.business.filingapply.model;

import java.sql.Date;

/**
 * 合同备案Model类
 * 
 * @author Administrator
 *
 */
public class ContractBusiness {

	private String conId;// 主键
	private String conName;// 名称
	private String zhConName;//中文名
	private String conMessage;// 内容
	private String conType;// 类别
	private String isLocking;// 是否锁定
	private Date createDate;// 创建时间
	private String recordId;// 合同备案Id
	private String tempId;// 模板主键Id
	private String reason;// 审核记录
	private String aDate;// 准确时间
	private String checkType;// 编辑状态
	private String linkAddress;//保存路径

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

	public String getConMessage() {
		return conMessage;
	}

	public void setConMessage(String conMessage) {
		this.conMessage = conMessage;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getADate() {
		return aDate;
	}

	public void setADate(String aDate) {
		this.aDate = aDate;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getZhConName() {
		return zhConName;
	}

	public void setZhConName(String zhConName) {
		this.zhConName = zhConName;
	}

}
