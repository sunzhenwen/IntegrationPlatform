package com.tj.jst.inner.accessory.model;

import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ����model
 * 
 * @author Administrator
 *
 */
public class Accessory {

	private String id;// ����
	private String num;// ���
	private String message;// ��ʾ��Ϣ
	private String departmentId;// ��������id
	//���� 
	//1:��Ŀ������2:��ͬ������3:ʩ��ͼ����4:�����ල5:��ȫ�ල6:ʩ�����7:��������
	private String linkNum;
	private String linkName;
	private List<Upload> list = new ArrayList<Upload>();//����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(String linkNum) {
		this.linkNum = linkNum;
	}

	public List<Upload> getList() {
		return list;
	}

	public void setList(List<Upload> list) {
		this.list = list;
	}

}
