package com.tj.jst.inner.business.contractinfo.model;

import java.sql.Date;

/**
 * ��ͬ Model��
 * 
 * @author Administrator
 *
 */
public class ContractInfo {

	private String conID;// ����
	private String conName;// ����
	private String conType;// ��ͬ���
	private String conTypeName;// ��ͬ�������
	private String conMessage;// ��ͬ����
	private Date createDate;// ����ʱ��
	private int pNumber;// ����
	private String inCommon;// �Ƿ�ͨ��

	public String getConID() {
		return conID;
	}

	public void setConID(String conID) {
		this.conID = conID;
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

	public String getConTypeName() {
		return conTypeName;
	}

	public void setConTypeName(String conTypeName) {
		this.conTypeName = conTypeName;
	}

	public String getConMessage() {
		return conMessage;
	}

	public void setConMessage(String conMessage) {
		this.conMessage = conMessage;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getPNumber() {
		return pNumber;
	}

	public void setPNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	public String getInCommon() {
		return inCommon;
	}

	public void setInCommon(String inCommon) {
		this.inCommon = inCommon;
	}

}
