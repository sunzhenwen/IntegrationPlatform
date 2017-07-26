package com.tj.jst.inner.personrecord.threeTypesPersonnel.condition;

import com.tj.jst.base.page.Condition;

public class ThreeTypesPersonnelCondition extends Condition {

	// ��Ա����
	private String FName;
	// ֤������
	private String FIdCertNo;
	// ��ҵ����
	private String FCertNumber;
	// ֤����
	private String FEntName;

	public ThreeTypesPersonnelCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where fState=0 ");
		if (FName != null && !"".equals(FName)) {
			sb.append(" and FName like '%" + FName.trim() + "%'");
		}
		if (FIdCertNo != null && !"".equals(FIdCertNo)) {
			sb.append(" and FIdCertNo like '%" + FIdCertNo.trim() + "%'");
		}
		if (FCertNumber != null && !"".equals(FCertNumber)) {
			sb.append(" and FCertNumber like '%" + FCertNumber.trim() + "%' ");
		}
		if (FEntName != null && !"".equals(FEntName)) {
			sb.append(" and FEntName like '%" + FEntName.trim() + "%'");
		}
		String sql = "select row_number() over(order by FRegDate desc) as rownumber, " +
				"FName, threetypepersonid, FIdCertNo, FEntName, fcerttype, FEntName1, " +
				"FCertNumber, fregdate, fregenddate, fstate, corpid FROM THREETYPE_PERSON"
				+ sb.toString();
		System.out.println("������Ա��ѯ��sql = " + sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where fState=0 ");
		if (FName != null && !"".equals(FName)) {
			sb.append(" and FName like '%" + FName.trim() + "%'");
		}
		if (FIdCertNo != null && !"".equals(FIdCertNo)) {
			sb.append(" and FEntName like '%" + FIdCertNo.trim() + "%'");
		}
		if (FCertNumber != null && !"".equals(FCertNumber)) {
			sb.append(" and FCertNumber like '%" + FCertNumber.trim() + "%' ");
		}
		if (FEntName != null && !"".equals(FEntName)) {
			sb.append(" and FEntName like '%" + FEntName.trim() + "%'");
		}
		String sqlCount = "select count(*) from THREETYPE_PERSON "
				+ sb.toString();
		return sqlCount;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getFIdCertNo() {
		return FIdCertNo;
	}

	public void setFIdCertNo(String FIdCertNo) {
		this.FIdCertNo = FIdCertNo;
	}

	public String getFCertNumber() {
		return FCertNumber;
	}

	public void setFCertNumber(String FCertNumber) {
		this.FCertNumber = FCertNumber;
	}

	public String getFEntName() {
		return FEntName;
	}

	public void setFEntName(String FEntName) {
		this.FEntName = FEntName;
	}

}
