package com.tj.jst.inner.business.planapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.planapply.condition.PlanHistoryCondition;
import com.tj.jst.inner.business.planapply.service.IPlanApplyService;
import com.tj.jst.inner.business.planapply.service.PlanApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

public class PlanHistoryAction extends BaseAction {
	private String censorId;// 主键
	private ConstructionPlans plan;// Model类
	private String message;// 返回信息

	private PlanHistoryCondition condition = new PlanHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(PlanHistoryCondition condition) {
		this.condition = condition;
	}

	public PlanHistoryCondition getCondition() {
		PlanHistoryCondition sessionCondition = (PlanHistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 审批查询页面
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * 跳转详细页面
	 * 
	 * @return
	 */
	public String queryHistory() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		plan = service.queryApproval(censorId);
		return "info";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getCensorId() {
		return censorId;
	}

	public void setCensorId(String censorId) {
		this.censorId = censorId;
	}

	public ConstructionPlans getPlan() {
		return plan;
	}

	public void setPlan(ConstructionPlans plan) {
		this.plan = plan;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
