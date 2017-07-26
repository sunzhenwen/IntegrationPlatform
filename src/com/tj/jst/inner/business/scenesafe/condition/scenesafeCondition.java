package com.tj.jst.inner.business.scenesafe.condition;
import com.tj.jst.base.page.Condition;

/**
 * 施工许可分页类
 * 
 * @author DarkFlameMaster
 *
 */
public class scenesafeCondition extends Condition {
	private String appDept;// 查询主键
	// 项目名称
	private String prjnamee;
	// 项目编号
	private String prjnumm;
	public scenesafeCondition() {
		this.prjnumm = prjnumm;
	}

	public scenesafeCondition(String appDept) {
		this.appDept = appDept;
	}
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		//this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer("where appDept = '"+ appDept + "'");
		if (prjnumm != null && !"".equals(prjnumm)) {
			sb.append(" and prjNum like '%" + prjnumm.trim() + "%'");
		}
		if (prjnamee != null && !"".equals(prjnamee)) {
			sb.append(" and PRJNAME like '%" + prjnamee.trim() + "%'");
		}
		String sql = "select * from tbbuilderlicencemanage " + sb.toString();
		System.out.println(sql);
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 设置排序
		//this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer("where appDept = '"+ appDept + "'");

		if (prjnumm != null && !"".equals(prjnumm)) {
			sb.append(" and prjNum like '%" + prjnumm.trim() + "%'");
		}
		if (prjnamee != null && !"".equals(prjnamee)) {
			sb.append(" and PRJNAME like '%" + prjnamee.trim() + "%'");
		}
		String sqlCount = "select count(*) from tbbuilderlicencemanage "+ sb.toString();
				
		return sqlCount;
	}

	public String getPrjnamee() {
		return prjnamee;
	}

	public void setPrjnamee(String prjnamee) {
		this.prjnamee = prjnamee;
	}

	public String getPrjnumm() {
		return prjnumm;
	}

	public void setPrjnumm(String prjnumm) {
		this.prjnumm = prjnumm;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	

	 

 
}
