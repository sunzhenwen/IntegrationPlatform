package com.tj.jst.outside.business.constructionFiling.fileWorld.model;

import java.sql.Date;

/**
 * ʩ����ͬwordģ��
 * @author hhc
 *
 */
public class FileWorld {

	private String conId;//����
	private String conName;//��ͬ����
	private String zhConName;//��������
	private String conType;//��ͬ���
	private String isLocking;//�Ƿ����� 0��δ���� 1������
	private String checkType;//����Ƿ��Ѿ��ύ�����δ�ύ��ѯģ�壬����ύ��ѯҵ��� 0��δ�ύ 1�����ύ
	private String recordId;//��ͬ��������
	private String reason;
	private int pnumber;//����
	private String inCommon;//�Ƿ�ͨ�� 0��ͨ�� 1����ͨ��
	private String linkAddress;//ģ�屣���ַ
	private String templateId;//ģ�������id
	private String saveLink;//��ҵ�ύ���ͬ�����ַ
	private String newConName;//�ύ�󱣴��������
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
