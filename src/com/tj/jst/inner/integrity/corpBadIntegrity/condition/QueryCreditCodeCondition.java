package com.tj.jst.inner.integrity.corpBadIntegrity.condition;

import com.tj.jst.base.page.Condition;

/**
 * 不良行为代码
 * @author Administrator
 *
 */
public class QueryCreditCodeCondition extends Condition {

	private String beHviorCode; //行为代码
	private String badBeHavior; //不良行为
	private String legalBasis; //法律依据
	private String punishBasis; //处罚依据
	
	//查询语句
	@Override
	public String getInitialSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");

		if(beHviorCode!= null && !"".equals(beHviorCode)){
			sb.append(" and BEHAVIORCODE like '%"+beHviorCode.trim()+"%'"); 
		}
		if(badBeHavior!= null && !"".equals(badBeHavior)){
			sb.append(" and BADBEHAVIOR like '%"+badBeHavior.trim()+"%'"); 
		}
		if(legalBasis!= null && !"".equals(legalBasis)){
			sb.append(" and LEGALBASIS like '%"+legalBasis.trim()+"%'"); 
		}
		if(punishBasis!= null && !"".equals(punishBasis)){
			sb.append(" and PUNISHBASIS like '%"+punishBasis.trim()+"%'"); 
		}
		
		String sql = "select * from TBCORPBADDIC "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(beHviorCode!= null && !"".equals(beHviorCode)){
			sb.append(" and BEHAVIORCODE like '%"+beHviorCode.trim()+"%'"); 
		}
		if(badBeHavior!= null && !"".equals(badBeHavior)){
			sb.append(" and BADBEHAVIOR like '%"+badBeHavior.trim()+"%'"); 
		}
		if(legalBasis!= null && !"".equals(legalBasis)){
			sb.append(" and LEGALBASIS like '%"+legalBasis.trim()+"%'"); 
		}
		if(punishBasis!= null && !"".equals(punishBasis)){
			sb.append(" and PUNISHBASIS like '%"+punishBasis.trim()+"%'"); 
		}
		
		String sqlCount="select count(*) from TBCORPBADDIC "+sb.toString();
		return sqlCount;
	}

	public String getBeHviorCode() {
		return beHviorCode;
	}

	public void setBeHviorCode(String beHviorCode) {
		this.beHviorCode = beHviorCode;
	}

	public String getBadBeHavior() {
		return badBeHavior;
	}

	public void setBadBeHavior(String badBeHavior) {
		this.badBeHavior = badBeHavior;
	}

	public String getLegalBasis() {
		return legalBasis;
	}

	public void setLegalBasis(String legalBasis) {
		this.legalBasis = legalBasis;
	}

	public String getPunishBasis() {
		return punishBasis;
	}

	public void setPunishBasis(String punishBasis) {
		this.punishBasis = punishBasis;
	}

}
