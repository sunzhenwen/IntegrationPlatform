package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualityanfzCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//项目编号
	private String prjNum;
	//单位名称
	private String sectionName;

	public QualityanfzCondition()
	{	
	}
	
	public QualityanfzCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=301 and TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");
		if(sectionName!= null && !"".equals(sectionName)){ 
			sb.append(" and SECTIONNAME like '%"+sectionName.trim()+"%'"); 
		}
		
		String sql = "select * from TBCONTRACTRECORDMANAGE "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where CONTRACTTYPENUM=301 and  TO_NUMBER(trim(processSteps))>=3 and prjNum='"+this.getPrjNum()+"' ");				
		if(sectionName!= null && !"".equals(sectionName)){
			sb.append(" and SECTIONNAME like '%"+sectionName.trim()+"%'"); 
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

	

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
