package com.tj.jst.inner.business.contractinfo.model;

import java.sql.Date;

/**
 * 合同 Model类
 * 
 * @author Administrator
 *
 */
public class ContractInfo {

	private String conID;// 主键
	private String conName;// 名称
	private String conType;// 合同类别
	private String conTypeName;// 合同类别名称
	private String conMessage;// 合同内容
	private Date createDate;// 创建时间
	private int pNumber;// 排序
	private String inCommon;// 是否通用

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
