package com.tj.jst.inner.industryStandard.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * ��ҵ��׼
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandard implements Serializable {

	private String isId;// ����
	private String title;// �������ݱ���
	private String message;// ��������
	private String isType;// ��������
	private Date releaseDate;//����ʱ��
	private Date createDate;// ����ʱ��
	private String isPublish;// �Ƿ񷢲�
	private String inputStaff;//¼����
	private String publishStaff;//������
	private String modifyStaff;//�޸���
	private String modifyDate;//�޸�ʱ��

	
	public String getIsId() {
		return isId;
	}
	public void setIsId(String isId) {
		this.isId = isId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIsType() {
		return isType;
	}
	public void setIsType(String isType) {
		this.isType = isType;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}
	public String getInputStaff() {
		return inputStaff;
	}
	public void setInputStaff(String inputStaff) {
		this.inputStaff = inputStaff;
	}
	public String getPublishStaff() {
		return publishStaff;
	}
	public void setPublishStaff(String publishStaff) {
		this.publishStaff = publishStaff;
	}
	public String getModifyStaff() {
		return modifyStaff;
	}
	public void setModifyStaff(String modifyStaff) {
		this.modifyStaff = modifyStaff;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

}
