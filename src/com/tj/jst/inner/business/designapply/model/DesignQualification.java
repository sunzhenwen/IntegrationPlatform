package com.tj.jst.inner.business.designapply.model;

public class DesignQualification {

	private String id;// 主键
	private String designId;// 设计主键
	private String cretTypeName;// 资质类型名称
	private String titleLevelName;// 资质等级名称
	private String certId;// 证书编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public String getCretTypeName() {
		return cretTypeName;
	}

	public void setCretTypeName(String cretTypeName) {
		this.cretTypeName = cretTypeName;
	}

	public String getTitleLevelName() {
		return titleLevelName;
	}

	public void setTitleLevelName(String titleLevelName) {
		this.titleLevelName = titleLevelName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

}
