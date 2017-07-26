package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.integrity.corpBadIntegrity.condition.QueryCreditCodeCondition;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.IQueryCreditCodeService;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.QueryCreditCodeServiceImpl;

/**
 * ������Ϊ����
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IQueryCreditCodeService service = new QueryCreditCodeServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}
	
}
