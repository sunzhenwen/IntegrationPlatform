package com.tj.jst.outside.business.constructionFiling.subPackage.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ѯʩ���ܰ���ͬ
 * @author Administrator
 *
 */
public class MainContractorCondition extends Condition {

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
	
	public MainContractorCondition()
	{
		
	}

	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		
		//��ѯ��ǰ���õ�λ��
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

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		
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
