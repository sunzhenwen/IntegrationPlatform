package com.tj.jst.inner.business.scenesafe.model;
 
import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.ContractCorpQualCondition;
import com.tj.jst.outside.business.quality.dao.ContractRecordDao;
import com.tj.jst.outside.business.quality.dao.ContractRecordDaoImpl;

public class ConstruScenesafe {
	private String prjid;//����
	private String permitid;// 
	private String jcneirong;//�������
	 private String question;//����
	 private String suggestion;//���
	public String getJcneirong() {
		return jcneirong;
	}
	public void setJcneirong(String jcneirong) {
		this.jcneirong = jcneirong;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
 
	public String getPrjid() {
		return prjid;
	}
	public void setPrjid(String prjid) {
		this.prjid = prjid;
	}
	public String getPermitid() {
		return permitid;
	}
	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}
 
	 
	 
}
