package com.tj.jst.inner.otherPrjConstructor.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * ��ʡ��Ŀ���������鿴
 * @author Administrator
 *
 */
public class OtherPrjConstructorCondition extends Condition {

	//��ҵid
	private String corpId;
	private String prjNum; //��Ŀ���
	private String prjName; //��Ŀ����
	private Date startDate; //��ʼʱ��
	private Date endDate;	//����ʱ��
	
	public OtherPrjConstructorCondition()
	{
		
	}
	
	public OtherPrjConstructorCondition(String corpId)
	{
		this.corpId = corpId;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName != null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		String sql = "select * from OTHER_PROJECT"+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName != null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		String sqlCount="select count(*) from OTHER_PROJECT "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
