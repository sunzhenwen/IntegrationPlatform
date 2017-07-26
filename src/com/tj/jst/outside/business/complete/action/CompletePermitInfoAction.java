package com.tj.jst.outside.business.complete.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.complete.condition.CompletePermitInfoCondition;
import com.tj.jst.outside.business.complete.service.CompleteServiceImpl;
import com.tj.jst.outside.business.complete.service.ICompleteService;

/**
 * 竣工验收,施工许可信息查询
 * @author Administrator
 *
 */
public class CompletePermitInfoAction extends BaseAction {


	private CompletePermitInfoCondition condition = new CompletePermitInfoCondition();
	
	public void setCondition(CompletePermitInfoCondition condition) {
		this.condition = condition;
	}

	public CompletePermitInfoCondition getCondition() {
		CompletePermitInfoCondition sessionCondition = (CompletePermitInfoCondition) get(getActionName());
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
		ICompleteService service = new CompleteServiceImpl();

		//分页查询
		currentPage = service.pagedTbInfoQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "completePermit";
	}

}
