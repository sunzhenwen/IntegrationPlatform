package com.tj.jst.outside.business.safety.model;

import java.sql.Date;

/**
 * ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
 * @author Administrator
 *
 */
public class ConstructionSafety {
	
	private String consId;//����
	private String prjId;//��Ŀ��������
	private String safetyId;
	private String safetyManageName;//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա����
	private String safetyManageNum;//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա��λ֤��
	private String safetyManagecheckNum;//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա��ȫ����֤��
	private Date createDate; //��¼�Ǽ�����
	
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
