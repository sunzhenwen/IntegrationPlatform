package com.tj.jst.inner.querycorpreport.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.querycorpreport.condition.QueryCorpReportCondition;
import com.tj.jst.inner.querycorpreport.service.IQueryCorpReportService;
import com.tj.jst.inner.querycorpreport.service.QueryCorpReportServiceImpl;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

public class QueryCorpReportAction extends BaseAction {

	private String id;// 查询主键
	private CorpReport corpReport;// Model类

	private QueryCorpReportCondition condition = new QueryCorpReportCondition();

	public void setCondition(QueryCorpReportCondition condition) {
		this.condition = condition;
	}

	public QueryCorpReportCondition getCondition() {
		QueryCorpReportCondition sessionCondition = (QueryCorpReportCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询主页
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryCorpReportService service = new QueryCorpReportServiceImpl();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 查看详细
	 * 
	 * @return
	 */
	public String queryInfo() {
		IQueryCorpReportService service = new QueryCorpReportServiceImpl();
		corpReport = service.queryInfo(id);
		return "queryInfo";
	}

	/**
	 * 返回方法
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CorpReport getCorpReport() {
		return corpReport;
	}

	public void setCorpReport(CorpReport corpReport) {
		this.corpReport = corpReport;
	}

}
