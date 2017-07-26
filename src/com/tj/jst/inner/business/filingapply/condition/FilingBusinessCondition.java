package com.tj.jst.inner.business.filingapply.condition;

import com.tj.jst.base.page.Condition;

/**
 * 合同分页类
 * 
 * @author Administrator
 *
 */
public class FilingBusinessCondition extends Condition {

	private String conId;// 分页主键
	private String conName;// 合同名称

	public FilingBusinessCondition() {

	}


	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where RECORDID = '" + conId + "'");
		if (conName != null && !"".equals(conName)) {
			sb.append(" and CONNAME like '%" + conName.trim() + "%'");
		}
		String sql = "select * from TB_CONTRACTINFO_BUSINESS " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where RECORDID = '" + conId + "'");
		if (conName != null && !"".equals(conName)) {
			sb.append(" and CONNAME like '%" + conName.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_CONTRACTINFO_BUSINESS "
				+ sb.toString();
		return sqlCount;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

}
