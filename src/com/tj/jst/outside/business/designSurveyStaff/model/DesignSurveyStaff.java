package com.tj.jst.outside.business.designSurveyStaff.model;

import java.sql.Date;


/**
 * ���������ͼ��Ա
 * @author hhc
 *
 */
public class DesignSurveyStaff {

	private String dsId;//����
	private String prjNum;//��Ŀ���
	private String prjName;//��Ŀ����
	private String censorNum;//ʩ��ͼ���ϸ�֤����
	private String corpName;//������λ����
	private String corpCode;//������λ��֯��������
	private String userName;//��Ա����
	private String idCardTypeNum;//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCard;//��Ա֤�����룻���֤��18Ϊ
	private String specialtyTypNum;//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	private String prjDuty;//�е���ɫ(�ֵ��TBWORKDUTYDIC)
	private Date createDate;//��������
	private String conCorpCode;//������λ��֯��������
	private String conCorpName;//���쵥λ����

	
	public String getDsId() {
		return dsId;
	}
	public void setDsId(String dsId) {
		this.dsId = dsId;
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
	public String getCensorNum() {
		return censorNum;
	}
	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSpecialtyTypNum() {
		return specialtyTypNum;
	}
	public void setSpecialtyTypNum(String specialtyTypNum) {
		this.specialtyTypNum = specialtyTypNum;
	}
	public String getPrjDuty() {
		return prjDuty;
	}
	public void setPrjDuty(String prjDuty) {
		this.prjDuty = prjDuty;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getConCorpCode() {
		return conCorpCode;
	}
	public void setConCorpCode(String conCorpCode) {
		this.conCorpCode = conCorpCode;
	}
	public String getConCorpName() {
		return conCorpName;
	}
	public void setConCorpName(String conCorpName) {
		this.conCorpName = conCorpName;
	}
	
}
