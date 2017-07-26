package com.tj.jst.inner.business.readyapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.readyapply.condition.ReadyHistoryCondition;
import com.tj.jst.inner.business.readyapply.service.IReadyApplyService;
import com.tj.jst.inner.business.readyapply.service.ReadyApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.complete.model.Complete;

public class ReadyHistoryAction extends BaseAction {
	private String completeId;// 查询主键
	private Complete complete;// Model类
	private String message;// 返回消息

	private ReadyHistoryCondition condition = new ReadyHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(ReadyHistoryCondition condition) {
		this.condition = condition;
	}

	public ReadyHistoryCondition getCondition() {
		ReadyHistoryCondition sessionCondition = (ReadyHistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 审批查询页面
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		IReadyApplyService service = new ReadyApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String queryHistory() {
		IReadyApplyService service = new ReadyApplyServiceImpl();
		complete = service.queryApproval(completeId);
		return "info";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getCompleteId() {
		return completeId;
	}

	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}

	public Complete getComplete() {
		return complete;
	}

	public void setComplete(Complete complete) {
		this.complete = complete;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
