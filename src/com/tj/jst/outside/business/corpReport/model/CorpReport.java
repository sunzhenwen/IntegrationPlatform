package com.tj.jst.outside.business.corpReport.model;

import java.sql.Date;



/**
 * 建筑企业统计报表
 * @author hhc
 *
 */
public class CorpReport {

	private String id;//主键
	private String corpCode;//企业组织机构代码
	private String corpName;//企业名称
	private String provinceNum; 	//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
	private String cityNum; 		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
	private String countyNum; 		//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
	private String reportYear;//年
	private String quarter;//季度
	private String signContract;//签订合同额
	private String lastYearContract;//上年结转合同额
	private String thisYearContract;//本年新签合同额
	private String totalOutput;//建筑业总产值
	private String provinceOutside;//省外
	private String abroad;//国外
	private String construction;//建筑工程
	private String erection;//安装工程
	private String decorate;//装饰装修工程
	private String settlementIncome;//工程结算收入
	private String settlementCost;//工程结算成本
	private String addedValue;//增加值
	private String reward;//从业人员劳动报酬
	private String totalProfit;//利税总额
	private String profit;//利润总额
	private String employee;//从业人员
	private String registered;//注册建造师
	private String ultimate;//中级以上职称人员
	private String post;//持证岗位人员
	private String technology;//中级以上技术工人
	private String technicalEquipment;//技术装备率
	private String laborProduction;//劳动生产
	private String legalMan; 		//单位负责人
	private String fillOut;//填表人
	private String linkPhone;//联系电话
	private Date createDate; 		//添加日期
	
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
