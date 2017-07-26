package com.tj.jst.inner.projectconstruction.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ����ʱ �� �����ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectPageCondition extends Condition {

	private String prjId;// ��ѯ����

	public ProjectPageCondition(String prjId) {
		this.prjId = prjId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where t.prjId = '" + prjId + "' ");
		String sql = "select * from TBPROJECTINFO_SINGLE t " + sb.toString();
		System.out.println("sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where prjId = '" + prjId + "' ");
		String sqlCount = "select count(*) from TBPROJECTINFO_SINGLE "
				+ sb.toString();
		System.out.println("sqlCount = " + sqlCount);
		return sqlCount;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

}
