package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPermQualityCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * 施工许可,质量信息查询
 * @author Administrator
 *
 */
public class QueryPermQualityAction extends BaseAction {
	
	
	private QueryPermQualityCondition condition = new QueryPermQualityCondition();
	
	public void setCondition(QueryPermQualityCondition condition) {
		this.condition = condition;
	}

	public QueryPermQualityCondition getCondition() {
		QueryPermQualityCondition sessionCondition = (QueryPermQualityCondition) get(getActionName());
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
		currentPage = service.pagedQueryQuality(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPermQuality";
	}

}
