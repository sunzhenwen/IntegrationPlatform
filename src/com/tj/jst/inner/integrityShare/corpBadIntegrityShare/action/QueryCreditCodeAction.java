package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.integrity.corpBadIntegrity.condition.QueryCreditCodeCondition;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.IQueryCreditCodeService;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.QueryCreditCodeServiceImpl;

/**
 * 不良行为代码
 * @author Administrator
 *
 */
public class QueryCreditCodeAction extends BaseAction {
	

	private QueryCreditCodeCondition condition = new QueryCreditCodeCondition();
	
	public void setCondition(QueryCreditCodeCondition condition) {
		this.condition = condition;
	}

	public QueryCreditCodeCondition getCondition() {
		QueryCreditCodeCondition sessionCondition = (QueryCreditCodeCondition) get(getActionName());
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
		IQueryCreditCodeService service = new QueryCreditCodeServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
}
