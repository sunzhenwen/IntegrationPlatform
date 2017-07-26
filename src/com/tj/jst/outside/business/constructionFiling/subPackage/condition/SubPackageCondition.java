package com.tj.jst.outside.business.constructionFiling.subPackage.condition;

import com.tj.jst.base.page.Condition;

/**
 * �ְ���ͬ����
 * @author hhc
 *
 */
public class SubPackageCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	//��Ŀ����
	private String prjName;
	//��Ŀ���
	private String prjNum;
	//��֯��������
	private String corpCode;
	//��ͬ���
	private String contractTypeNum;
	
	public SubPackageCondition()
	{
		
	}
	
	public SubPackageCondition(String corpCode)
	{
		this.corpCode = corpCode;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where trim(processSteps)=3 and contrType='3' and contractTypeNum='302' ");
		
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and APPLYCORPCODE='"+corpCode.trim()+"'"); 
		}
		//2016-05-03���
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and aucorpcode='"+corpCode.trim()+"'"); 
		}
		String sql = "select * from v_tbcontractrecordmanage "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where trim(processSteps)=3 and contrType='3' and contractTypeNum='302' ");
				
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and APPLYCORPCODE='"+corpCode.trim()+"'"); 
		}
		//2016-05-03���
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and aucorpcode='"+corpCode.trim()+"'"); 
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
