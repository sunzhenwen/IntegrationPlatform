package com.tj.jst.outside.business.credibility.condition;
import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QueryCredCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String corpCode;
	 private String corpbadcreditid;
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1 and corpcode='"+this.getCorpCode()+"' ");
		if(corpbadcreditid!= null && !"".equals(corpbadcreditid)){ 
			sb.append(" and corpbadcreditid like '%"+corpbadcreditid.trim()+"%'"); 
		}
		
		String sql = "select * from v_CrediBillity_qiye "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql(){
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1  and corpcode='"+this.getCorpCode()+"' ");				
		if(corpbadcreditid!= null && !"".equals(corpbadcreditid)){
			sb.append(" and corpbadcreditid like '%"+corpbadcreditid.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_CrediBillity_qiye "+sb.toString();
		return sqlCount;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpbadcreditid() {
		return corpbadcreditid;
	}

	public void setCorpbadcreditid(String corpbadcreditid) {
		this.corpbadcreditid = corpbadcreditid;
	}
	

}
