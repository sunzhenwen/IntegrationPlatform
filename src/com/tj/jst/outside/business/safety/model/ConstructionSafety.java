package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * 施工总承包单位现场专职安全管理人员
 * @author Administrator
 *
 */
public class ConstructionSafety {
	
	private String consId;//主键
	private String prjId;//项目报建主键
	private String safetyId;
	private String safetyManageName;//施工总承包单位现场专职安全管理人员姓名
	private String safetyManageNum;//施工总承包单位现场专职安全管理人员岗位证号
	private String safetyManagecheckNum;//施工总承包单位现场专职安全管理人员安全考核证号
	private Date createDate; //记录登记日期
	
	public String getConsId() {
		return consId;
	}
	public void setConsId(String consId) {
		this.consId = consId;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getSafetyManageName() {
		return safetyManageName;
	}
	public void setSafetyManageName(String safetyManageName) {
		this.safetyManageName = safetyManageName;
	}
	public String getSafetyManageNum() {
		return safetyManageNum;
	}
	public void setSafetyManageNum(String safetyManageNum) {
		this.safetyManageNum = safetyManageNum;
	}
	public String getSafetyManagecheckNum() {
		return safetyManagecheckNum;
	}
	public void setSafetyManagecheckNum(String safetyManagecheckNum) {
		this.safetyManagecheckNum = safetyManagecheckNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getSafetyId() {
		return safetyId;
	}
	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}
}
