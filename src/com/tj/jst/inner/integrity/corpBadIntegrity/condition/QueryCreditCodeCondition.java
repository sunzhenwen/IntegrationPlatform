package com.tj.jst.inner.integrity.corpBadIntegrity.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������Ϊ����
 * @author Administrator
 *
 */
public class QueryCreditCodeCondition extends Condition {

	private String beHviorCode; //��Ϊ����
	private String badBeHavior; //������Ϊ
	private String legalBasis; //��������
	private String punishBasis; //��������
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
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
