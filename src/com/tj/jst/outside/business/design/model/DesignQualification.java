package com.tj.jst.outside.business.design.model;


/**
 * ��Ƶ�λ����
 * @author hhc
 *
 */
public class DesignQualification {

	private String id;//����
	private String designId;//�������
	private String qualifName;//��������
	private String certTypeName;//��������
	private String titleLevelName;//���ʵȼ�
	private String certId;//֤����
	
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
	public String getCertTypeName() {
		return certTypeName;
	}
	public void setCertTypeName(String certTypeName) {
		this.certTypeName = certTypeName;
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
	public String getQualifName() {
		return qualifName;
	}
	public void setQualifName(String qualifName) {
		this.qualifName = qualifName;
	}

}
