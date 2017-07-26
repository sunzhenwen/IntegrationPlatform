package com.tj.jst.outside.corpinto.otherProvince.projectStaff.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 外省备案人员
 * @author Administrator
 *
 */
public class ProjectPerson {

	private String personId;//主键
	private String personName;//姓名
	private String cardNum;//身份证号
	private String otherPrjId;//外省备案项目主键
	private String staffType;//项目中的角色类型
	private String staffTypeName;
	private Date createDate;//创建日期
	private String state;//状态 0:使用 1:删除
	private String corpId;//企业主键
	private List<Accessory> accessoryList = new ArrayList<Accessory>();//附件提示信息
	private List<Accessory> accessoryLists = new ArrayList<Accessory>();//附件提示信息
	private List<Upload> list = new ArrayList<Upload>();//附件
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getOtherPrjId() {
		return otherPrjId;
	}
	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
	public List<Accessory> getAccessoryLists() {
		return accessoryLists;
	}
	public void setAccessoryLists(List<Accessory> accessoryLists) {
		this.accessoryLists = accessoryLists;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getStaffTypeName() {
		return staffTypeName;
	}
	public void setStaffTypeName(String staffTypeName) {
		this.staffTypeName = staffTypeName;
	}
	
}
