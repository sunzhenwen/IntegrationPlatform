package com.tj.jst.inner.integrity.personBadIntegrity.model;

import java.sql.Date;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public class PersonBadIntegrity {

	private String badPersonId; //����
	private String personName;//����
	private String idCardTypeNum;//֤������(�ֵ��TBIDCARDTYPEDIC)
	private String idCard18;//֤������
	private String specialtyTypNum;//��Ա����(�ֵ��TBSPECIALTYTYPEDIC)
	
	
	private String corpName; //������ҵ����
	private String corpCode; //������֯��������
	private String prjNum; //��Ŀ���
	private String prjName; //��������
	private String address; //���̵�ַ
	private String buildCorpName; //���赥λ
	private String buildCorpCode; //���赥λ��֯��������
	private String provinceNum; //������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
	private String cityNum; //������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
	private String countyNum; //������Ϊ������������(�ֵ��TBXZQDMDIC)
	private String creditClassNum; //������Ϊ����(�ֵ��TBCREDITTYPE)
	private String creditType; //������Ϊ���(�ֵ��TBCORPBADDIC)
	private String creditCode; //������Ϊ����(�ֵ��TBCORPBADDIC)
	private String content; //������Ϊ����
	private Date happenDate; //������Ϊ��������
	private String punishDepartName; //��������
	private String punishDepartType; //�������ż���0��������1��ʡ�У�2�����У�3������
	private String punishEvidence; //��������(�ֵ��TBCORPBADDIC)
	private String punishContent; //������������
	private String punishNumber; //���������ĺ�
	private Date punishDate; //��������
	private Date punishEDate; //������ֹ����
	private String punishMoney; //�������
	private String departName; //�Ǽǲ���
	private String departId;//�Ǽǲ���Id
	private String userName; //�Ǽ�������
	private Date createDate; //�Ǽ�����
	private String isPublic; //�Ƿ񷢲���0��δ������1���ѷ���
	private Date publicBDate; //������ʼʱ�䣨����ʱ����д��
	private Date publicEDate; //��������ʱ�䣨����ʱ����д��
	private String auditUserName; //����쵼������ʱ����д��
	private Date auditDate; //���ʱ�䣨����ʱ����д��
	private String delType;//ɾ��״̬ 0��δɾ����1����ɾ��
	
	public String getBadPersonId() {
		return badPersonId;
	}
	public void setBadPersonId(String badPersonId) {
		this.badPersonId = badPersonId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getIdCardTypeNum() {
		return idCardTypeNum;
	}
	public void setIdCardTypeNum(String idCardTypeNum) {
		this.idCardTypeNum = idCardTypeNum;
	}
	public String getIdCard18() {
		return idCard18;
	}
	public void setIdCard18(String idCard18) {
		this.idCard18 = idCard18;
	}
	public String getSpecialtyTypNum() {
		return specialtyTypNum;
	}
	public void setSpecialtyTypNum(String specialtyTypNum) {
		this.specialtyTypNum = specialtyTypNum;
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
	public String getCreditClassNum() {
		return creditClassNum;
	}
	public void setCreditClassNum(String creditClassNum) {
		this.creditClassNum = creditClassNum;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getHappenDate() {
		return happenDate;
	}
	public void setHappenDate(Date happenDate) {
		this.happenDate = happenDate;
	}
	public String getPunishDepartName() {
		return punishDepartName;
	}
	public void setPunishDepartName(String punishDepartName) {
		this.punishDepartName = punishDepartName;
	}
	public String getPunishDepartType() {
		return punishDepartType;
	}
	public void setPunishDepartType(String punishDepartType) {
		this.punishDepartType = punishDepartType;
	}
	public String getPunishEvidence() {
		return punishEvidence;
	}
	public void setPunishEvidence(String punishEvidence) {
		this.punishEvidence = punishEvidence;
	}
	public String getPunishContent() {
		return punishContent;
	}
	public void setPunishContent(String punishContent) {
		this.punishContent = punishContent;
	}
	public String getPunishNumber() {
		return punishNumber;
	}
	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}
	public Date getPunishDate() {
		return punishDate;
	}
	public void setPunishDate(Date punishDate) {
		this.punishDate = punishDate;
	}
	public Date getPunishEDate() {
		return punishEDate;
	}
	public void setPunishEDate(Date punishEDate) {
		this.punishEDate = punishEDate;
	}
	public String getPunishMoney() {
		return punishMoney;
	}
	public void setPunishMoney(String punishMoney) {
		this.punishMoney = punishMoney;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getDelType() {
		return delType;
	}
	public void setDelType(String delType) {
		this.delType = delType;
	}
}
