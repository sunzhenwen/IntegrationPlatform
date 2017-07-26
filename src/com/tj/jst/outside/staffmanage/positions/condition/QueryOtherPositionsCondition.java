package com.tj.jst.outside.staffmanage.positions.condition;

import com.tj.jst.base.page.Condition;

/**
 * 查询外省岗位人员
 * @author Administrator
 *
 */
public class QueryOtherPositionsCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String cardId;
	//企业名称
	private String corpName;
	//岗位名称
	private String duty;
	//企业主键
	private String corpId;
	
	public QueryOtherPositionsCondition()
	{
		
	}
	
	public QueryOtherPositionsCondition(String corpId)
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
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(cardId != null && !"".equals(cardId)){
			sb.append(" and cardId like '"+cardId.trim()+"%'");
		}
		String sql = "select * from POSITION_CERTIFICATE"+sb.toString();
		System.out.println("sql= "+sql);
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
			sb.append(" and name like '"+personName.trim()+"%'"); 
		}
		if(cardId != null && !"".equals(cardId)){
			sb.append(" and cardId like '"+cardId.trim()+"%'");
		}
		String sqlCount = "select count(*) from POSITION_CERTIFICATE"+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
