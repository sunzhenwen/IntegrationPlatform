package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityfbCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ŀ���
	private String prjNum;
	//��λ����
	private String contractorCorpNameFB;

	public QualityfbCondition()
	{	
	}
	
	public QualityfbCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=302 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpNameFB!= null && !"".equals(contractorCorpNameFB)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameFB.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=302 and  TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");				
		if(contractorCorpNameFB!= null && !"".equals(contractorCorpNameFB)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameFB.trim()+"%'"); 
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


	public String getContractorCorpNameFB() {
		return contractorCorpNameFB;
	}

	public void setContractorCorpNameFB(String contractorCorpNameFB) {
		this.contractorCorpNameFB = contractorCorpNameFB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
