package com.tj.jst.outside.staffmanage.threeTypePerson.condition;

import com.tj.jst.base.page.Condition;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreePersonCondition extends Condition {

	//��Ա����
	private String FName;
	//֤������
	private String FIdCertNo;
	//��ҵid
	private String corpId;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(FName!= null && !"".equals(FName)){
			sb.append(" and FName like '%"+FName.trim()+"%'"); 
		}
		if(FIdCertNo != null && !"".equals(FIdCertNo)){
			sb.append(" and FIdCertNo like '%"+FIdCertNo.trim()+"%'");
		}
		
		String sql = "select * from THREETYPE_PERSON "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��������
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(FName!= null && !"".equals(FName)){
			sb.append(" and FName like '%"+FName.trim()+"%'"); 
		}
		if(FIdCertNo != null && !"".equals(FIdCertNo)){
			sb.append(" and FIdCertNo like '%"+FIdCertNo.trim()+"%'");
		}
		
		String sqlCount="select count(*) from THREETYPE_PERSON "+sb.toString();
		return sqlCount;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getFIdCertNo() {
		return FIdCertNo;
	}

	public void setFIdCertNo(String fIdCertNo) {
		FIdCertNo = fIdCertNo;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
