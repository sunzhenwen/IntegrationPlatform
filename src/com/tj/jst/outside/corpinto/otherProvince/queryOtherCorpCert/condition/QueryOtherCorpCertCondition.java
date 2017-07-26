package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.condition;

import com.tj.jst.base.page.Condition;

/**
 * 查询外省备案企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertCondition extends Condition {

	private String tradeBoundName; 
	private String titleLevel;
	private String corpCode;// 企业组织机构代码证

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where corpCode='" + corpCode
				+ "'  ");
		if(tradeBoundName!= null && !"".equals(tradeBoundName)){
			sb.append(" and tradeBoundName like '%"+tradeBoundName.trim()+"%'"); 
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '%"+titleLevel.trim()+"%'"); 
		}
		String sql = "select * from V_QUALIFICATION" + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(" where corpCode='" + corpCode
				+ "'  ");
		if(tradeBoundName!= null && !"".equals(tradeBoundName)){
			sb.append(" and tradeBoundName like '%"+tradeBoundName.trim()+"%'"); 
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '%"+titleLevel.trim()+"%'"); 
		}
		String sqlCount = "select count(*) from V_QUALIFICATION"
				+ sb.toString();
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getTradeBoundName() {
		return tradeBoundName;
	}

	public void setTradeBoundName(String tradeBoundName) {
		this.tradeBoundName = tradeBoundName;
	}

	public String getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}

}
