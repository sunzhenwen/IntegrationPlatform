package com.tj.jst.inner.business.surveyapply.action;

import java.sql.Date;
import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.business.surveyapply.condition.SurveyApplyCondition;
import com.tj.jst.inner.business.surveyapply.condition.SurveyQualificationCondition;
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;
import com.tj.jst.inner.business.surveyapply.service.ISurveyApplyService;
import com.tj.jst.inner.business.surveyapply.service.SurveyApplyServiceImpl;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.upload.model.Upload;

public class SurveyApplyAction extends BaseAction {

	// 勘察model类
	private SurveyApply project;
	// 项目名称
	private String prjName;
	// 立项文号
	private String prjApprovalNum;
	// 建设单位名称
	private String buildCorpName;
	// 建设单位组织机构代码证
	private String buildCorpCode;
	// 主键
	private String surveyId;
	// 返回提示信息
	private String message;

	private List<Upload> list;

	private SurveyApplyCondition condition = new SurveyApplyCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(SurveyApplyCondition condition) {
		this.condition = condition;
	}

	public SurveyApplyCondition getCondition() {
		SurveyApplyCondition sessionCondition = (SurveyApplyCondition) get(getActionName());
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
	public String queryPage() {
		ISurveyApplyService service = new SurveyApplyServiceImpl();
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
		ISurveyApplyService service = new SurveyApplyServiceImpl();
		project = service.queryApproval(surveyId);
		list = service.downloadInfo(surveyId);
		SurveyQualificationCondition scondition = new SurveyQualificationCondition(
				surveyId);
		currentPage = service.sidebyPage(scondition);
		// 判断是否含有审批附页
		if (currentPage.getTotalCount() > 0) {
			project.setUnitMark("1");
		}
		return "approvalPage";
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public String applySuccess() {
		ISurveyApplyService service = new SurveyApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applySuccess(project);
		return "query";
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public String applyFaile() {
		ISurveyApplyService service = new SurveyApplyServiceImpl();
		Login login = (Login) this.get("login");
		project.setAppSteffId(login.getDepartmentID());
		project.setAppSteffName(login.getDepartment());
		project.setAppDate(new Date(new java.util.Date().getTime()));
		message = service.applyFaile(project);
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

	public SurveyApply getProject() {
		return project;
	}

	public void setProject(SurveyApply project) {
		this.project = project;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjApprovalNum() {
		return prjApprovalNum;
	}

	public void setPrjApprovalNum(String prjApprovalNum) {
		this.prjApprovalNum = prjApprovalNum;
	}

	public String getBuildCorpName() {
		return buildCorpName;
	}

	public void setBuildCorpName(String buildCorpName) {
		this.buildCorpName = buildCorpName;
	}

	public String getBuildCorpCode() {
		return buildCorpCode;
	}

	public void setBuildCorpCode(String buildCorpCode) {
		this.buildCorpCode = buildCorpCode;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Upload> getList() {
		return list;
	}

	public void setList(List<Upload> list) {
		this.list = list;
	}

}
