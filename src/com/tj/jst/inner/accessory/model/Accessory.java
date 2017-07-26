package com.tj.jst.inner.accessory.model;

import java.util.ArrayList;
import java.util.List;

import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 附件model
 * 
 * @author Administrator
 *
 */
public class Accessory {

	private String id;// 主键
	private String num;// 序号
	private String message;// 提示信息
	private String departmentId;// 审批部门id
	//环节 
	//1:项目报建、2:合同备案、3:施工图备案4:质量监督5:安全监督6:施工许可7:竣工验收
	private String linkNum;
	private String linkName;
	private List<Upload> list = new ArrayList<Upload>();//附件
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
