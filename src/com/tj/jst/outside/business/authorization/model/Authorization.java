package com.tj.jst.outside.business.authorization.model;




/**
 * ��Ȩ
 * @author hhc
 *
 */
public class Authorization {

	private String id;//����
	private String prjId; //��Ŀ��������
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private String corpName; //��ҵ����
	private String corpCode; //��ҵ��֯��������
	private String auCorpName;//����Ȩ��ҵ����
	private String auCorpCode;//����Ȩ��֯��������
	private String appDept;//������λid
	private String appDeptName;//������λ����
	private String enterpriseType;//��ҵ����
	
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
