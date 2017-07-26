package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QualityzzryCondition extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//企业
	private String corpname;
	//姓名
	private String constructorNamezzry;
	//证书编号
	private String certnum;

	public QualityzzryCondition()
	{	
	}
	
	public QualityzzryCondition(String constructorNamezzry)
	{
		this.constructorNamezzry = constructorNamezzry;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		String sql="";
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		corpname = UtilDecode.getDecode(this.getCorpname());
		if(dao.queryCorpBasicIndfo(corpname, ""))
		{
			StringBuffer sb=new StringBuffer(" where FIsDeleted='0' and FDUTY='安全员' and FENTNAME='"+corpname+"' ");
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{ 
				sb.append(" and FNAME like '%"+constructorNamezzry.trim()+"%'"); 
			}
			
			 sql = "select row_number() over(order by FRegDate desc) as rownumber,FID,FName,FCertNumber,FCardID from Position_Certificate "+sb.toString();
		}
		else
		{
			StringBuffer sb=new StringBuffer(" where DUTY='安全员' and ENTNAME='"+corpname+"' ");
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{ 
				sb.append(" and NAME like '%"+constructorNamezzry.trim()+"%'"); 
			}			
			sql = " select NAME FName,CertNum FCertNumber,CardID FCardID from POSITION_CERTIFICATE "+sb.toString();
		}

		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		String sqlCount="";
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		corpname = UtilDecode.getDecode(this.getCorpname());
		if(dao.queryCorpBasicIndfo(corpname, ""))
		{
			StringBuffer sb=new StringBuffer(" where  FIsDeleted='0'and FDUTY='安全员' and  FENTNAME='"+corpname+"' ");				
			if(constructorNamezzry!= null && !"".equals(constructorNamezzry))
			{
				sb.append(" and FNAME like '%"+constructorNamezzry.trim()+"%'"); 
			}
			sqlCount="select count(*) from Position_Certificate "+sb.toString();
		}
		else
		{
			StringBuffer sb=new StringBuffer(" where DUTY='安全员' and ENTNAME='"+corpname+"' ");
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
