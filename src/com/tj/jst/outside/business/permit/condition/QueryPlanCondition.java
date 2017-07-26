package com.tj.jst.outside.business.permit.condition;

import com.tj.jst.base.page.Condition;

/**
 * 施工许可,施工图审查合格书编号
 * @author Administrator
 *
 */
public class QueryPlanCondition extends Condition {

	//项目主键
	private String prjId;
	//施工图审查合格书编号
	private String censorNum;
	//施工图审查机构名称
	private String censorCorpName;
	//项目编号
	private String prjNum;
	//项目名称
	private String prjName;
	//组织机构代码
	private String corpCode;
	
	public QueryPlanCondition()
	{
		
	}

	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" createDate desc ");
		
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");

		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censorNum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(censorCorpName!= null && !"".equals(censorCorpName)){
			sb.append(" and censorCorpName like '%"+censorCorpName.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from TBPROJECTCENSORINFO "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		
		StringBuffer sb=new StringBuffer(" where prjId='"+prjId+"' ");
				
		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censorNum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(censorCorpName!= null && !"".equals(censorCorpName)){
			sb.append(" and censorCorpName like '%"+censorCorpName.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'"); 
		}
		String sqlCount="select count(*) from TBPROJECTCENSORINFO "+sb.toString();
		return sqlCount;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}


	public String getPrjId() {
		return prjId;
	}


	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}


	public String getCensorNum() {
		return censorNum;
	}


	public void setCensorNum(String censorNum) {
		this.censorNum = censorNum;
	}


	public String getCensorCorpName() {
		return censorCorpName;
	}


	public void setCensorCorpName(String censorCorpName) {
		this.censorCorpName = censorCorpName;
	}

}
