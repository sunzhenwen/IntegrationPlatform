package com.tj.jst.outside.business.tenderInfo.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��Ͷ��
 * @author hhc
 *
 */
public class TenderInfoCondition extends Condition {

	//��Ŀ���
	private String prjNum;
	
	public TenderInfoCondition()
	{
		
	}
	
	public TenderInfoCondition(String prjNum)
	{
		this.prjNum = prjNum;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" CREATEDATE desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where prjNum='"+prjNum+"' ");
		
//		if(prjNum!= null && !"".equals(prjNum)){
//			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
//		}
		
		String sql = "select * from V_TBTENDERINFO "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where prjNum='"+prjNum+"' ");
				
//		if(prjNum!= null && !"".equals(prjNum)){
//			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
//		}
		String sqlCount="select count(*) from V_TBTENDERINFO "+sb.toString();
		return sqlCount;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

}
