package com.tj.jst.inner.codeChange.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ѯ��ҵ
 * @author hhc 2016-04-21
 *
 */
public class QueryCorpCondition extends Condition {
	
	private String corpName;//��ҵ����
	private String corpCode;//��֯��������
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
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
