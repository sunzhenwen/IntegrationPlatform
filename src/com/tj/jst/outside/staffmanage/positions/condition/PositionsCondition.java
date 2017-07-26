package com.tj.jst.outside.staffmanage.positions.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.page.Condition;

/**
 * 岗位人员分页工具类
 * @author Administrator
 *
 */
public class PositionsCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String idCard;
	//企业名称
	private String corpName;
	//岗位名称
	private String duty;
	
	public PositionsCondition()
	{
		
	}
	
	public PositionsCondition(String corpName)
	{
		this.corpName = corpName;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
			if (duty != null){
				duty = URLDecoder.decode(duty,"utf8");
			}
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    }   
		
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where FIsDeleted=0 and FEntName='"+corpName+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and FName like '"+personName.trim()+"%'"); 
		}
		if(duty!=null && !"".equals(duty)){
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and FCardID like '"+idCard.trim()+"%'");
		}
		String sql = "select row_number() over(order by FRegDate desc) as rownumber,fPersonID, FName, FCardID, FSex, FEntName, FDuty FROM Position_Certificate"+sb.toString();
		System.out.println("sql= "+sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
			if (duty != null){
				duty = URLDecoder.decode(duty,"utf8");
			}
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    }  
		
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where FIsDeleted=0 and FEntName='"+corpName+"' ");
		if(duty!=null && !"".equals(duty)){
			sb.append(" and FDuty = '" + duty + "' ");
		}
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and FName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and FCardID like '"+idCard.trim()+"%'");
		}
		String sqlCount="select count(*) from Position_Certificate "+sb.toString();
		System.out.println("sqlCount= "+sqlCount);
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

}
