package com.tj.jst.outside.staffmanage.threeTypePerson.condition;

import com.tj.jst.base.page.Condition;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public class ThreePersonCondition extends Condition {

	//人员名称
	private String FName;
	//证件号码
	private String FIdCertNo;
	//企业id
	private String corpId;
	
	//查询语句
	@Override
	public String getInitialSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
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

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		//this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		//查询当前可用单位；
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
