package com.tj.jst.inner.projectShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.projectShare.condition.PlanShareCondition;
import com.tj.jst.inner.projectShare.service.IProjectShareService;
import com.tj.jst.inner.projectShare.service.ProjectShareServiceImpl;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

/**
 * ʩ��ͼ���
 * @author Administrator
 *
 */
public class PlanShareAction extends BaseAction {
	
	private String censorId;// ����
	private ConstructionPlans plan;// Model��

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
	 * ��Ʒ�ҳ��ѯ
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
	 * ��ƹ�����ϸ
	 * @return
	 */
	public String queryInfo() {
		IProjectShareService service = new ProjectShareServiceImpl();
		plan = service.queryPlanShareInfo(censorId);
		return "queryInfo";
	}
	
	/**
	 * ����
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
