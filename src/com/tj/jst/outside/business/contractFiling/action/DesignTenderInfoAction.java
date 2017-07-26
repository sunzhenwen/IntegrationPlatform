package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.condition.DesignTenderInfoCondition;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;

/**
 * 设计合同备案,招投标信息查询
 * @author Administrator
 *
 */
public class DesignTenderInfoAction extends BaseAction {
	
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

	private DesignTenderInfoCondition condition = new DesignTenderInfoCondition();
	
	public void setCondition(DesignTenderInfoCondition condition) {
		this.condition = condition;
	}

	public DesignTenderInfoCondition getCondition() {
		DesignTenderInfoCondition sessionCondition = (DesignTenderInfoCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
