package com.tj.jst.inner.codeChange.model;

import java.sql.Date;

/**
 * ��֯����������
 * @author hhc 2016-04-21
 *
 */
public class CodeChange {

	private String codeChangeId;//����
	private String corpId;//��ҵ����
	private String corpName;//��ҵ����
	private String oldCode;//ԭ��֯��������(���ǰ)
	private String newCode;//����֯��������(�����)
	private Date createDate;//���ʱ��
	
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
