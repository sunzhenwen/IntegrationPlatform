package com.tj.jst.inner.business.scenesafe.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ�����model��
 * 
 * @author DarkFlameMaster
 *
 */
public class SceneSafe {
	 private String permitid;//����
	 private String prjnamee;//��Ŀ����
	 private String prjnumm;//��Ŀ���
	 private String builderlicencenum;//ʩ�����֤���
	 private String jcporson;//�����
	 private Date   jcdate;//���ʱ��
	 private String fzporson;//�ֳ�������
	 private String djporson;//�Ǽ���
	 private Date   djdate;//�Ǽ�ʱ��
	 private String companyjc;//�漰���赥λ
	 private String companykc;//�漰���쵥λ
	 private String companysj;//�漰��Ƶ�λ
	 private String companyjl;//�漰����λ
	 private String companysg;//�漰ʩ����λ
	 private String nrdescription;//�����������
	 private String jcconclusion;;//������
	 private String clsuggestion;//�������
	 private String clgist;//��������
	 private String jcneirong;//�������
	 private String question;//����
	 private String suggestion;//���
	 private String appDept;// ��ѯ����
	 private List<Upload> list = new ArrayList<Upload>();//����

	private List<ConstruScenesafe> construscenesafe=new ArrayList<ConstruScenesafe>(); 
	public String getPrjnamee() {
		return prjnamee;
	}
	public void setPrjnamee(String prjnamee) {
		this.prjnamee = prjnamee;
	}
	 
	public String getPrjnumm() {
		return prjnumm;
	}
	public void setPrjnumm(String prjnumm) {
		this.prjnumm = prjnumm;
	}
	public String getBuilderlicencenum() {
		return builderlicencenum;
	}
	public void setBuilderlicencenum(String builderlicencenum) {
		this.builderlicencenum = builderlicencenum;
	}
	public String getJcporson() {
		return jcporson;
	}
	public void setJcporson(String jcporson) {
		this.jcporson = jcporson;
	}
	public Date getJcdate() {
		return jcdate;
	}
	public void setJcdate(Date jcdate) {
		this.jcdate = jcdate;
	}
	public String getFzporson() {
		return fzporson;
	}
	public void setFzporson(String fzporson) {
		this.fzporson = fzporson;
	}
	public String getDjporson() {
		return djporson;
	}
	public void setDjporson(String djporson) {
		this.djporson = djporson;
	}
	public Date getDjdate() {
		return djdate;
	}
	public void setDjdate(Date djdate) {
		this.djdate = djdate;
	}
	public String getCompanyjc() {
		return companyjc;
	}
	public void setCompanyjc(String companyjc) {
		this.companyjc = companyjc;
	}
	public String getCompanykc() {
		return companykc;
	}
	public void setCompanykc(String companykc) {
		this.companykc = companykc;
	}
	public String getCompanysj() {
		return companysj;
	}
	public void setCompanysj(String companysj) {
		this.companysj = companysj;
	}
	public String getCompanyjl() {
		return companyjl;
	}
	public void setCompanyjl(String companyjl) {
		this.companyjl = companyjl;
	}
	public String getCompanysg() {
		return companysg;
	}
	public void setCompanysg(String companysg) {
		this.companysg = companysg;
	}
	public String getNrdescription() {
		return nrdescription;
	}
	public void setNrdescription(String nrdescription) {
		this.nrdescription = nrdescription;
	}
	public String getJcconclusion() {
		return jcconclusion;
	}
	public void setJcconclusion(String jcconclusion) {
		this.jcconclusion = jcconclusion;
	}
	public String getClsuggestion() {
		return clsuggestion;
	}
	public void setClsuggestion(String clsuggestion) {
		this.clsuggestion = clsuggestion;
	}
	public String getClgist() {
		return clgist;
	}
	public void setClgist(String clgist) {
		this.clgist = clgist;
	}
	public String getPermitid() {
		return permitid;
	}
	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}
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
	public List<ConstruScenesafe> getConstruscenesafe() {
		return construscenesafe;
	}
	public void setConstruscenesafe(List<ConstruScenesafe> construscenesafe) {
		this.construscenesafe = construscenesafe;
	}
	public List<Upload> getList() {
		return list;
	}
	public void setList(List<Upload> list) {
		this.list = list;
	}
	public String getAppDept() {
		return appDept;
	}
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
 
}
