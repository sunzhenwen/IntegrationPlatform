package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QueryPrjsCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��Ŀ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QueryPrjsAction extends BaseAction {
	
		
	private QueryPrjsCondition condition = new QueryPrjsCondition();
	
	public void setCondition(QueryPrjsCondition condition) {
		this.condition = condition;
	}

	public QueryPrjsCondition getCondition() {
		QueryPrjsCondition sessionCondition = (QueryPrjsCondition) get(getActionName());
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
