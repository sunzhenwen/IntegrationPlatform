package com.tj.jst.outside.business.singleProject.model;


/**
 * ���幤��
 * @author hhc
 *
 */
public class SingleProject {

	private long spId;//����
	private String prjId;//��Ŀ���� 
	private String prjNum;//������Ŀ���
	private String spNum;//��λ����
	private String buildingName;//��λ��(��)��������
	private String buildingArea;//�������(ƽ����)
	private String investAmount;//Ͷ�ʶ�(��Ԫ)
	private String overgroundArea;//���Ͻ������(ƽ����)
	private String undergroundArea;//���½������(ƽ����)
	private int overgroundNum;//���ϲ���
	private int undergroundNum;//���²���
	private String buildingHeight;//�����߶�(��)
	private String engineeringGrade;//���̵ȼ�   0:���� 1:����  2:С�� 
	private String lengthKm;//����(����)
	private String spanM;//���(��)
	private String prjStructureTypeNum;//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
	private String projectSize;//���̹�ģ
	private String other;//����
	//�����������Ŀ���ڱ�ţ�3��ʩ��ͼ��� 4����ȫ�ල 5��ʩ����� 6���������ձ���
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
