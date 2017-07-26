package com.tj.jst.outside.business.complete.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.complete.condition.CompletePermitInfoCondition;
import com.tj.jst.outside.business.complete.service.CompleteServiceImpl;
import com.tj.jst.outside.business.complete.service.ICompleteService;

/**
 * ��������,ʩ�������Ϣ��ѯ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ICompleteService service = new CompleteServiceImpl();

		//��ҳ��ѯ
		currentPage = service.pagedTbInfoQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "completePermit";
	}

}
