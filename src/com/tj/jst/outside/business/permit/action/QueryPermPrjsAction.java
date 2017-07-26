package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.permit.condition.QueryPermPrjsCondition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QueryPermPrjsAction extends BaseAction {
	
		
	private QueryPermPrjsCondition condition = new QueryPermPrjsCondition();
	
	public void setCondition(QueryPermPrjsCondition condition) {
		this.condition = condition;
	}

	public QueryPermPrjsCondition getCondition() {
		QueryPermPrjsCondition sessionCondition = (QueryPermPrjsCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPrjPage";
	}
	
}
