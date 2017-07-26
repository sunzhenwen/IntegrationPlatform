package com.tj.jst.inner.business.promiseapply.action;

import java.sql.Date;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.promiseapply.condition.PromiseHistoryCondition;
import com.tj.jst.inner.business.promiseapply.service.IPromiseApplyService;
import com.tj.jst.inner.business.promiseapply.service.PromiseApplyServiceImpl;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.service.IProjectConstructionService;
import com.tj.jst.inner.projectconstruction.service.ProjectConstructionServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.permit.model.Permit;

public class PromiseHistoryAction extends BaseAction {
	private String permitId;// 查询主键
	private Permit permit;// Model类
	private String message;// 提示信息
	private ProjectConstruction projectConstruction;
	
	private PromiseHistoryCondition condition = new PromiseHistoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(PromiseHistoryCondition condition) {
		this.condition = condition;
	}

	public PromiseHistoryCondition getCondition() {
		PromiseHistoryCondition sessionCondition = (PromiseHistoryCondition) get(getActionName());
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
		IPromiseApplyService service = new PromiseApplyServiceImpl();
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
		IPromiseApplyService service = new PromiseApplyServiceImpl();
		permit = service.queryApproval(permitId);
		java.util.Date date=new java.util.Date();
		permit.setIssueCertDate( new Date(date.getTime()));
		IProjectConstructionService projectConstructionService = new ProjectConstructionServiceImpl();
		projectConstruction = projectConstructionService.getProjectInfo(permit.getPrjNum());
		
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

	public String getPermitId() {
		return permitId;
	}

	public void setPermitId(String permitId) {
		this.permitId = permitId;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProjectConstruction getProjectConstruction() {
		return projectConstruction;
	}

	public void setProjectConstruction(ProjectConstruction projectConstruction) {
		this.projectConstruction = projectConstruction;
	}

}
