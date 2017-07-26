package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.SupervisorTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 监理合同备案,招投标信息查询
 * @author Administrator
 *
 */
public class SupervisorTenderInfoAction extends BaseAction {
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();

		//分页查询
		currentPage = service.pagedTbInfoQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryTenderInfo";
	}

	private SupervisorTenderInfoCondition condition = new SupervisorTenderInfoCondition();
	
	public void setCondition(SupervisorTenderInfoCondition condition) {
		this.condition = condition;
	}

	public SupervisorTenderInfoCondition getCondition() {
		SupervisorTenderInfoCondition sessionCondition = (SupervisorTenderInfoCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
