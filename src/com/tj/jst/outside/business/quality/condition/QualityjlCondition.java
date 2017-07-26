package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualityjlCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目编号
	private String prjNum;
	//单位名称
	private String contractorCorpName;

	public QualityjlCondition()
	{	
	}
	
	public QualityjlCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=400 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpName!= null && !"".equals(contractorCorpName)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpName.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
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
