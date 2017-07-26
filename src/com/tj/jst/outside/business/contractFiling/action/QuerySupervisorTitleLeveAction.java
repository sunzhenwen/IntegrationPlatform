package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QuerySupervisorTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 查询企业勘察资质
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//分页查询
		currentPage = service.pagedTitleLeveQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "supervisorTitleLeve";
	}
	
}
