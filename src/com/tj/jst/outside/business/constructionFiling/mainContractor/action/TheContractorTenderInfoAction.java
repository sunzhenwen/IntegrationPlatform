package com.tj.jst.outside.business.constructionFiling.mainContractor.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.mainContractor.condition.TheContractorTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 市建合同备案,招投标信息查询
 * @author Administrator
 *
 */
public class TheContractorTenderInfoAction extends BaseAction {
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();

		//分页查询
		currentPage = service.pagedTbInfoQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryTenderInfo";
	}

	private TheContractorTenderInfoCondition condition = new TheContractorTenderInfoCondition();
	
	public void setCondition(TheContractorTenderInfoCondition condition) {
		this.condition = condition;
	}

	public TheContractorTenderInfoCondition getCondition() {
		TheContractorTenderInfoCondition sessionCondition = (TheContractorTenderInfoCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
