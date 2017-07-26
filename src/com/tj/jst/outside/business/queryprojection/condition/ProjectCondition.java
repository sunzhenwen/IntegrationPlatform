package com.tj.jst.outside.business.queryprojection.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ��Ϣ��ҳ��
 * 
 * @author DarkFlameMaster
 *
 */
public class ProjectCondition extends Condition {

	// ��Ŀ����
	private String prjName;
	// �����ĺ�
	private String prjApprovalNum;
	// ���赥λ����
	private String buildCorpName;
	// ���赥λ��֯��������֤
	private String buildCorpCode;

	public ProjectCondition() {

	}

	public ProjectCondition(String prjName) {
		this.prjName = prjName;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		if (prjName != null) {
			try {
				prjName = URLDecoder.decode(prjName, "utf8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("����ת����������ϵ����Ա");
			}
		}
		StringBuffer sb = new StringBuffer(" where  prjNum is not null ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (prjApprovalNum != null && !"".equals(prjApprovalNum)) {
			sb.append(" and prjApprovalNum like '%" + prjApprovalNum.trim()
					+ "%'");
		}
		if (buildCorpName != null && !"".equals(buildCorpName)) {
			sb.append(" and buildCorpName like '%" + buildCorpName.trim()
					+ "%'");
		}
		if (buildCorpCode != null && !"".equals(buildCorpCode)) {
			sb.append(" and buildCorpCode like '%" + buildCorpCode.trim()
					+ "%'");
		}
		String sql = "select * from TBProjectInfo_S " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		if (prjName != null) {
			try {
				prjName = URLDecoder.decode(prjName, "utf8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("����ת����������ϵ����Ա");
			}
		}
		StringBuffer sb = new StringBuffer(" where  prjNum is not null ");

		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and prjName like '%" + prjName.trim() + "%'");
		}
		if (prjApprovalNum != null && !"".equals(prjApprovalNum)) {
			sb.append(" and prjApprovalNum like '%" + prjApprovalNum.trim()
					+ "%'");
		}
		if (buildCorpName != null && !"".equals(buildCorpName)) {
			sb.append(" and buildCorpName like '%" + buildCorpName.trim()
					+ "%'");
		}
		if (buildCorpCode != null && !"".equals(buildCorpCode)) {
			sb.append(" and buildCorpCode like '%" + buildCorpCode.trim()
					+ "%'");
		}
		String sqlCount = "select count(*) from TBProjectInfo_S "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

}
