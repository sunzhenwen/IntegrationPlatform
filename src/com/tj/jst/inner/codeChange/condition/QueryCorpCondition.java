package com.tj.jst.inner.codeChange.condition;

import com.tj.jst.base.page.Condition;

/**
 * 查询企业
 * @author hhc 2016-04-21
 *
 */
public class QueryCorpCondition extends Condition {
	
	private String corpName;//企业名称
	private String corpCode;//组织机构代码
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem(" CREATEDATE desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode='"+corpCode.trim()+"'"); 
		}
		
		String sql = "select * from TBCORPBASICINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode='"+corpCode.trim()+"'"); 
		}
		
		String sqlCount="select count(*) from TBCORPBASICINFO "+sb.toString();
		return sqlCount;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
