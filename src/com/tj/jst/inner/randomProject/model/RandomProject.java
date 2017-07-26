package com.tj.jst.inner.randomProject.model;


/**
 * 随机项目
 * 
 * @author Administrator
 *
 */
public class RandomProject {

	private String id;//主键
	private String prjNum;//项目编号
	private String prjName;//项目名称
	private String appDeptName;//审批单位名称
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrjNum() {
		return prjNum;
	}
	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getAppDeptName() {
		return appDeptName;
	}
	public void setAppDeptName(String appDeptName) {
		this.appDeptName = appDeptName;
	}
	
}
