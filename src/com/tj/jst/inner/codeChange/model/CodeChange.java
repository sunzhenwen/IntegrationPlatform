package com.tj.jst.inner.codeChange.model;

import java.sql.Date;

/**
 * 组织机构代码变更
 * @author hhc 2016-04-21
 *
 */
public class CodeChange {

	private String codeChangeId;//主键
	private String corpId;//企业主键
	private String corpName;//企业名称
	private String oldCode;//原组织机构代码(变更前)
	private String newCode;//新组织机构代码(变更后)
	private Date createDate;//变更时间
	
	public String getCodeChangeId() {
		return codeChangeId;
	}
	public void setCodeChangeId(String codeChangeId) {
		this.codeChangeId = codeChangeId;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	public String getNewCode() {
		return newCode;
	}
	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
}
