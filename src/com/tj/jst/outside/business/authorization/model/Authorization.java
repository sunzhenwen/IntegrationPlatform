package com.tj.jst.outside.business.authorization.model;




/**
 * 授权
 * @author hhc
 *
 */
public class Authorization {

	private String id;//主键
	private String prjId; //项目报建主键
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private String corpName; //企业名称
	private String corpCode; //企业组织机构代码
	private String auCorpName;//被授权企业名称
	private String auCorpCode;//被授权组织机构代码
	private String appDept;//审批单位id
	private String appDeptName;//审批单位名称
	private String enterpriseType;//企业类型
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getAppDept() {
		return appDept;
	}
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	public String getAppDeptName() {
		return appDeptName;
	}
	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
	}
	public String getAuCorpName() {
		return auCorpName;
	}
	public void setAuCorpName(String auCorpName) {
		this.auCorpName = auCorpName;
	}
	public String getAuCorpCode() {
		return auCorpCode;
	}
	public void setAuCorpCode(String auCorpCode) {
		this.auCorpCode = auCorpCode;
	}
	public String getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	
}
