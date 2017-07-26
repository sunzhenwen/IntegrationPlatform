package com.tj.jst.outside.business.credibility.condition;
import com.tj.jst.base.page.Condition;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QueryCredConditionn extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��Ŀ���
	 private String goodcreditid;
	 private String corpCode;
		
		public String getCorpCode() {
			return corpCode;
		}

		public void setCorpCode(String corpCode) {
			this.corpCode = corpCode;
		}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1 and  corpcode='"+this.getCorpCode()+"' ");
		if(goodcreditid!= null && !"".equals(goodcreditid)){ 
			sb.append(" and GOODCREDITID like '%"+goodcreditid.trim()+"%'"); 
		}
		String sql = "select * from v_CrediBillitygood_qiye "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where ISPUBLIC=1 and  corpcode='"+this.getCorpCode()+"' ");				
		if(goodcreditid!= null && !"".equals(goodcreditid)){
			sb.append(" and goodcreditid like '%"+goodcreditid.trim()+"%'"); 
		}
		String sqlCount="select count(*) from v_CrediBillitygood_qiye "+sb.toString();
		return sqlCount;
	}

	public String getGoodcreditid() {
		return goodcreditid;
	}

	public void setGoodcreditid(String goodcreditid) {
		this.goodcreditid = goodcreditid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
