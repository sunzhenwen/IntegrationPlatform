package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPermSafetyCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * 施工许可,安全信息查询
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IPermitService service = new PermitServiceImpl();
		//分页查询
		currentPage = service.pagedQueryPermSafety(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPermSafety";
	}

}
