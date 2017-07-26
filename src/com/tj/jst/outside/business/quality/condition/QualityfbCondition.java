package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualityfbCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目编号
	private String prjNum;
	//单位名称
	private String contractorCorpNameFB;

	public QualityfbCondition()
	{	
	}
	
	public QualityfbCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=302 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(contractorCorpNameFB!= null && !"".equals(contractorCorpNameFB)){
			sb.append(" and CONTRACTORCORPNAME like '%"+contractorCorpNameFB.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
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
