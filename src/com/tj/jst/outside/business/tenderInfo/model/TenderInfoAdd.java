package com.tj.jst.outside.business.tenderInfo.model;

import java.sql.Date;

/**
 * ��Ͷ��(��ʱ�����Ͷ��ʹ��)
 * @author hhc
 *
 */
public class TenderInfoAdd {

	private String tenderNum;//�б�֪ͨ����
	private String prjName;//��Ŀ����
	private String prjNum;//��Ŀ���
	private String tenderClassNum;//�б�����(TBTENDERCLASSDIC)
	private String tenderTypeNum;//�б귽ʽ(TBTENDERTYPEDIC)
	private Date tenderResultDate;//�б�����
	private String tenderMoney;//�б���
	private String prjSize;//�����ģ(ʩ�����)
	private String area;//�������(ƽ����)
	private String agencyCorpName;//�б����λ����
	private String agencyCorpCode;//�б����λ��֯��������
	private String tenderCorpName;//�б굥λ����
	private String tenderCorpCode;//�б굥λ��֯��������
	private String constructorName;//��Ŀ��������
	private String idCardTypeNum;//��ȫ��������֤������(TBIDCARDTYPEDIC)
	private String constructorIdCard;//��Ŀ����֤������
	private Date createDate;//��¼�Ǽ�ʱ��
	private String sectionName;//�������
	private String unionCorpName;//������а���λ����
	private String unionCorpCode;//������а���λ��֯����
	private String projectAddress;//��Ŀ��ַ
	private String projectCost;//�������
	private String propietorCorpName;//������λ����
	private String propietorCorpCode;//������λס��֯����
	//ISDELETE	NUMBER(2)	Y			ɾ��״̬ 0�������� 1��ɾ��
	//private String STATE	NUMBER(2)	Y			����״̬ 0δ���� 1�Ѵ��� 2����
	
	public String getTenderNum() {
		return tenderNum;
	}
	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getTenderClassNum() {
		return tenderClassNum;
	}
	public void setTenderClassNum(String tenderClassNum) {
		this.tenderClassNum = tenderClassNum;
	}
	public String getTenderTypeNum() {
		return tenderTypeNum;
	}
	public void setTenderTypeNum(String tenderTypeNum) {
		this.tenderTypeNum = tenderTypeNum;
	}
	public Date getTenderResultDate() {
		return tenderResultDate;
	}
	public void setTenderResultDate(Date tenderResultDate) {
		this.tenderResultDate = tenderResultDate;
	}
	public String getTenderMoney() {
		return tenderMoney;
	}
	public void setTenderMoney(String tenderMoney) {
		this.tenderMoney = tenderMoney;
	}
	public String getPrjSize() {
		return prjSize;
	}
	public void setPrjSize(String prjSize) {
		this.prjSize = prjSize;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAgencyCorpName() {
		return agencyCorpName;
	}
	public void setAgencyCorpName(String agencyCorpName) {
		this.agencyCorpName = agencyCorpName;
	}
	public String getAgencyCorpCode() {
		return agencyCorpCode;
	}
	public void setAgencyCorpCode(String agencyCorpCode) {
		this.agencyCorpCode = agencyCorpCode;
	}
	public String getTenderCorpName() {
		return tenderCorpName;
	}
	public void setTenderCorpName(String tenderCorpName) {
		this.tenderCorpName = tenderCorpName;
	}
	public String getTenderCorpCode() {
		return tenderCorpCode;
	}
	public void setTenderCorpCode(String tenderCorpCode) {
		this.tenderCorpCode = tenderCorpCode;
	}
	public String getConstructorName() {
		return constructorName;
	}
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getConstructorIdCard() {
		return constructorIdCard;
	}
	public void setConstructorIdCard(String constructorIdCard) {
		this.constructorIdCard = constructorIdCard;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getUnionCorpName() {
		return unionCorpName;
	}
	public void setUnionCorpName(String unionCorpName) {
		this.unionCorpName = unionCorpName;
	}
	public String getUnionCorpCode() {
		return unionCorpCode;
	}
	public void setUnionCorpCode(String unionCorpCode) {
		this.unionCorpCode = unionCorpCode;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(String projectCost) {
		this.projectCost = projectCost;
	}
	public String getPropietorCorpName() {
		return propietorCorpName;
	}
	public void setPropietorCorpName(String propietorCorpName) {
		this.propietorCorpName = propietorCorpName;
	}
	public String getPropietorCorpCode() {
		return propietorCorpCode;
	}
	public void setPropietorCorpCode(String propietorCorpCode) {
		this.propietorCorpCode = propietorCorpCode;
	}

}
