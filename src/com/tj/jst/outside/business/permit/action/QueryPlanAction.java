package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPlanCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * 施工许可,施工图审查合格书编号
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IPermitService service = new PermitServiceImpl();

		//分页查询
		currentPage = service.pagedQueryPlanNum(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPlanNum";
	}

}
