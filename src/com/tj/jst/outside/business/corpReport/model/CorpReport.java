package com.tj.jst.outside.business.corpReport.model;

import java.sql.Date;



/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public class CorpReport {

	private String id;//����
	private String corpCode;//��ҵ��֯��������
	private String corpName;//��ҵ����
	private String provinceNum; 	//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
	private String cityNum; 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
	private String countyNum; 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
	private String reportYear;//��
	private String quarter;//����
	private String signContract;//ǩ����ͬ��
	private String lastYearContract;//�����ת��ͬ��
	private String thisYearContract;//������ǩ��ͬ��
	private String totalOutput;//����ҵ�ܲ�ֵ
	private String provinceOutside;//ʡ��
	private String abroad;//����
	private String construction;//��������
	private String erection;//��װ����
	private String decorate;//װ��װ�޹���
	private String settlementIncome;//���̽�������
	private String settlementCost;//���̽���ɱ�
	private String addedValue;//����ֵ
	private String reward;//��ҵ��Ա�Ͷ�����
	private String totalProfit;//��˰�ܶ�
	private String profit;//�����ܶ�
	private String employee;//��ҵ��Ա
	private String registered;//ע�Ὠ��ʦ
	private String ultimate;//�м�����ְ����Ա
	private String post;//��֤��λ��Ա
	private String technology;//�м����ϼ�������
	private String technicalEquipment;//����װ����
	private String laborProduction;//�Ͷ�����
	private String legalMan; 		//��λ������
	private String fillOut;//�����
	private String linkPhone;//��ϵ�绰
	private Date createDate; 		//�������
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
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
	public String getReportYear() {
		return reportYear;
	}
	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getSignContract() {
		return signContract;
	}
	public void setSignContract(String signContract) {
		this.signContract = signContract;
	}
	public String getLastYearContract() {
		return lastYearContract;
	}
	public void setLastYearContract(String lastYearContract) {
		this.lastYearContract = lastYearContract;
	}
	public String getThisYearContract() {
		return thisYearContract;
	}
	public void setThisYearContract(String thisYearContract) {
		this.thisYearContract = thisYearContract;
	}
	public String getTotalOutput() {
		return totalOutput;
	}
	public void setTotalOutput(String totalOutput) {
		this.totalOutput = totalOutput;
	}
	public String getProvinceOutside() {
		return provinceOutside;
	}
	public void setProvinceOutside(String provinceOutside) {
		this.provinceOutside = provinceOutside;
	}
	public String getAbroad() {
		return abroad;
	}
	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}
	public String getConstruction() {
		return construction;
	}
	public void setConstruction(String construction) {
		this.construction = construction;
	}
	public String getErection() {
		return erection;
	}
	public void setErection(String erection) {
		this.erection = erection;
	}
	public String getDecorate() {
		return decorate;
	}
	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}
	public String getSettlementIncome() {
		return settlementIncome;
	}
	public void setSettlementIncome(String settlementIncome) {
		this.settlementIncome = settlementIncome;
	}
	public String getSettlementCost() {
		return settlementCost;
	}
	public void setSettlementCost(String settlementCost) {
		this.settlementCost = settlementCost;
	}
	public String getAddedValue() {
		return addedValue;
	}
	public void setAddedValue(String addedValue) {
		this.addedValue = addedValue;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
	}
	public String getUltimate() {
		return ultimate;
	}
	public void setUltimate(String ultimate) {
		this.ultimate = ultimate;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTechnicalEquipment() {
		return technicalEquipment;
	}
	public void setTechnicalEquipment(String technicalEquipment) {
		this.technicalEquipment = technicalEquipment;
	}
	public String getLaborProduction() {
		return laborProduction;
	}
	public void setLaborProduction(String laborProduction) {
		this.laborProduction = laborProduction;
	}
	public String getLegalMan() {
		return legalMan;
	}
	public void setLegalMan(String legalMan) {
		this.legalMan = legalMan;
	}
	public String getFillOut() {
		return fillOut;
	}
	public void setFillOut(String fillOut) {
		this.fillOut = fillOut;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
