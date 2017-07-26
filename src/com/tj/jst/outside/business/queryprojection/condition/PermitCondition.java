package com.tj.jst.outside.business.queryprojection.condition;

import com.tj.jst.base.page.Condition;

/**
 * 施工学科分页工具
 * 
 * @author DarkFlameMaster
 *
 */
public class PermitCondition extends Condition {

	private String prjNum;// 查询主键

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
