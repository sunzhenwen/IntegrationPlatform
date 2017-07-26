package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QueryDesignTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��ѯ��ҵ�������
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedTitleLeveQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "designTitleLeve";
	}
	
}
