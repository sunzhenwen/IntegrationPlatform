package com.tj.jst.outside.business.queryprojection.condition;

import com.tj.jst.base.page.Condition;

/**
 * ʩ��ѧ�Ʒ�ҳ����
 * 
 * @author DarkFlameMaster
 *
 */
public class PermitCondition extends Condition {

	private String prjNum;// ��ѯ����

	public PermitCondition(String prjNum) {
		this.prjNum = prjNum;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		if (prjNum != null) {

		} else {

		}
		return null;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		if (prjNum != null) {

		} else {

		}
		return null;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

}
