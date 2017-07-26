package com.tj.jst.outside.business.contractFiling.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ѯ��ҵ�������
 * @author Administrator
 *
 */
public class QueryDesignTitleLeveCondition extends Condition {

	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��ҵ����
	private String corpName;
	//��֯��������
	private String corpCode;
	//�б굥λ��֯��������
	private String tenderCorpCode;
	
	public QueryDesignTitleLeveCondition()
	{
		
	}

	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem(" createDate desc ");
		
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where qualificationstypename='�������' and corpCode='"+this.getTenderCorpCode()+"' ");
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		
		String sql = "select * from v_design_certdeail "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		
		StringBuffer sb=new StringBuffer(" where qualificationstypename='�������' and corpCode='"+this.getTenderCorpCode()+"' ");
			
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		if(corpName!= null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_design_certdeail "+sb.toString();
		return sqlCount;
	}


	public String getPrjNum() {
		return prjNum;
	}


	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}


	public String getPrjName() {
		return prjName;
	}


	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}


	public String getCorpCode() {
		return corpCode;
	}


	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}


	public String getTenderCorpCode() {
		return tenderCorpCode;
	}


	public void setTenderCorpCode(String tenderCorpCode) {
		this.tenderCorpCode = tenderCorpCode;
	}


	public String getCorpName() {
		return corpName;
	}


	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
