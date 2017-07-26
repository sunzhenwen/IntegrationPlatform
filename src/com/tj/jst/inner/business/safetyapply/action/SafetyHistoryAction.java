package com.tj.jst.inner.business.safetyapply.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.safetyapply.condition.SafetyHistoryCondition;
import com.tj.jst.inner.business.safetyapply.service.ISafetyApplyService;
import com.tj.jst.inner.business.safetyapply.service.SafetyApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.safety.model.Safety;

public class SafetyHistoryAction extends BaseAction {
	private String safetyId;// 主键
	private Safety safety;// Model类
	private String message;// 提心信息
	private String typeName;// 工程类型

	private SafetyHistoryCondition condition = new SafetyHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(SafetyHistoryCondition condition) {
		this.condition = condition;
	}

	public SafetyHistoryCondition getCondition() {
		SafetyHistoryCondition sessionCondition = (SafetyHistoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryHistoryPage() {
		ISafetyApplyService service = new SafetyApplyServiceImpl();
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
		ISafetyApplyService service = new SafetyApplyServiceImpl();
		safety = service.queryApproval(safetyId);
		typeName = service.queryTypeName(safety.getProjectType());
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

	public String getSafetyId() {
		return safetyId;
	}

	public void setSafetyId(String safetyId) {
		this.safetyId = safetyId;
	}

	public Safety getSafety() {
		return safety;
	}

	public void setSafety(Safety safety) {
		this.safety = safety;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
