package com.tj.jst.outside.business.querycorpcert.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.querycorpcert.condition.QueryCorpCertCondition;
import com.tj.jst.outside.business.querycorpcert.service.IQueryCorpCertService;
import com.tj.jst.outside.business.querycorpcert.service.QueryCorpCertServiceImpl;

/**
 * 查询企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryCorpCertAction extends BaseAction {

	private String corpCode;// 企业组织机构代码证
	private String message;// 返回信息

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
	 * 分页查看
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
	 * 返回
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
