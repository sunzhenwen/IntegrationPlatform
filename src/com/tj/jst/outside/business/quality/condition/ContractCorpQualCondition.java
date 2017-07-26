package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

public class ContractCorpQualCondition extends Condition{
	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//�б�֪ͨ����
	private String tenderNum;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��֯��������
	private String corpCode;
	
	//��ͬ���
	private String contractTypeNum; 
	
	public ContractCorpQualCondition()
	{
		
	}

	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" a.createDate desc ");
		
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		
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
