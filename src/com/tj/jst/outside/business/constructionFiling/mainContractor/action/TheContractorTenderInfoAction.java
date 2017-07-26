package com.tj.jst.outside.business.constructionFiling.mainContractor.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.mainContractor.condition.TheContractorTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * �н���ͬ����,��Ͷ����Ϣ��ѯ
 * @author Administrator
 *
 */
public class TheContractorTenderInfoAction extends BaseAction {
	
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
