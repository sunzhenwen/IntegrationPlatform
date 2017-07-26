package com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition;

import com.tj.jst.base.page.Condition;

/**
 * 查询企业人员
 * @author Administrator
 *
 */
public class QueryPrjStaffCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String idCard;
	private String corpCode;

	public QueryPrjStaffCondition()
	{
		
	}
	
	public QueryPrjStaffCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and cardid like '"+idCard.trim()+"%'");
		}
		
		String sql = "select * from other_project_staff"+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and cardid like '"+idCard.trim()+"%'");
		}
		
		String sqlCount="select count(*) from other_project_staff "+sb.toString();
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
