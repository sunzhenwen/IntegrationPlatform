package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * ���쵥λ��ѯ
 * @author Administrator
 *
 */
public class QualitykcsCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ŀ���
	private String prjNum;
	//��λ����
	private String contractorCorpNameKC;

	public QualitykcsCondition()
	{	
	}
	
	public QualitykcsCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=100 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpNameKC!= null && !"".equals(contractorCorpNameKC)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameKC.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=100 and  TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");				
		if(contractorCorpNameKC!= null && !"".equals(contractorCorpNameKC)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameKC.trim()+"%'"); 
		}
		String sqlCount="select count(*) from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sqlCount;
	}
	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getContractorCorpNameKC() {
		return contractorCorpNameKC;
	}

	public void setContractorCorpNameKC(String contractorCorpNameKC) {
		this.contractorCorpNameKC = contractorCorpNameKC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
