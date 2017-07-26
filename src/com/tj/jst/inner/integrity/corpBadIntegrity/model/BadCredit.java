package com.tj.jst.inner.integrity.corpBadIntegrity.model;

/**
 * 企业不良行为
 * @author hhc
 *
 */
public class BadCredit {

	private int corpBad; //主键
	private String beHavior; //行为类别
	private String beHviorCode; //行为代码
	private String badBeHavior; //不良行为
	private String legalBasis; //法律依据
	private String punishBasis; //处罚依据
	
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
