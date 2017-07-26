package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPermSafetyCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * ʩ�����,��ȫ��Ϣ��ѯ
 * @author Administrator
 *
 */
public class QueryPermSafetyAction extends BaseAction {
	

	private QueryPermSafetyCondition condition = new QueryPermSafetyCondition();
	
	public void setCondition(QueryPermSafetyCondition condition) {
		this.condition = condition;
	}

	public QueryPermSafetyCondition getCondition() {
		QueryPermSafetyCondition sessionCondition = (QueryPermSafetyCondition) get(getActionName());
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
		IPermitService service = new PermitServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQueryPermSafety(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPermSafety";
	}

}
