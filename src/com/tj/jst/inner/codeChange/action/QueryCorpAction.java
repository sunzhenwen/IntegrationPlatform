package com.tj.jst.inner.codeChange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.codeChange.condition.QueryCorpCondition;
import com.tj.jst.inner.codeChange.service.IQueryCorpService;
import com.tj.jst.inner.codeChange.service.QueryCorpServiceImpl;

/**
 * 查询企业
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
	 * 查询全部变更记录
	 * @return
	 */
	public String queryPage()
	{
		IQueryCorpService service = new QueryCorpServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

}
