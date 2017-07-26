package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

public class PromiseShareCondition extends Condition {
	// ��ʼʱ��
	private String startDate;
	// ����ʱ��
	private String endDate;
	// ��Ŀ����
	private String prjName;
	// ��Ŀ���
	private String prjNum;
	// ��������ID
	private String deptId;
	// ״̬
	private String appType;
	//�����б���
	private String approvalCityId;
	//�����������
	private String approvalAreaId;

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and CREATEDATE >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and CREATEDATE <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		
		String sql = "select * from tbbuilderlicencemanage " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
		if (startDate != null && !"".equals(startDate)) {
			sb.append(" and CREATEDATE >= to_date('" + startDate
					+ "','yyyy/mm/dd')");
		}
		if (endDate != null && !"".equals(endDate)) {
			sb.append(" and CREATEDATE <= to_date('" + endDate
					+ "','yyyy/mm/dd')");
		}
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		
		String sqlCount = "select count(*) from tbbuilderlicencemanage "
				+ sb.toString();
		return sqlCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getApprovalCityId() {
		return approvalCityId;
	}

	public void setApprovalCityId(String approvalCityId) {
		this.approvalCityId = approvalCityId;
	}

	public String getApprovalAreaId() {
		return approvalAreaId;
	}

	public void setApprovalAreaId(String approvalAreaId) {
		this.approvalAreaId = approvalAreaId;
	}

}
