package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualitylwCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ŀ���
	private String prjNum;
	//��λ����
	private String contractorCorpNameLW;

	public QualitylwCondition()
	{	
	}
	
	public QualitylwCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=303 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpNameLW!= null && !"".equals(contractorCorpNameLW)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameLW.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=303 and  TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");				
		if(contractorCorpNameLW!= null && !"".equals(contractorCorpNameLW)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameLW.trim()+"%'"); 
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

	

	public String getContractorCorpNameLW() {
		return contractorCorpNameLW;
	}

	public void setContractorCorpNameLW(String contractorCorpNameLW) {
		this.contractorCorpNameLW = contractorCorpNameLW;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
