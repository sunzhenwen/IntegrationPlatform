package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityjlCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ŀ���
	private String prjNum;
	//��λ����
	private String contractorCorpName;

	public QualityjlCondition()
	{	
	}
	
	public QualityjlCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=400 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpName!= null && !"".equals(contractorCorpName)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpName.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=400 and  TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");				
		if(contractorCorpName!= null && !"".equals(contractorCorpName)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpName.trim()+"%'"); 
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


	public String getContractorCorpName() {
		return contractorCorpName;
	}

	public void setContractorCorpName(String contractorCorpName) {
		this.contractorCorpName = contractorCorpName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
