package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.SupervisorTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * �����ͬ����,��Ͷ����Ϣ��ѯ
 * @author Administrator
 *
 */
public class SupervisorTenderInfoAction extends BaseAction {
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();

		//��ҳ��ѯ
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
