package com.tj.jst.inner.integrity.corpGoodIntegrity.model;

import java.sql.Date;


/**
 * ��ҵ������Ϊ��Ϣ���ݱ�
 * @author DarkFlameMaster
 *
 */
public class CorpGoodIntegrity {
	
	private String corpGoodCreditId;						//����
	private String corpName; 								//��ҵ����
	private String corpCode; 								//��֯��������
	private String certTypeNum; 							//��ҵ����(�ֵ��TBAPTITUDEKINDDIC)
	private String prjNum;								 	//��Ŀ���
	private String prjName; 								//��������
	private String address; 								//���̵�ַ
	private String buildCorpName; 							//���赥λ
	private String buildCorpCode; 							//���赥λ��֯��������
	private String provinceNum; 							//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
	private String cityNum; 								//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
	private String countyNum; 								//������Ϊ������������(�ֵ��TBXZQDMDIC)
	private String awardDepartName;							//��������	0:������1��ʡ�У�2�����У�3�����أ�
	private String awardDepartType;							//�������ż���
	private String awardContent;							//������������
	private String awardNumber;								//���������ĺ�
	private Date   awardDate;								//��������
	private String departName;								//�Ǽǲ���
	private String UserName;								//�Ǽ���
	private Date   createDate;								//�Ǽ�����
	private String isPublic;								//�Ƿ񷢲�	0��δ������ 1���ѷ�����
	private Date   publicBDate;								//������ʼʱ�䣨����ʱ����д��
	private Date   publicEDate;								//��������ʱ�䣨����ʱ����д��
	private String auditUserName;							//����쵼������ʱ����д��
	private Date   auditDate;								//���ʱ�䣨����ʱ����д��
	private String departId;								//�Ǽǲ���Id
	
	public String getCorpGoodCreditId() {
		return corpGoodCreditId;
	}
	public void setCorpGoodCreditId(String corpGoodCreditId) {
		this.corpGoodCreditId = corpGoodCreditId;
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
	public String getCertTypeNum() {
		return certTypeNum;
	}
	public void setCertTypeNum(String certTypeNum) {
		this.certTypeNum = certTypeNum;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildCorpName() {
		return buildCorpName;
	}
	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}
	public String getBuildCorpCode() {
		return buildCorpCode;
	}
	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}
	public String getProvinceNum() {
		return provinceNum;
	}
	public void setProvinceNum(String provinceNum) {
		this.provinceNum = provinceNum;
	}
	public String getCityNum() {
		return cityNum;
	}
	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
	public String getCountyNum() {
		return countyNum;
	}
	public void setCountyNum(String countyNum) {
		this.countyNum = countyNum;
	}
	public String getAwardDepartName() {
		return awardDepartName;
	}
	public void setAwardDepartName(String awardDepartName) {
		this.awardDepartName = awardDepartName;
	}
	public String getAwardDepartType() {
		return awardDepartType;
	}
	public void setAwardDepartType(String awardDepartType) {
		this.awardDepartType = awardDepartType;
	}
	public String getAwardContent() {
		return awardContent;
	}
	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}
	public String getAwardNumber() {
		return awardNumber;
	}
	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}
	public Date getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public Date getPublicBDate() {
		return publicBDate;
	}
	public void setPublicBDate(Date publicBDate) {
		this.publicBDate = publicBDate;
	}
	public Date getPublicEDate() {
		return publicEDate;
	}
	public void setPublicEDate(Date publicEDate) {
		this.publicEDate = publicEDate;
	}
	public String getAuditUserName() {
		return auditUserName;
	}
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	
}
