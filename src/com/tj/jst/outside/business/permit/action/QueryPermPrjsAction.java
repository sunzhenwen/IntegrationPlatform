package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.permit.condition.QueryPermPrjsCondition;

/**
 * ��Ŀ��Ϣ��ѯ
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
