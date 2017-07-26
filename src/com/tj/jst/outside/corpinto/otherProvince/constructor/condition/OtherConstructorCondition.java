package com.tj.jst.outside.corpinto.otherProvince.constructor.condition;

import com.tj.jst.base.page.Condition;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public class OtherConstructorCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String idCard;
	//学历
	private String eduLevelNum;
	//学位
	private String degreeNum;
	//企业id
	private String corpId;
	private String corpCode;
	
	public OtherConstructorCondition()
	{
		
	}
	
	public OtherConstructorCondition(String corpCode)
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
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(eduLevelNum!= null && !"".equals(eduLevelNum)){
			sb.append(" and EDULEVELNUM = '"+Integer.parseInt(eduLevelNum.trim())+"'"); 
		}
		if(degreeNum != null && !"".equals(degreeNum)){
			sb.append(" and DEGREENUM = '"+Integer.parseInt(degreeNum.trim())+"'");
		}
		
		String sql = "select * from V_CONSTRUCTOR"+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpCode='"+corpCode+"' ");
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(eduLevelNum!= null && !"".equals(eduLevelNum)){
			sb.append(" and EDULEVELNUM = '"+Integer.parseInt(eduLevelNum.trim())+"'"); 
		}
		if(degreeNum != null && !"".equals(degreeNum)){
			sb.append(" and DEGREENUM = '"+Integer.parseInt(degreeNum.trim())+"'");
		}
		String sqlCount="select count(*) from V_CONSTRUCTOR "+sb.toString();
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

	public String getEduLevelNum() {
		return eduLevelNum;
	}

	public void setEduLevelNum(String eduLevelNum) {
		this.eduLevelNum = eduLevelNum;
	}

	public String getDegreeNum() {
		return degreeNum;
	}

	public void setDegreeNum(String degreeNum) {
		this.degreeNum = degreeNum;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
