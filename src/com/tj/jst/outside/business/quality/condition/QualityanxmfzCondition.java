package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.util.UtilDecode;

/**
 * ��Ŀ������
 * @author Administrator
 *
 */
public class QualityanxmfzCondition extends Condition {

	//��ҵ
	private String corpname;
	//����
	private String personName;
	//֤����
	private String certnum;
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpname!= null && !"".equals(corpname)){ 
			corpname = UtilDecode.getDecode(corpname.trim());
			//sb.append(" and CORPNAME like '%���������κ��˺ͽ��������������ι�˾%'"); 
			sb.append(" and CORPNAME like '%"+corpname+"%'"); 
		}
		
		if(personName!= null && !"".equals(personName)){ 
			sb.append(" and PERSONNAME like '%"+personName.trim()+"%'"); 
		}
		
		String sql = "select * from TBREGPERSONREGINFO "+sb.toString();
		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpname!= null && !"".equals(corpname)){ 
			corpname = UtilDecode.getDecode(corpname.trim());
			//sb.append(" and CORPNAME like '%���������κ��˺ͽ��������������ι�˾%'"); 
			sb.append(" and CORPNAME like '%"+corpname+"%'"); 
		}
		
		if(personName!= null && !"".equals(personName)){
			sb.append(" and PERSONNAME like '%"+personName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from TBREGPERSONREGINFO "+sb.toString();
		return sqlCount;
	}
	

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}

	public String getCertnum() {
		return certnum;
	}

	public void setCertnum(String certnum) {
		this.certnum = certnum;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
