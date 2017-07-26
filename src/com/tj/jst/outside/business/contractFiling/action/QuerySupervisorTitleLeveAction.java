package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QuerySupervisorTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��ѯ��ҵ��������
 * @author Administrator
 *
 */
public class QuerySupervisorTitleLeveAction extends BaseAction {
	
		
	private QuerySupervisorTitleLeveCondition condition = new QuerySupervisorTitleLeveCondition();
	
	public void setCondition(QuerySupervisorTitleLeveCondition condition) {
		this.condition = condition;
	}

	public QuerySupervisorTitleLeveCondition getCondition() {
		QuerySupervisorTitleLeveCondition sessionCondition = (QuerySupervisorTitleLeveCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedTitleLeveQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "supervisorTitleLeve";
	}
	
}
