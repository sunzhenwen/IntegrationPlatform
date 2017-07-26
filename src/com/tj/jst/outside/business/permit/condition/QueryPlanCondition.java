package com.tj.jst.outside.business.permit.condition;

import com.tj.jst.base.page.Condition;

/**
 * ʩ�����,ʩ��ͼ���ϸ�����
 * @author Administrator
 *
 */
public class QueryPlanCondition extends Condition {

	//��Ŀ����
	private String prjId;
	//ʩ��ͼ���ϸ�����
	private String censorNum;
	//ʩ��ͼ����������
	private String censorCorpName;
	//��Ŀ���
	private String prjNum;
	//��Ŀ����
	private String prjName;
	//��֯��������
	private String corpCode;
	
	public QueryPlanCondition()
	{
		
	}

	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");

		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censorNum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(censorCorpName!= null && !"".equals(censorCorpName)){
			sb.append(" and censorCorpName like '%"+censorCorpName.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from TBPROJECTCENSORINFO "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");
				
		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censorNum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(censorCorpName!= null && !"".equals(censorCorpName)){
			sb.append(" and censorCorpName like '%"+censorCorpName.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from TBPROJECTCENSORINFO "+sb.toString();
		return sqlCount;
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

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}


	public String getPrjId() {
		return prjId;
	}


	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}


	public String getCensorNum() {
		return censorNum;
	}


	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
	}


	public String getCensorCorpName() {
		return censorCorpName;
	}


	public void setCensorCorpName(String censorCorpName) {
		this.censorCorpName = censorCorpName;
	}

}
