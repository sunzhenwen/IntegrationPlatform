package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.SurveyTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 勘察合同备案,招投标信息查询
 * @author Administrator
 *
 */
public class SurveyTenderInfoAction extends BaseAction {
	
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

	private SurveyTenderInfoCondition condition = new SurveyTenderInfoCondition();
	
	public void setCondition(SurveyTenderInfoCondition condition) {
		this.condition = condition;
	}

	public SurveyTenderInfoCondition getCondition() {
		SurveyTenderInfoCondition sessionCondition = (SurveyTenderInfoCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
