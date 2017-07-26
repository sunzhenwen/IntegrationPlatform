package com.tj.jst.outside.business.constructionFiling.mainContractor.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.mainContractor.condition.TheContractorTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * ��ѯ��ҵʩ������
 * @author Administrator
 *
 */
public class TheContractorTitleLeveAction extends BaseAction {
	
		
	private TheContractorTitleLeveCondition condition = new TheContractorTitleLeveCondition();
	
	public void setCondition(TheContractorTitleLeveCondition condition) {
		this.condition = condition;
	}

	public TheContractorTitleLeveCondition getCondition() {
		TheContractorTitleLeveCondition sessionCondition = (TheContractorTitleLeveCondition) get(getActionName());
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
		return "theTitleLeve";
	}
	
}
