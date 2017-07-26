package com.tj.jst.outside.business.tenderInfo.condition;

import com.tj.jst.base.page.Condition;

/**
 * 招投标
 * @author hhc
 *
 */
public class TenderInfoCondition extends Condition {

	//项目编号
	private String prjNum;
	
	public TenderInfoCondition()
	{
		
	}
	
	public TenderInfoCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where prjNum='"+prjNum+"' ");
		
//		if(prjNum!= null && !"".equals(prjNum)){
//			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
//		}
		
		String sql = "select * from V_TBTENDERINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where prjNum='"+prjNum+"' ");
				
//		if(prjNum!= null && !"".equals(prjNum)){
//			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
//		}
		String sqlCount="select count(*) from V_TBTENDERINFO "+sb.toString();
		return sqlCount;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

}
