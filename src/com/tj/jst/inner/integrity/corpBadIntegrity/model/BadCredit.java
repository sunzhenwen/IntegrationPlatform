package com.tj.jst.inner.integrity.corpBadIntegrity.model;

/**
 * ��ҵ������Ϊ
 * @author hhc
 *
 */
public class BadCredit {

	private int corpBad; //����
	private String beHavior; //��Ϊ���
	private String beHviorCode; //��Ϊ����
	private String badBeHavior; //������Ϊ
	private String legalBasis; //��������
	private String punishBasis; //��������
	
	public int getCorpBad() {
		return corpBad;
	}
	public void setCorpBad(int corpBad) {
		this.corpBad = corpBad;
	}
	public String getBeHavior() {
		return beHavior;
	}
	public void setBeHavior(String beHavior) {
		this.beHavior = beHavior;
	}
	public String getBeHviorCode() {
		return beHviorCode;
	}
	public void setBeHviorCode(String beHviorCode) {
		this.beHviorCode = beHviorCode;
	}
	public String getBadBeHavior() {
		return badBeHavior;
	}
	public void setBadBeHavior(String badBeHavior) {
		this.badBeHavior = badBeHavior;
	}
	public String getLegalBasis() {
		return legalBasis;
	}
	public void setLegalBasis(String legalBasis) {
		this.legalBasis = legalBasis;
	}
	public String getPunishBasis() {
		return punishBasis;
	}
	public void setPunishBasis(String punishBasis) {
		this.punishBasis = punishBasis;
	}
	
}
