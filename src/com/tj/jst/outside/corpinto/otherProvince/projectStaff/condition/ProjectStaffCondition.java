package com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition;

import com.tj.jst.base.page.Condition;

/**
 * 外省项目,人员备案
 * @author Administrator
 *
 */
public class ProjectStaffCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String idCard;
	//企业id
	private String corpId;
	//外省备案项目主键
	private String otherPrjId;
	
	public ProjectStaffCondition()
	{
		
	}
	
	public ProjectStaffCondition(String corpId)
	{
		this.corpId = corpId;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and IDCARD18 like '"+idCard.trim()+"%'");
		}
		if(otherPrjId != null && !"".equals(otherPrjId)){
			sb.append(" and otherPrjId like '"+otherPrjId.trim()+"%'");
		}
		
		String sql = "select * from OTHER_PROJECT_CONSTRUCTOR"+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and IDCARD18 like '"+idCard.trim()+"%'");
		}
		if(otherPrjId != null && !"".equals(otherPrjId)){
			sb.append(" and otherPrjId like '"+otherPrjId.trim()+"%'");
		}
		
		String sqlCount="select count(*) from OTHER_PROJECT_CONSTRUCTOR "+sb.toString();
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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}
	
}
