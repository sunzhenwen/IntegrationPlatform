package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QueryDesignTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 查询企业设计资质
 * @author Administrator
 *
 */
public class QueryDesignTitleLeveAction extends BaseAction {
	
		
	private QueryDesignTitleLeveCondition condition = new QueryDesignTitleLeveCondition();
	
	public void setCondition(QueryDesignTitleLeveCondition condition) {
		this.condition = condition;
	}

	public QueryDesignTitleLeveCondition getCondition() {
		QueryDesignTitleLeveCondition sessionCondition = (QueryDesignTitleLeveCondition) get(getActionName());
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
		return "designTitleLeve";
	}
	
}
