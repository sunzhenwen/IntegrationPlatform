package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.util.UtilDecode;

/**
 * 项目负责人
 * @author Administrator
 *
 */
public class QualityanxmfzCondition extends Condition {

	//企业
	private String corpname;
	//姓名
	private String personName;
	//证书编号
	private String certnum;
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem(" createDate desc ");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpname!= null && !"".equals(corpname)){ 
			corpname = UtilDecode.getDecode(corpname.trim());
			//sb.append(" and CORPNAME like '%哈尔滨市鑫海人和建筑工程有限责任公司%'"); 
			sb.append(" and CORPNAME like '%"+corpname+"%'"); 
		}
		
		if(personName!= null && !"".equals(personName)){ 
			sb.append(" and PERSONNAME like '%"+personName.trim()+"%'"); 
		}
		
		String sql = "select * from TBREGPERSONREGINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(corpname!= null && !"".equals(corpname)){ 
			corpname = UtilDecode.getDecode(corpname.trim());
			//sb.append(" and CORPNAME like '%哈尔滨市鑫海人和建筑工程有限责任公司%'"); 
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
