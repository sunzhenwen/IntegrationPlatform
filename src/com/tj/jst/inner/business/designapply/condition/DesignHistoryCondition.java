package com.tj.jst.inner.business.designapply.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʷ��ѯ��ҳ
 * 
 * @author DarkFlameMaster
 *
 */
public class DesignHistoryCondition extends Condition {

	// ��Ŀ����
	private String prjName;
	// ��Ŀ���
	private String prjNum;
	// �������
	private String designNum;
	// ���칫˾����
	private String designCorpName;
	// ���칫˾��֯��������֤
	private String designCorpCode;
	// ��������Id
	private String deptId;
	// ״̬
	private String appType;

	public DesignHistoryCondition(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where  appDept = '" + deptId
				+ "' ");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (designNum != null && !"".equals(designNum)) {
			sb.append(" and designNum like '%" + designNum.trim() + "%'");
		}
		if (designCorpName != null && !"".equals(designCorpName)) {
			sb.append(" and designCorpName like '%" + designCorpName.trim()
					+ "%'");
		}
		if (designCorpCode != null && !"".equals(designCorpCode)) {
			sb.append(" and designCorpCode like '%" + designCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}

		String sql = "select * from DESIGN_BUSINESS " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		StringBuffer sb = new StringBuffer(" where  appDept = '" + deptId
				+ "' ");

		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (designNum != null && !"".equals(designNum)) {
			sb.append(" and designNum like '%" + designNum.trim() + "%'");
		}
		if (designCorpName != null && !"".equals(designCorpName)) {
			sb.append(" and designCorpName like '%" + designCorpName.trim()
					+ "%'");
		}
		if (designCorpCode != null && !"".equals(designCorpCode)) {
			sb.append(" and designCorpCode like '%" + designCorpCode.trim()
					+ "%'");
		}
		if (appType != null && !"".equals(appType)) {
			sb.append(" and apptype like '%" + appType.trim() + "%'");
		}
		String sqlCount = "select count(*) from DESIGN_BUSINESS "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getDesignNum() {
		return designNum;
	}

	public void setDesignNum(String designNum) {
		this.designNum = designNum;
	}

	public String getDesignCorpName() {
		return designCorpName;
	}

	public void setDesignCorpName(String designCorpName) {
		this.designCorpName = designCorpName;
	}

	public String getDesignCorpCode() {
		return designCorpCode;
	}

	public void setDesignCorpCode(String designCorpCode) {
		this.designCorpCode = designCorpCode;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}