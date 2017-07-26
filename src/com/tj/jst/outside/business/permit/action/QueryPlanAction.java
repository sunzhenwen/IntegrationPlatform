package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPlanCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * ʩ�����,ʩ��ͼ���ϸ�����
 * @author Administrator
 *
 */
public class QueryPlanAction extends BaseAction {
	
	
	private QueryPlanCondition condition = new QueryPlanCondition();
	
	public void setCondition(QueryPlanCondition condition) {
		this.condition = condition;
	}

	public QueryPlanCondition getCondition() {
		QueryPlanCondition sessionCondition = (QueryPlanCondition) get(getActionName());
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
		currentPage = service.pagedQueryPlanNum(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPlanNum";
	}

}
