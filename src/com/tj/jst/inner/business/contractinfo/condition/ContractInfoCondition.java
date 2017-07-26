package com.tj.jst.inner.business.contractinfo.condition;

import com.tj.jst.base.page.Condition;

public class ContractInfoCondition extends Condition {

	private String conName;// 合同名称
	private String conType;// 合同类别

	public ContractInfoCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1 = 1 ");
		if (conName != null && !"".equals(conName)) {
			sb.append(" and conName like '%" + conName.trim() + "%'");
		}
		if (conType != null && !"".equals(conType)) {
			sb.append(" and conType like '%" + conType.trim() + "%'");
		}
		String sql = "select * from TB_CONTRACTINFO " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1 = 1 ");
		if (conName != null && !"".equals(conName)) {
			sb.append(" and conName like '%" + conName.trim() + "%'");
		}
		if (conType != null && !"".equals(conType)) {
			sb.append(" and conType like '%" + conType.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_CONTRACTINFO " + sb.toString();
		return sqlCount;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

}
