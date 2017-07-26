package com.tj.jst.inner.business.scenesafe.condition;
 
import com.tj.jst.base.page.Condition;

public class querscenesafeadmincondition extends Condition {
	private String permitid;
	private String prjnamee;
	private String prjnumm;
	private String appDept;// 查询主键
	public querscenesafeadmincondition()
	{	
	}
 

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		//this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer("where permitid is not null"); 
		if (prjnumm != null && !"".equals(prjnumm)) {
			sb.append(" and prjnumm like '%" + prjnumm.trim() + "%'");
		}
		if (prjnamee != null && !"".equals(prjnamee)) {
			sb.append(" and PRJNAMEE like '%" + prjnamee.trim() + "%'");
		}
		
		String sql = "select * from tbscenesafe " + sb.toString();
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
		StringBuffer sb = new StringBuffer("where permitid is not null"); 
		if (prjnumm != null && !"".equals(prjnumm)) {
			sb.append(" and prjnumm like '%" + prjnumm.trim() + "%'");
		}
		if (prjnamee != null && !"".equals(prjnamee)) {
			sb.append(" and PRJNAMEE like '%" + prjnamee.trim() + "%'");
		}
		String sqlCount = "select count(*) from tbscenesafe " + sb.toString();
				
		return sqlCount;
	}

	public String getPermitid() {
		return permitid;
	}

	public void setPermitid(String permitid) {
		this.permitid = permitid;
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
