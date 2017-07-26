package com.tj.jst.inner.business.designapply.condition;

import com.tj.jst.base.page.Condition;

public class DesignQualificationCondition extends Condition {

	private String designId;

	public DesignQualificationCondition(String designId) {
		this.designId = designId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where designId = '" + designId
				+ "' ");
		String sql = "select * from DESIGN_QUALIFICATION  " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where designId = '" + designId
				+ "' ");
		String sqlCount = "select count(*) from DESIGN_QUALIFICATION "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

}
