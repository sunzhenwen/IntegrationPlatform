package com.tj.jst.outside.business.construction.model;

/**
 * 地域
 * @author hhc
 *
 */
public class Regional {

	private String id;//主键
	private String pId;//父id
	private String name;//地域名称
	private String open;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
}
