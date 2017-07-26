package com.tj.jst.outside.business.queryprojection.condition;

import com.tj.jst.base.page.Condition;

/**
 * ҵ���ѯ
 * 
 * @author Administrator
 *
 */
public class QueryProjectionCondition extends Condition {

	//��Ŀ����
	private String prjName;
	//��Ŀ���
	private String prjNum;
	private String corpCode;// ��ҵ��֯��������֤

	public QueryProjectionCondition(String corpCode) {
		this.corpCode = corpCode;
	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		this.setOrderByItem(" CREATEDATE desc ");
		
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where AUCORPCODE='" + corpCode
				+ "' ");
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		String sql = "select * from v_project_tbprojectinfo_s " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where AUCORPCODE='" + corpCode
				+ "' ");
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and PRJNAME like '%"+prjName.trim()+"%'"); 
		}
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		String sqlCount = "select count(*) from v_project_tbprojectinfo_s "
				+ sb.toString();
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
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

}
