package com.tj.jst.inner.business.filingapply.model;

import java.sql.Date;

/**
 * ��ͬ����Model��
 * 
 * @author Administrator
 *
 */
public class ContractBusiness {

	private String conId;// ����
	private String conName;// ����
	private String zhConName;//������
	private String conMessage;// ����
	private String conType;// ���
	private String isLocking;// �Ƿ�����
	private Date createDate;// ����ʱ��
	private String recordId;// ��ͬ����Id
	private String tempId;// ģ������Id
	private String reason;// ��˼�¼
	private String aDate;// ׼ȷʱ��
	private String checkType;// �༭״̬
	private String linkAddress;//����·��

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
