package com.tj.jst.outside.business.constructionFiling.subPackage.condition;

import com.tj.jst.base.page.Condition;

/**
 * 查询施工总包合同
 * @author Administrator
 *
 */
public class MainContractorCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//中标通知书编号
	private String tenderNum;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//组织机构代码
	private String corpCode;
	
	public MainContractorCondition()
	{
		
	}

	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where contractTypeNum='301' and aucorpcode='"+corpCode+"' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(tenderNum!= null && !"".equals(tenderNum)){
			sb.append(" and tenderNum like '%"+tenderNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from v_tbcontractrecordmanage "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		
		StringBuffer sb=new StringBuffer(" where contractTypeNum='301' and aucorpcode='"+corpCode+"' ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(tenderNum!= null && !"".equals(tenderNum)){
			sb.append(" and tenderNum like '%"+tenderNum.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_tbcontractrecordmanage "+sb.toString();
		return sqlCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getTenderNum() {
		return tenderNum;
	}

	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
