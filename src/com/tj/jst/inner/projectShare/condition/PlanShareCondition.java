package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

/**
 * ʩ��ͼ����ѯ
 * @author DarkFlameMaster
 *
 */
public class PlanShareCondition extends Condition {

	private String prjName; // ��Ŀ����
	private String censorCorpName; // ʩ��ͼ����������
	private String censorCorpCode; // ʩ��ͼ��������֯��������
	private String appDept;// ������λid
	private String appType;// ״̬

	@Override
	public String getInitialSql() {
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (censorCorpName != null && !"".equals(censorCorpName)) {
			sb.append(" and censorCorpName like '%" + censorCorpName.trim()
					+ "%'");
		}
		if (censorCorpCode != null && !"".equals(censorCorpCode)) {
			sb.append(" and censorCorpCode='" + censorCorpCode.trim() + "'");
		}

		String sql = "select * from TBPROJECTCENSORINFO " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (censorCorpName != null && !"".equals(censorCorpName)) {
			sb.append(" and censorCorpName like '%" + censorCorpName.trim()
					+ "%'");
		}
		if (censorCorpCode != null && !"".equals(censorCorpCode)) {
			sb.append(" and censorCorpCode='" + censorCorpCode.trim() + "'");
		}
		
		String sqlCount = "select count(*) from TBPROJECTCENSORINFO "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getCensorCorpName() {
		return censorCorpName;
	}

	public void setCensorCorpName(String censorCorpName) {
		this.censorCorpName = censorCorpName;
	}

	public String getCensorCorpCode() {
		return censorCorpCode;
	}

	public void setCensorCorpCode(String censorCorpCode) {
		this.censorCorpCode = censorCorpCode;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
