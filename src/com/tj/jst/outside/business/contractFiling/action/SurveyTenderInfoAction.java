package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.SurveyTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * �����ͬ����,��Ͷ����Ϣ��ѯ
 * @author Administrator
 *
 */
public class SurveyTenderInfoAction extends BaseAction {
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();

		//��ҳ��ѯ
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
