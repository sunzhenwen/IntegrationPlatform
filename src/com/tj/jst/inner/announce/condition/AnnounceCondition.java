package com.tj.jst.inner.announce.condition;

import com.tj.jst.base.page.Condition;

/**
 * 发布信息分页类
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceCondition extends Condition {

	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	private String announceName;// 发布信息名称

	public AnnounceCondition() {

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
		if (announceName != null && !"".equals(announceName)) {
			sb.append(" and TITLE like '%" + announceName.trim() + "%'");
		}
		String sql = "select * from TB_ANNOUNCE " + sb.toString();
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
		if (announceName != null && !"".equals(announceName)) {
			sb.append(" and TITLE like '%" + announceName.trim() + "%'");
		}
		String sqlCount = "select count(*) from TB_ANNOUNCE " + sb.toString();
		return sqlCount;
	}

	public String getAnnounceName() {
		return announceName;
	}

	public void setAnnounceName(String announceName) {
		this.announceName = announceName;
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

}
