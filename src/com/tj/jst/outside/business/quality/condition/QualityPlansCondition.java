package com.tj.jst.outside.business.quality.condition;

import com.tj.jst.base.page.Condition;

/**
 * 质量,施工图审信息查询
 * @author Administrator
 *
 */
public class QualityPlansCondition extends Condition {

	private String censorNum;//审查合格书编号
	private String prjName;//审查时的工程名称
	//项目主键
	private String prjId;
	
	public QualityPlansCondition()
	{
		
	}

	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		
		//查询当前可用单位；
		StringBuffer sb=new StringBuffer(" where prjid='"+this.getPrjId()+"' ");
		

		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censornum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjname like '%"+prjName.trim()+"%'"); 
		}
		
		String sql = "select * from TBProjectCensorInfo  "+sb.toString();
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//查询当前可用单位；
		
		StringBuffer sb=new StringBuffer(" where prjid='"+this.getPrjId()+"' ");
			
		if(censorNum!= null && !"".equals(censorNum)){
			sb.append(" and censornum like '%"+censorNum.trim()+"%'"); 
		}
		
		if(prjName!= null && !"".equals(prjName)){
			sb.append(" and prjname like '%"+prjName.trim()+"%'"); 
		}
		
		String sqlCount="select count(*) from TBProjectCensorInfo  "+sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

}
