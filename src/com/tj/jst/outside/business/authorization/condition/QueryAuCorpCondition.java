package com.tj.jst.outside.business.authorization.condition;

import com.tj.jst.base.page.Condition;

/**
 * 企业信息查询
 * @author Administrator
 *
 */
public class QueryAuCorpCondition extends Condition {

	//组织机构代码
	private String corpCode;
	private String corpName;
	
	public QueryAuCorpCondition()
	{
		
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" creatdate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		
		String sql = "select * from V_TBCORPFOREIGNINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from V_TBCORPFOREIGNINFO "+sb.toString();
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
