package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

public class ContractCorpQualCondition extends Condition{
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
	
	//合同类别
	private String contractTypeNum; 
	
	public ContractCorpQualCondition()
	{
		
	}

	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" a.createDate desc ");
		
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where a.prjNum='"+this.getPrjNum()+"' and a.contractTypeNum='"+this.getContractTypeNum()+"' ");
		//StringBuffer sb=new StringBuffer(" where a.prjNum='"+this.getPrjNum()+"' and tenderclassnum='001' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and a.createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate!=null && !"".equals(endDate)){
			sb.append(" and a.createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(tenderNum!= null && !"".equals(tenderNum)){
			sb.append(" and a.tenderNum like '%"+tenderNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and b.prjName like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select "
					+ "	a.PRJNUM,	"
					+ "	b.PRJNAME,	"
					+ "	a.SECTIONNAME,	"
					+ "	a.RECORDNUM,	"
					+ "	rtrim(a.contracttypenum) CONTRACTTYPENUM,	"
					+ "	(select t.contracttype from TBCONTRACTTYPEDIC t where t.code=a.contracttypenum) as CONTRACTTYPENAME,	"
					+ "	a.CONTRACTORCORPNAME,	"
					+ "	a.CONTRACTORCORPCODE,	"
					+ "	a.CONSTRUCTORNAME,	"
					+ "	a.TITLELEVE,	"
					+ "	a.PHONE,	"
					+ "	a.QUALIFICATIONSTYPE,	"
					+ "	a.QUALIFICATIONSTYPENAME,	"
					+ "	a.SPECIALTYTYPE,	"
					+ "	a.SPECIALTYTYPENAME,	"
					+ "	a.RATING,	"
					+ "	a.RATINGNAME	"
				+ "	from  tbcontractrecordmanage a "
				+ "	left join tbprojectinfo_s  b "
				+ " on a.prjnum=b.prjnum "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		
		StringBuffer sb=new StringBuffer(" where a.prjNum='"+this.getPrjNum()+"' and a.contractTypeNum='"+this.getContractTypeNum()+"' ");
		//StringBuffer sb=new StringBuffer(" where a.prjNum='"+this.getPrjNum()+"' and tenderclassnum='001' ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and a.createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and a.createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(tenderNum!= null && !"".equals(tenderNum)){
			sb.append(" and a.tenderNum like '%"+tenderNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and b.prjName like '%"+prjName.trim()+"%'"); 
		}
		String sqlCount="select count(*) "
				+ "	from  tbcontractrecordmanage a "
				+ "	left join tbprojectinfo_s  b "
				+ " on a.prjnum=b.prjnum "+sb.toString();
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


	public String getContractTypeNum() {
		return contractTypeNum;
	}


	public void setContractTypeNum(String contractTypeNum) {
		this.contractTypeNum = contractTypeNum;
	}
}
