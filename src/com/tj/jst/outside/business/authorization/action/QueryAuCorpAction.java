package com.tj.jst.outside.business.authorization.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.authorization.condition.QueryAuCorpCondition;
import com.tj.jst.outside.business.authorization.service.AuthorizationServiceImpl;
import com.tj.jst.outside.business.authorization.service.IAuthorizationService;

/**
 * ��ҵ��Ϣ��ѯ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedCorpQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryAuPrjPage";
	}
	
}
