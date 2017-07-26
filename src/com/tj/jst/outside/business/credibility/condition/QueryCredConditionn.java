package com.tj.jst.outside.business.credibility.condition;
import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QueryCredConditionn extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目编号
	 private String goodcreditid;
	 private String corpCode;
		
		public String getCorpCode() {
			return corpCode;
		}

		public void setCorpCode(String corpCode) {
			this.corpCode = corpCode;
		}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1 and  corpcode='"+this.getCorpCode()+"' ");
		if(goodcreditid!= null && !"".equals(goodcreditid)){ 
			sb.append(" and GOODCREDITID like '%"+goodcreditid.trim()+"%'"); 
		}
		String sql = "select * from v_CrediBillitygood_qiye "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1 and  corpcode='"+this.getCorpCode()+"' ");				
		if(goodcreditid!= null && !"".equals(goodcreditid)){
			sb.append(" and goodcreditid like '%"+goodcreditid.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_CrediBillitygood_qiye "+sb.toString();
		return sqlCount;
	}

	public String getGoodcreditid() {
		return goodcreditid;
	}

	public void setGoodcreditid(String goodcreditid) {
		this.goodcreditid = goodcreditid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
