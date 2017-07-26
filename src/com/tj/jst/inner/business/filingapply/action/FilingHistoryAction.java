package com.tj.jst.inner.business.filingapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.filingapply.condition.FilingHistoryCondition;
import com.tj.jst.inner.business.filingapply.service.FilingApplyServiceImpl;
import com.tj.jst.inner.business.filingapply.service.IFilingApplyService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

public class FilingHistoryAction extends BaseAction {

	private String recordId;// ����
	private ContractFiling filing;// Model��
	private String message;// ��ʾ��Ϣ

	private FilingHistoryCondition condition = new FilingHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(FilingHistoryCondition condition) {
		this.condition = condition;
	}

	public FilingHistoryCondition getCondition() {
		FilingHistoryCondition sessionCondition = (FilingHistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryHistoryPage";
	}

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	public String queryHistory() {
		IFilingApplyService service = new FilingApplyServiceImpl();
		filing = service.queryApproval(recordId);
		return "info";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public ContractFiling getFiling() {
		return filing;
	}

	public void setFiling(ContractFiling filing) {
		this.filing = filing;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
