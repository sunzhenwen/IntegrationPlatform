package com.tj.jst.outside.business.authorization.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.authorization.condition.QueryAuPrjsCondition;
import com.tj.jst.outside.business.authorization.service.AuthorizationServiceImpl;
import com.tj.jst.outside.business.authorization.service.IAuthorizationService;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class QueryAuPrjsAction extends BaseAction {
	
		
	private QueryAuPrjsCondition condition = new QueryAuPrjsCondition();
	
	public void setCondition(QueryAuPrjsCondition condition) {
		this.condition = condition;
	}

	public QueryAuPrjsCondition getCondition() {
		QueryAuPrjsCondition sessionCondition = (QueryAuPrjsCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedPrjQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryAuPrjPage";
	}
	
}
