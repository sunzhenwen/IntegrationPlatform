package com.tj.jst.outside.staffmanage.skilledworker.condition;

import com.tj.jst.base.page.Condition;

/**
 * 技术人员分页工具类
 * @author DarkFlameMaster
 *
 */
public class SkilledworkerCondition extends Condition {

	//人员名称
	private String personName;
	//身份证号码
	private String identityCard;
	//技术人员种类
	private String skilledTypeNum;
	//技术人员级别
	private String skilledLevelNum;
	//组织机构代码证ID
	private String UserId;
	//
	private String corpCode;
	//
	private String corpId;

	/**
	 * 查询语句
	 */
	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(identityCard != null && !"".equals(identityCard)){
			sb.append(" and identityCard like '"+identityCard.trim()+"%'");
		}
		if(skilledLevelNum!= null && !"".equals(skilledLevelNum)){
			sb.append(" and SKILLEDLEVELNUM = '"+Integer.parseInt(skilledLevelNum.trim())+"'"); 
		}
		if(skilledTypeNum!= null && !"".equals(skilledTypeNum)){
			sb.append(" and SKILLEDTYPENUM = '"+Integer.parseInt(skilledTypeNum.trim())+"'");
		}
		
		String sql = "select * from V_SKILLEDWORKER"+sb.toString();
		return sql;
	}

	/**
	 * 查询数量
	 */
	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personname like '"+personName.trim()+"%'"); 
		}
		if(identityCard != null && !"".equals(identityCard)){
			sb.append(" and identityCard like '"+identityCard.trim()+"%'");
		}
		if(skilledLevelNum!= null && !"".equals(skilledLevelNum)){
			sb.append(" and SKILLEDLEVELNUM = '"+Integer.parseInt(skilledLevelNum.trim())+"'"); 
		}
		if(skilledTypeNum!= null && !"".equals(skilledTypeNum)){
			sb.append(" and SKILLEDTYPENUM = '"+Integer.parseInt(skilledTypeNum.trim())+"'");
		}
		
		String sqlCount = "select count(*) from V_SKILLEDWORKER"+sb.toString();
		return sqlCount;
	}

	public String getpersonName() {
		return personName;
	}

	public void setName(String personName) {
		this.personName = personName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getSkilledTypeNum() {
		return skilledTypeNum;
	}

	public void setSkilledTypeNum(String skilledTypeNum) {
		this.skilledTypeNum = skilledTypeNum;
	}

	public String getSkilledLevelNum() {
		return skilledLevelNum;
	}

	public void setSkilledLevelNum(String skilledLevelNum) {
		this.skilledLevelNum = skilledLevelNum;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

}
