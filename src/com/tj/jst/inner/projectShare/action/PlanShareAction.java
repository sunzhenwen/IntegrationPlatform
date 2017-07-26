package com.tj.jst.inner.projectShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectShare.condition.PlanShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * 施工图审查
 * @author Administrator
 *
 */
public class PlanShareAction extends BaseAction {
	
	private String censorId;// 主键
	private ConstructionPlans plan;// Model类

	private PlanShareCondition condition = new PlanShareCondition();

	public void setCondition(PlanShareCondition condition) {
		this.condition = condition;
	}

	public PlanShareCondition getCondition() {
		PlanShareCondition sessionCondition = (PlanShareCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 设计分页查询
	 * 
	 * @return
	 */
	public String queryPage() {
		IProjectShareService service = new ProjectShareServiceImpl();
		currentPage = service.queryPlanSharePage(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 设计共享详细
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		plan = service.queryPlanShareInfo(censorId);
		return "queryInfo";
	}
	
	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "goPage";
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

}
