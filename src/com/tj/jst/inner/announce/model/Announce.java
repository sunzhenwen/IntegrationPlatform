package com.tj.jst.inner.announce.model;

import java.sql.Date;

/**
 * 发布信息Model类
 * 
 * @author DarkFlameMaster
 *
 */
public class Announce {

	private String announceId;// 主键
	private String title;// 发布内容标题
	private String message;// 发布内容
	private String type;// 发布种类
	private Date date;// 发布时间
	private String url;// url网址
	private String isPublish;// 是否发布

	public String getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

}
