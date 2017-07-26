package com.tj.jst.inner.industryStandard.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 行业标准
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandard implements Serializable {

	private String isId;// 主键
	private String title;// 发布内容标题
	private String message;// 发布内容
	private String isType;// 发布种类
	private Date releaseDate;//发布时间
	private Date createDate;// 创建时间
	private String isPublish;// 是否发布
	private String inputStaff;//录入人
	private String publishStaff;//发布人
	private String modifyStaff;//修改人
	private String modifyDate;//修改时间

	
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
