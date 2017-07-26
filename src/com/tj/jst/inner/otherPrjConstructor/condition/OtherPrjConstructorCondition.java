package com.tj.jst.inner.otherPrjConstructor.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * 外省项目备案内网查看
 * @author Administrator
 *
 */
public class OtherPrjConstructorCondition extends Condition {

	//企业id
	private String corpId;
	private String prjNum; //项目编号
	private String prjName; //项目名称
	private Date startDate; //起始时间
	private Date endDate;	//结束时间
	
	public OtherPrjConstructorCondition()
	{
		
	}
	
	public OtherPrjConstructorCondition(String corpId)
	{
		this.corpId = corpId;
	}
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName != null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		String sql = "select * from OTHER_PROJECT"+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where 1=1 ");
		
		if(prjNum!= null && !"".equals(prjNum)){
			sb.append(" and prjNum like '%"+prjNum.trim()+"%'"); 
		}
		if(prjName != null && !"".equals(prjName)){
			sb.append(" and prjName like '%"+prjName.trim()+"%'");
		}
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and createDate >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and createDate <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		
		String sqlCount="select count(*) from OTHER_PROJECT "+sb.toString();
		return sqlCount;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
