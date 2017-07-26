package com.tj.jst.outside.business.permit.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.permit.condition.QueryPermQualityCondition;
import com.tj.jst.outside.business.permit.service.IPermitService;
import com.tj.jst.outside.business.permit.service.PermitServiceImpl;

/**
 * ʩ�����,������Ϣ��ѯ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IPermitService service = new PermitServiceImpl();

		//��ҳ��ѯ
		currentPage = service.pagedQueryQuality(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPermQuality";
	}

}
