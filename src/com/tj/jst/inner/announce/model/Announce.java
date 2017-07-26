package com.tj.jst.inner.announce.model;

import java.sql.Date;

/**
 * ������ϢModel��
 * 
 * @author DarkFlameMaster
 *
 */
public class Announce {

	private String announceId;// ����
	private String title;// �������ݱ���
	private String message;// ��������
	private String type;// ��������
	private Date date;// ����ʱ��
	private String url;// url��ַ
	private String isPublish;// �Ƿ񷢲�

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
