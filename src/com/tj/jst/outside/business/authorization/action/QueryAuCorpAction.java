package com.tj.jst.outside.business.authorization.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.authorization.condition.QueryAuCorpCondition;
import com.tj.jst.outside.business.authorization.service.AuthorizationServiceImpl;
import com.tj.jst.outside.business.authorization.service.IAuthorizationService;

/**
 * 企业信息查询
 * @author Administrator
 *
 */
public class QueryAuCorpAction extends BaseAction {
	
		
	private QueryAuCorpCondition condition = new QueryAuCorpCondition();
	
	public void setCondition(QueryAuCorpCondition condition) {
		this.condition = condition;
	}

	public QueryAuCorpCondition getCondition() {
		QueryAuCorpCondition sessionCondition = (QueryAuCorpCondition) get(getActionName());
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
		IAuthorizationService service = new AuthorizationServiceImpl();
		//分页查询
		currentPage = service.pagedCorpQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryAuPrjPage";
	}
	
}
