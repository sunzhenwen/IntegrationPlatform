package com.tj.jst.inner.business.planapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.planapply.condition.PlanApplyCondition;
import com.tj.jst.inner.business.planapply.service.IPlanApplyService;
import com.tj.jst.inner.business.planapply.service.PlanApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工图审查审批方法
 * 
 * @author DarkFlameMaster
 *
 */
public class PlanApplyAction extends BaseAction {

	private String censorId;// 主键
	private ConstructionPlans plan;// Model类
	private String message;// 返回信息
	// 下载列表
	private List<Upload> downloadlist;

	private PlanApplyCondition condition = new PlanApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(PlanApplyCondition condition) {
		this.condition = condition;
	}

	public PlanApplyCondition getCondition() {
		PlanApplyCondition sessionCondition = (PlanApplyCondition) get(getActionName());
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
	public String queryPage() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		currentPage = service.pagedQuery(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转审批页面
	 * 
	 * @return
	 */
	public String queryapproval() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		plan = service.queryApproval(censorId);
		downloadlist = service.downloadInfo(censorId);
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String approvalSuccess() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		Login login = (Login) this.get("login");
		plan.setAppDate(new Date(new java.util.Date().getTime()));
		plan.setAppSteffId(login.getPersonalID());
		plan.setAppSteffName(login.getName());
		message = service.approvalSuccess(plan);
		if (message.equals("成功")) {
			message = service.queryFiling(plan.getPrjNum());
			if (message.equals("成功")) {
				service.updateProjectInfo(plan.getPrjNum());
				//message = service.changeAuthor(plan.getPrjNum());//更改授权状态
			}
		}
		return "query";
	}

	/**
	 * 审批不通过
	 * 
	 * @return
	 */
	public String approvalFailed() {
		IPlanApplyService service = new PlanApplyServiceImpl();
		Login login = (Login) this.get("login");
		plan.setAppDate(new Date(new java.util.Date().getTime()));
		plan.setAppSteffId(login.getPersonalID());
		plan.setAppSteffName(login.getName());
		message = service.approvalFailed(plan);
		return "query";
	}

	/**
	 * 返回
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getCensorId() {
		return censorId;
	}

	public void setCensorId(String censorId) {
		this.censorId = censorId;
	}

	public ConstructionPlans getPlan() {
		return plan;
	}

	public void setPlan(ConstructionPlans plan) {
		this.plan = plan;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Upload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<Upload> downloadlist) {
		this.downloadlist = downloadlist;
	}

}
