package com.tj.jst.inner.projectconstruction.model;

import java.sql.Date;

/**
 * ��ȨModel��
 * 
 * @author Administrator
 *
 */
public class Author {

	private String id;// ����
	private String prjId;// ��Ŀ����
	private String prjNum;// ��Ŀ����
	private String prjName;// ��Ŀ����
	private String appDept;// ������λ����
	private String appDeptName;// ������λ����
	private String corpName;// ��ҵ����
	private String corpCode;// ��ҵ��֯��������֤
	private Date createDate;// ����ʱ��

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
