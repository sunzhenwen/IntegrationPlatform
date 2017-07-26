package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityzzryCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ҵ
	private String corpname;
	//����
	private String constructorNamezzry;
	//֤����
	private String certnum;

	public QualityzzryCondition()
	{	
	}
	
	public QualityzzryCondition(String constructorNamezzry)
	{
		this.constructorNamezzry = constructorNamezzry;
	}
	
	//��ѯ���
	@Override
	public String getInitialSql() {
		//��������
		//this.setOrderByItem(" createDate desc ");
		//��ѯ��ǰ���õ�λ��
		String sql="";
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		corpname = UtilDecode.getDecode(this.getCorpname());
		if(dao.queryCorpBasicIndfo(corpname, ""))
		{
			StringBuffer sb=new StringBuffer(" where FIsDeleted='0' and FDUTY='��ȫԱ' and FENTNAME='"+corpname+"' ");
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{ 
				sb.append(" and FNAME like '%"+constructorNamezzry.trim()+"%'"); 
			}
			
			 sql = "select row_number() over(order by FRegDate desc) as rownumber,FID,FName,FCertNumber,FCardID from Position_Certificate "+sb.toString();
		}
		else
		{
			StringBuffer sb=new StringBuffer(" where DUTY='��ȫԱ' and ENTNAME='"+corpname+"' ");
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{ 
				sb.append(" and NAME like '%"+constructorNamezzry.trim()+"%'"); 
			}			
			sql = " select NAME FName,CertNum FCertNumber,CardID FCardID from POSITION_CERTIFICATE "+sb.toString();
		}

		return sql;
	}

	//��ѯ����
	@Override
	public String getCountSql() {
		//��ѯ��ǰ���õ�λ��
		String sqlCount="";
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		corpname = UtilDecode.getDecode(this.getCorpname());
		if(dao.queryCorpBasicIndfo(corpname, ""))
		{
			StringBuffer sb=new StringBuffer(" where  FIsDeleted='0'and FDUTY='��ȫԱ' and  FENTNAME='"+corpname+"' ");				
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{
				sb.append(" and FNAME like '%"+constructorNamezzry.trim()+"%'"); 
			}
			sqlCount="select count(*) from Position_Certificate "+sb.toString();
		}
		else
		{
			StringBuffer sb=new StringBuffer(" where DUTY='��ȫԱ' and ENTNAME='"+corpname+"' ");
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{ 
				sb.append(" and NAME like '%"+constructorNamezzry.trim()+"%'"); 
			}
			sqlCount="select count(*) from POSITION_CERTIFICATE "+sb.toString();
		}
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
	
	public String getConstructorNamezzry() {
		return constructorNamezzry;
	}

	public void setConstructorNamezzry(String constructorNamezzry) {
		this.constructorNamezzry = constructorNamezzry;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
