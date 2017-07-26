package com.tj.jst.outside.business.complete.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.complete.condition.QueryCompletePrjsCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QueryCompletePrjsAction extends BaseAction {
	
		
	private QueryCompletePrjsCondition condition = new QueryCompletePrjsCondition();
	
	public void setCondition(QueryCompletePrjsCondition condition) {
		this.condition = condition;
	}

	public QueryCompletePrjsCondition getCondition() {
		QueryCompletePrjsCondition sessionCondition = (QueryCompletePrjsCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPrjPage";
	}
	
}
