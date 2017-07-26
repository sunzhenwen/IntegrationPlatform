package com.tj.jst.outside.business.singleProject.model;


/**
 * 单体工程
 * @author hhc
 *
 */
public class SingleProject {

	private long spId;//主键
	private String prjId;//项目主键 
	private String prjNum;//主体项目编号
	private String spNum;//单位编码
	private String buildingName;//单位建(构)筑物名称
	private String buildingArea;//建筑面积(平方米)
	private String investAmount;//投资额(万元)
	private String overgroundArea;//地上建筑面积(平方米)
	private String undergroundArea;//地下建筑面积(平方米)
	private int overgroundNum;//地上层数
	private int undergroundNum;//地下层数
	private String buildingHeight;//建筑高度(米)
	private String engineeringGrade;//工程等级   0:大型 1:中型  2:小型 
	private String lengthKm;//长度(公里)
	private String spanM;//跨度(米)
	private String prjStructureTypeNum;//结构体系(TBPRJSTRUCTURETYPEDIC)
	private String projectSize;//工程规模
	private String other;//其它
	//产生单体的项目环节编号：3、施工图审查 4、安全监督 5、施工许可 6、竣工验收备案
	private String linkName;
	
	
	public long getSpId() {
		return spId;
	}
	public void setSpId(long spId) {
		this.spId = spId;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	public String getSpNum() {
		return spNum;
	}
	public void setSpNum(String spNum) {
		this.spNum = spNum;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}
	public String getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(String investAmount) {
		this.investAmount = investAmount;
	}
	public String getOvergroundArea() {
		return overgroundArea;
	}
	public void setOvergroundArea(String overgroundArea) {
		this.overgroundArea = overgroundArea;
	}
	public String getUndergroundArea() {
		return undergroundArea;
	}
	public void setUndergroundArea(String undergroundArea) {
		this.undergroundArea = undergroundArea;
	}
	public int getOvergroundNum() {
		return overgroundNum;
	}
	public void setOvergroundNum(int overgroundNum) {
		this.overgroundNum = overgroundNum;
	}
	public int getUndergroundNum() {
		return undergroundNum;
	}
	public void setUndergroundNum(int undergroundNum) {
		this.undergroundNum = undergroundNum;
	}
	public String getBuildingHeight() {
		return buildingHeight;
	}
	public void setBuildingHeight(String buildingHeight) {
		this.buildingHeight = buildingHeight;
	}
	public String getEngineeringGrade() {
		return engineeringGrade;
	}
	public void setEngineeringGrade(String engineeringGrade) {
		this.engineeringGrade = engineeringGrade;
	}
	public String getLengthKm() {
		return lengthKm;
	}
	public void setLengthKm(String lengthKm) {
		this.lengthKm = lengthKm;
	}
	public String getSpanM() {
		return spanM;
	}
	public void setSpanM(String spanM) {
		this.spanM = spanM;
	}
	public String getPrjStructureTypeNum() {
		return prjStructureTypeNum;
	}
	public void setPrjStructureTypeNum(String prjStructureTypeNum) {
		this.prjStructureTypeNum = prjStructureTypeNum;
	}
	public String getProjectSize() {
		return projectSize;
	}
	public void setProjectSize(String projectSize) {
		this.projectSize = projectSize;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
}
