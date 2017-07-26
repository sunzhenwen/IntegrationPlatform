package com.tj.jst.inner.codeChange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.codeChange.condition.QueryCorpCondition;
import com.tj.jst.inner.codeChange.service.IQueryCorpService;
import com.tj.jst.inner.codeChange.service.QueryCorpServiceImpl;

/**
 * ��ѯ��ҵ
 * @author hhc 2016-04-21
 *
 */
public class QueryCorpAction extends BaseAction {
	
	private QueryCorpCondition condition = new QueryCorpCondition();
	
	public void setCondition(QueryCorpCondition condition) {
		this.condition = condition;
	}

	public QueryCorpCondition getCondition() {
		QueryCorpCondition sessionCondition = (QueryCorpCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯȫ�������¼
	 * @return
	 */
	public String queryPage()
	{
		IQueryCorpService service = new QueryCorpServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

}
