package com.tj.jst.inner.industryStandard.condition;

import com.tj.jst.base.page.Condition;

/**
 * 行业标准
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandardCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	private String title;// 发布信息名称
	private String isType;// 发布种类
	private String isPublish;// 是否发布

	public IndustryStandardCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1 = 1 ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if (title != null && !"".equals(title)) {
			sb.append(" and TITLE like '%" + title.trim() + "%'");
		}
		if (isType != null && !"".equals(isType)) {
			sb.append(" and isType='"+isType+"' ");
		}
		if (isPublish != null && !"".equals(isPublish)) {
			sb.append(" and isPublish='"+isPublish+"' ");
		}
		String sql = "select * from INDUSTRY_STANDARD " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where 1 = 1 ");
		if(startDate!= null && !"".equals(startDate)){
			sb.append(" and CREATEDATE >= to_date('"+startDate+"','yyyy/mm/dd')"); 
		}
		if(endDate != null && !"".equals(endDate)){
			sb.append(" and CREATEDATE <= to_date('"+endDate+"','yyyy/mm/dd')");
		}
		if (title != null && !"".equals(title)) {
			sb.append(" and TITLE like '%" + title.trim() + "%'");
		}
		if (isType != null && !"".equals(isType)) {
			sb.append(" and isType='"+isType+"' ");
		}
		if (isPublish != null && !"".equals(isPublish)) {
			sb.append(" and isPublish='"+isPublish+"' ");
		}
		String sqlCount = "select count(*) from INDUSTRY_STANDARD " + sb.toString();
		return sqlCount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsType() {
		return isType;
	}

	public void setIsType(String isType) {
		this.isType = isType;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

}
