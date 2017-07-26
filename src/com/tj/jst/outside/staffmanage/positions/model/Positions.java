package com.tj.jst.outside.staffmanage.positions.model;

import java.sql.Date;


/**
 * 岗位人员
 * @author hhc
 *
 */
public class Positions {

	private String personId;//主键
	private String name;//名字
	private String cardId;//身份证
	private String sex;//性别
	private String entName;//企业名称
	private String duty;//岗位名称
	private String corpCode;//企业组织机构代码
	private String corpId;//企业主键
	private String provinceName;//省名称
	private String cityName;//市名称
	private String countyName;//区名称
	private String certNum;//证书编号
	private Date createDate;
	
	
	private String Gongzhang;		//施工员
	private String Anquan;			//安全员
	private String Cailiao;			//材料员
	private String Ziliao;			//资料员
	private String Zhiliang;		//质量员
	private String Zaojia;			//造价员
	private String Celiang;			//测量员
	private String Hetong;			//合同员
	private String Jishu;			//技术人员
	private String Jianzheng;		//见证员
	private String Quyang;			//取样人员
	private String Fuze;			//施工现场负责人
	
	

	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getGongzhang() {
		return Gongzhang;
	}
	public void setGongzhang(String gongzhang) {
		Gongzhang = gongzhang;
	}
	public String getAnquan() {
		return Anquan;
	}
	public void setAnquan(String anquan) {
		Anquan = anquan;
	}
	public String getCailiao() {
		return Cailiao;
	}
	public void setCailiao(String cailiao) {
		Cailiao = cailiao;
	}
	public String getZiliao() {
		return Ziliao;
	}
	public void setZiliao(String ziliao) {
		Ziliao = ziliao;
	}
	public String getZhiliang() {
		return Zhiliang;
	}
	public void setZhiliang(String zhiliang) {
		Zhiliang = zhiliang;
	}
	public String getZaojia() {
		return Zaojia;
	}
	public void setZaojia(String zaojia) {
		Zaojia = zaojia;
	}
	public String getCeliang() {
		return Celiang;
	}
	public void setCeliang(String celiang) {
		Celiang = celiang;
	}
	public String getHetong() {
		return Hetong;
	}
	public void setHetong(String hetong) {
		Hetong = hetong;
	}
	public String getJishu() {
		return Jishu;
	}
	public void setJishu(String jishu) {
		Jishu = jishu;
	}
	public String getJianzheng() {
		return Jianzheng;
	}
	public void setJianzheng(String jianzheng) {
		Jianzheng = jianzheng;
	}
	public String getQuyang() {
		return Quyang;
	}
	public void setQuyang(String quyang) {
		Quyang = quyang;
	}
	public String getFuze() {
		return Fuze;
	}
	public void setFuze(String fuze) {
		Fuze = fuze;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	
}
