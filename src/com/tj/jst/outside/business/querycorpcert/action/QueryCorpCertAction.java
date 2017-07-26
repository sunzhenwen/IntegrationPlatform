package com.tj.jst.outside.business.querycorpcert.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.querycorpcert.condition.QueryCorpCertCondition;
import com.tj.jst.outside.business.querycorpcert.service.IQueryCorpCertService;
import com.tj.jst.outside.business.querycorpcert.service.QueryCorpCertServiceImpl;

/**
 * ��ѯ��ҵӵ������
 * 
 * @author Administrator
 *
 */
public class QueryCorpCertAction extends BaseAction {

	private String corpCode;// ��ҵ��֯��������֤
	private String message;// ������Ϣ

	private QueryCorpCertCondition condition = new QueryCorpCertCondition();

	public void setCondition(QueryCorpCertCondition condition) {
		this.condition = condition;
	}

	public QueryCorpCertCondition getCondition() {
		QueryCorpCertCondition sessionCondition = (QueryCorpCertCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ�鿴
	 * 
	 * @return
	 */
	public String queryPage() {
		IQueryCorpCertService service = new QueryCorpCertServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "goBusiness";
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
