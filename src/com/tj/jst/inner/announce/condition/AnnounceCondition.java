package com.tj.jst.inner.announce.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������Ϣ��ҳ��
 * 
 * @author DarkFlameMaster
 *
 */
public class AnnounceCondition extends Condition {

	//��ʼʱ��
	private String startDate;
	//����ʱ��
	private String endDate;
	private String announceName;// ������Ϣ����

	public AnnounceCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		this.setOrderByItem(" CREATEDATE desc ");
		// ��ѯ��ǰ���õ�λ��
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
		// ��ѯ��ǰ���õ�λ��
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
