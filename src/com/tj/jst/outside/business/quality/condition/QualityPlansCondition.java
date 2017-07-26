package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * ����,ʩ��ͼ����Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityPlansCondition extends Condition {

	private String censorNum;//���ϸ�����
	private String prjName;//���ʱ�Ĺ�������
	//��Ŀ����
	private String prjId;
	
	public QualityPlansCondition()
	{
		
	}

	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATEDATE desc ");
		
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where prjid='"+this.getPrjId()+"' ");
		

		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censornum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjname like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from TBProjectCensorInfo  "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		
		StringBuffer sb=new StringBuffer(" where prjid='"+this.getPrjId()+"' ");
			
		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censornum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjname like '%"+prjName.trim()+"%'"); 
		}
		
		String sqlCount="select count(*) from TBProjectCensorInfo  "+sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

}
