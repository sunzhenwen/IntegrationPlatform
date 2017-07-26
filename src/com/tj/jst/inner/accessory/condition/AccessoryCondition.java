package com.tj.jst.inner.accessory.condition;

import com.tj.jst.base.page.Condition;

/**
 * 分页类
 * 
 * @author Administrator
 *
 */
public class AccessoryCondition extends Condition {

	private String linkNum;
	private String message;
	private String departmentId;// 审批部门Id

	public AccessoryCondition(String departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (message != null && !"".equals(message)) {
			sb.append(" and message like '%" + message.trim() + "%'");
		}
		if (linkNum != null && !"".equals(linkNum)) {
			sb.append(" and linkNum ="+linkNum+"");
		}
		String sql = "select * from v_ACCESSORY_linkname " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (message != null && !"".equals(message)) {
			sb.append(" and message like '%" + message.trim() + "%'");
		}
		if (linkNum != null && !"".equals(linkNum)) {
			sb.append(" and linkNum ="+linkNum+"");
		}
		String sqlCount = "select count(*) from v_ACCESSORY_linkname " + sb.toString();
		return sqlCount;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(String linkNum) {
		this.linkNum = linkNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
