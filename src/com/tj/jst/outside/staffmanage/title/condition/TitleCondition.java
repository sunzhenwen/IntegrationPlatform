package com.tj.jst.outside.staffmanage.title.condition;

import com.tj.jst.base.page.Condition;

/**
 * 职称人员分页工具类
 * @author Administrator
 *
 */
public class TitleCondition extends Condition {

	//人员名称
	private String personName;
	//证件号码
	private String idCard;
	//企业id
	private String corpId;
	//职称
	private String titleName;
	//职称专业
	private String titleMajor;
	//职称级别
	private String titleLevel;
	//所学专业
	private String studyMajor;
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!= null && !"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard != null && !"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(titleName!= null && !"".equals(titleName)){
			sb.append(" and titleName like '"+titleName.trim()+"%'"); 
		}
		if(titleMajor != null && !"".equals(titleMajor)){
			sb.append(" and titleMajor like '"+titleMajor.trim()+"%'");
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '"+titleLevel.trim()+"%'"); 
		}
		if(studyMajor != null && !"".equals(studyMajor)){
			sb.append(" and studyMajor like '"+studyMajor.trim()+"%'");
		}
		
		String sql = "select * from v_persontitleinfo "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where corpId='"+corpId+"' ");
		if(personName!=null&&!"".equals(personName)){
			sb.append(" and personName like '"+personName.trim()+"%'"); 
		}
		if(idCard!=null&&!"".equals(idCard)){
			sb.append(" and idCard like '"+idCard.trim()+"%'");
		}
		if(titleName!= null && !"".equals(titleName)){
			sb.append(" and titleName like '"+titleName.trim()+"%'"); 
		}
		if(titleMajor != null && !"".equals(titleMajor)){
			sb.append(" and titleMajor like '"+titleMajor.trim()+"%'");
		}
		if(titleLevel!= null && !"".equals(titleLevel)){
			sb.append(" and titleLevel like '"+titleLevel.trim()+"%'"); 
		}
		if(studyMajor != null && !"".equals(studyMajor)){
			sb.append(" and studyMajor like '"+studyMajor.trim()+"%'");
		}
		
		String sqlCount="select count(*) from v_persontitleinfo "+sb.toString();
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
	
	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getTitleMajor() {
		return titleMajor;
	}

	public void setTitleMajor(String titleMajor) {
		this.titleMajor = titleMajor;
	}

	public String getTitleLevel() {
		return titleLevel;
	}

	public void setTitleLevel(String titleLevel) {
		this.titleLevel = titleLevel;
	}

	public String getStudyMajor() {
		return studyMajor;
	}

	public void setStudyMajor(String studyMajor) {
		this.studyMajor = studyMajor;
	}

}
