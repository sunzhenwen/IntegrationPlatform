package com.tj.jst.outside.business.constructionFiling.mainContractor.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.mainContractor.condition.TheContractorTitleLeveCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 查询企业施工资质
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		//分页查询
		currentPage = service.pagedTitleLeveQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "theTitleLeve";
	}
	
}
