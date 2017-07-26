package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.QuerySurveyTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��ѯ��ҵ��������
 * @author Administrator
 *
 */
public class QuerySurveyTitleLeveAction extends BaseAction {
	
		
	private QuerySurveyTitleLeveCondition condition = new QuerySurveyTitleLeveCondition();
	
	public void setCondition(QuerySurveyTitleLeveCondition condition) {
		this.condition = condition;
	}

	public QuerySurveyTitleLeveCondition getCondition() {
		QuerySurveyTitleLeveCondition sessionCondition = (QuerySurveyTitleLeveCondition) get(getActionName());
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
		return "surveyTitleLeve";
	}
	
}
