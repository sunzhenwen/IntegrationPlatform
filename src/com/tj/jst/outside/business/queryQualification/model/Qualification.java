package com.tj.jst.outside.business.queryQualification.model;

import java.sql.Date;

/**
 * 查询企业所拥有的资质信息
 * 
 * @author DarkFlameMaster
 *
 */
public class Qualification {

	// 外键
	private String CorpId;
	// 企业名称
	private String CorpName;
	// 组织机构代码
	private String CorpCode;
	// 资质资格类型（字典表TBAPTITUDEKINDDIC）
	private String CertTypeNum;
	// 资质资格名称
	private String CertTypeName;
	// 证书编号
	private String CertId;
	// 资质资格序列（字典表TBTRADETYPEDIC）
	private String TradeTypeNum;
	// 资质资格序列名称
	private String TradeTypeName;
	// 专业类别（字典表TBTRADETYPEBOUNDDIC）
	private String TradeBoundNum;
	// 专业类别名称
	private String TradeBoundName;
	// 资质资格等级（字典表TBCERTTITLELEVELDIC）
	private String TitleLevelNum;
	// 资质资格等级名称
	private String TitleLevelName;
	// 资质资格等级等级
	private String TitleLevelLevel;
	// 首次批准资质资格文号
	private String NoteNumber;
	// 是否主项资质
	private String IsMaster;
	// 批准资质资格内容
	private String Mark;
	// 首次批准资质资格日期
	private Date NoteDate;
	// 资质资格取得方式（字典表TBADDTYPEDIC）
	private String AddTypeNum;
	// 资质资格取得方式名称
	private String AddTypeName;
	// 资质资格状态（字典表TBCERTTRADESTATUSDIC）
	private String CertTradeStatusNum;
	// 资质资格状态名称
	private String CertTradeStatusName;
	// 资质资格状态变更时间
	private Date CertTradeModifyDate;
	// 资质资格状态变更原因
	private String CertTradeModifyMark;
	// 主键
	private String CertDetailId;
	// 更新时间
	private Date UpdateTime;
	// 老数据新数据
	private String OldorNew;
	// 数据库
	private String DateSource;
	// 外厅审批时间
	private Date floorDate;
	// 外厅审批意见
	private String floorOp;
	//资质类别及等级
	private String certName;
	
	private Date organDate ;

	public String getCorpId() {
		return CorpId;
	}

	public void setCorpId(String corpId) {
		CorpId = corpId;
	}

	public String getCorpName() {
		return CorpName;
	}

	public void setCorpName(String corpName) {
		CorpName = corpName;
	}

	public String getCorpCode() {
		return CorpCode;
	}

	public void setCorpCode(String corpCode) {
		CorpCode = corpCode;
	}

	public String getCertTypeNum() {
		return CertTypeNum;
	}

	public void setCertTypeNum(String certTypeNum) {
		CertTypeNum = certTypeNum;
	}

	public String getCertTypeName() {
		return CertTypeName;
	}

	public void setCertTypeName(String certTypeName) {
		CertTypeName = certTypeName;
	}

	public String getCertId() {
		return CertId;
	}

	public void setCertId(String certId) {
		CertId = certId;
	}

	public String getTradeTypeNum() {
		return TradeTypeNum;
	}

	public void setTradeTypeNum(String tradeTypeNum) {
		TradeTypeNum = tradeTypeNum;
	}

	public String getTradeTypeName() {
		return TradeTypeName;
	}

	public void setTradeTypeName(String tradeTypeName) {
		TradeTypeName = tradeTypeName;
	}

	public String getTradeBoundNum() {
		return TradeBoundNum;
	}

	public void setTradeBoundNum(String tradeBoundNum) {
		TradeBoundNum = tradeBoundNum;
	}

	public String getTradeBoundName() {
		return TradeBoundName;
	}

	public void setTradeBoundName(String tradeBoundName) {
		TradeBoundName = tradeBoundName;
	}

	public String getTitleLevelNum() {
		return TitleLevelNum;
	}

	public void setTitleLevelNum(String titleLevelNum) {
		TitleLevelNum = titleLevelNum;
	}

	public String getTitleLevelName() {
		return TitleLevelName;
	}

	public void setTitleLevelName(String titleLevelName) {
		TitleLevelName = titleLevelName;
	}

	public String getNoteNumber() {
		return NoteNumber;
	}

	public void setNoteNumber(String noteNumber) {
		NoteNumber = noteNumber;
	}

	public String getIsMaster() {
		return IsMaster;
	}

	public void setIsMaster(String isMaster) {
		IsMaster = isMaster;
	}

	public String getMark() {
		return Mark;
	}

	public void setMark(String mark) {
		Mark = mark;
	}

	public Date getNoteDate() {
		return NoteDate;
	}

	public void setNoteDate(Date noteDate) {
		NoteDate = noteDate;
	}

	public String getAddTypeNum() {
		return AddTypeNum;
	}

	public void setAddTypeNum(String addTypeNum) {
		AddTypeNum = addTypeNum;
	}

	public String getAddTypeName() {
		return AddTypeName;
	}

	public void setAddTypeName(String addTypeName) {
		AddTypeName = addTypeName;
	}

	public String getCertTradeStatusNum() {
		return CertTradeStatusNum;
	}

	public void setCertTradeStatusNum(String certTradeStatusNum) {
		CertTradeStatusNum = certTradeStatusNum;
	}

	public String getCertTradeStatusName() {
		return CertTradeStatusName;
	}

	public void setCertTradeStatusName(String certTradeStatusName) {
		CertTradeStatusName = certTradeStatusName;
	}

	public Date getCertTradeModifyDate() {
		return CertTradeModifyDate;
	}

	public void setCertTradeModifyDate(Date certTradeModifyDate) {
		CertTradeModifyDate = certTradeModifyDate;
	}

	public String getCertTradeModifyMark() {
		return CertTradeModifyMark;
	}

	public void setCertTradeModifyMark(String certTradeModifyMark) {
		CertTradeModifyMark = certTradeModifyMark;
	}

	public String getCertDetailId() {
		return CertDetailId;
	}

	public void setCertDetailId(String certDetailId) {
		CertDetailId = certDetailId;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public String getOldorNew() {
		return OldorNew;
	}

	public void setOldorNew(String oldorNew) {
		OldorNew = oldorNew;
	}

	public String getDateSource() {
		return DateSource;
	}

	public void setDateSource(String dateSource) {
		DateSource = dateSource;
	}

	public String getTitleLevelLevel() {
		return TitleLevelLevel;
	}

	public void setTitleLevelLevel(String titleLevelLevel) {
		TitleLevelLevel = titleLevelLevel;
	}

	public Date getFloorDate() {
		return floorDate;
	}

	public void setFloorDate(Date floorDate) {
		this.floorDate = floorDate;
	}

	public String getFloorOp() {
		return floorOp;
	}

	public void setFloorOp(String floorOp) {
		this.floorOp = floorOp;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public Date getOrganDate() {
		return organDate;
	}

	public void setOrganDate(Date organDate) {
		this.organDate = organDate;
	}

}
